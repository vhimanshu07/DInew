package com.example.dinew

import com.example.dinew.annotations.MessageQualifier
import javax.inject.Inject
import javax.inject.Named

/**
 *
 * This service doesn't follow single responsibility principle as we have both objects of different class
 *
 *
 */
/*
class UserRegistrationService {

    private val userRepository = UserRepository()
    private val emailService = EmailService()
    fun register(email: String, password: String) {
        userRepository.saveUser(email, password)
        emailService.send(email, "xyz@gmail.com", "Registration Done")
    }

}
*/


/**
 *
 * Now we have injected other class to it
 *
 */

//class UserRegistrationService @Inject constructor(
//    private val userRepository: UserRepository,
//    private val emailService: EmailService,
//) {
//
//    fun register(email: String, password: String) {
//        userRepository.saveUser(email, password)
//        emailService.send(email, "xyz@gmail.com", "Registration Done")
//    }
//
//}

/**
 *
 * 5.
 * Changes done for de coupling
 *
 */
//class UserRegistrationService @Inject constructor(
//    private val userRepository: UserRepository,
//    private val emailService: NotificationService,
//) {
//
//    fun register(email: String, password: String) {
//        userRepository.saveUser(email, password)
//        emailService.send(email, "xyz@gmail.com", "Registration Done")
//    }
//
//}
/**
 *
 * 6.
 *  After this decoupling is done, as we have used Interface here so dagger doesn't know what to do with it.
 *
 * As we can either provide injection through constructor injection (i.e while creating object of the class)
 * But in case of interface it is not possible so we will make use of module now.
 *
 *  So now we will make a Module ( UserRepository Module)
 *
 */



//class UserRegistrationService @Inject constructor(
//    private val userRepository: UserRepository,
//    @Named("email")private val emailService: NotificationService,
//) {
//
//    fun register(email: String, password: String) {
//        userRepository.saveUser(email, password)
//        emailService.send(email, "xyz@gmail.com", "Registration Done")
//    }
//}
/**
 *
 * 12. Now we have to add @Named in front of Notification Service to tell which part of object I need , as now It has two object
 * present in one module
 *
 * But it can have typo , as we have to change this @Named and it's text at two place, one where we are providing the object
 * second where we are consuming the object.
 *
 * So for it we will create our owm annotations by using @Annotations
 *
 * 13. check annotations
 *
 */




class UserRegistrationService @Inject constructor(
    private val userRepository: UserRepository,
   @MessageQualifier private val emailService: NotificationService,
) {

    fun register(email: String, password: String) {
        userRepository.saveUser(email, password)
        emailService.send(email, "xyz@gmail.com", "Registration Done")
    }
}
/**
 *
 * 14. after building annotation
 *
 *
 */


