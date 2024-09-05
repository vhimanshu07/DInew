package com.example.dinew.module

import com.example.dinew.EmailService
import com.example.dinew.MessageService
import com.example.dinew.NotificationService
import com.example.dinew.annotations.MessageQualifier
import dagger.Module
import dagger.Provides
import javax.inject.Named


/**
 *
 * After 6. of UserRegistrationService come here.
 *
 */

//@Module
//class NotificationServiceModule {
//
//    @Provides
//    fun getMessageService (): NotificationService {
//        return MessageService()
//    }
//
//}

/**
 *
 * 7.
 * After creating this module we have to notify the component that we have made modules
 *
 * Go to UserRegistrationComponent
 *
 */


//@Module
//class NotificationServiceModule {
//
//    @Provides
//    fun getMessageService (): NotificationService {
//        return MessageService()
//    }
//    @Provides
//    fun getEmailService(emailService: EmailService):NotificationService{
//        return emailService
//    }
//
//}


/**
 *
 *
 * 10.
 * So now new requirement came up that I need both Repository of notification service (message  and email), but
 * currently in this above way we can't do it, we can give only one repository else try this :--
 *
 *
 *
 * @Module
class NotificationServiceModule {

@Provides
fun getMessageService (): NotificationService {
return MessageService()
}
@Provides
fun getEmailService(emailService: EmailService):NotificationService{
return emailService
}

}



It will give error related to dagger.
Duplicate binding

 */


/**
 *
 * 11.
 * So now New Thing come up @Named "it is a qualifier" which identifies which object I need so by writing @Named on top of
 * them we are doing it.
 *
 */

//
//@Module
//class NotificationServiceModule {
//
//    @Named("message")
//    @Provides
//    fun getMessageService (): NotificationService {
//        return MessageService()
//    }
//    @Named("email")
//    @Provides
//    fun getEmailService(emailService: EmailService):NotificationService{
//        return emailService
//    }
//
//}
/**
 *
 * 12. Go to User registration service, u will have to tell what Qualifier you are using.
 *
 */


/**
 *
 *
 * 14. after user registration service changes.... change annotation here too.
 *
 */

//
//@Module
//class NotificationServiceModule {
//
//    @MessageQualifier
//    @Provides
//    fun getMessageService (): NotificationService {
//        return MessageService()
//    }
//    @Named("email")
//    @Provides
//    fun getEmailService(emailService: EmailService):NotificationService{
//        return emailService
//    }
//
//}


/**
 *
 * 15. now there are some values we get at runtime , for ex. application context, we get at run time
 * but if we want to a object which uses (lets say application context) make it from dagger then how to do it?
 * So go to emailService , add a retry count there , but now here too we need to pass some value here
 * So one way is we pass hard coded value in from line 161 or we can pass value in module  and give 161 that variable too.
 *
 *
 */


//@Module
//class NotificationServiceModule(private val retryCount: Int) {
//
//    @MessageQualifier
//    @Provides
//    fun getMessageService(): NotificationService {
//        return MessageService(retryCount)
//    }
//
//    @Named("email")
//    @Provides
//    fun getEmailService(emailService: EmailService): NotificationService {
//        return emailService
//    }
//
//}
/**
 *
 * 16 go to Main activity now and Pass value in this NotificationServiceModule.
 *
 */


/**
 *
 * 18. Now we will remove retryCount from module, instead we will depend on dagger to make it.
 *
 */

@Module
class NotificationServiceModule() {

    @MessageQualifier
    @Provides
    fun getMessageService(retryCount: Int): NotificationService {
        return MessageService(retryCount)
    }

    @Named("email")
    @Provides
    fun getEmailService(emailService: EmailService): NotificationService {
        return emailService
    }

}
/**
 *
 * 19. When we try to run it, we will get an error on MainActivity that we can't build the component now.
 * Go To MainActivity.
 *
 */


