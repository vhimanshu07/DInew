package com.example.dinew

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dinew.module.NotificationServiceModule
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    /**
     *
     * 4. point related lateint var
     *
     * It is called as Field Injection
     *
     */


    @Inject
    lateinit var userRegistrationService: UserRegistrationService

    @Inject
    lateinit var userRepository: UserRepository

    /**
     *
     * 20
     * Single ton classes example, why we need it.
     * As we wrote two different user repository variable so it is creating another instance of user repository.
     *
     * To Fix it go to user repository and make it singleton and then the component which is using this repository has to be
     * made single ton
     *
     *
     */
    @Inject
    lateinit var userRepository2: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        /**
         *1.
         * So it is manual injection but what if we need 100 times this same code? will we write again and again?
         *
         * Here dagger will help us.
         *
         *
         *2.
         * So we will create a Component which will help us provide a module or piece of code we need directly
         *
         */
//        val userRepository = UserRepository()
//        val emailService = EmailService()
//
//
//        val userRegistrationService = UserRegistrationService(userRepository, emailService)
//        userRegistrationService.register("wyz@gmail.com", "123nce")
        /**
         *
         * 3.
         * So instead of Creating of object of this by writing the code above, we will do this now
         *
         */
//        val userRegistrationService =
//            DaggerUserRegistrationComponent.builder().build().getUserRegistrationService()
//        userRegistrationService.register("wyz@gmail.com", "123nce")

        /**
         *
         * 4.
         * Now we will make use of inject function defined in UserRegistrationComponent
         * We will make a lateinit Var for user registration service and annotate it with inject operation
         *
         * As we applied @Inject above this variable, dagger got to know we need to inject this
         *
         *
         * But for this you have to make use of new function inject()
         *
         */
//        val component =
//            DaggerUserRegistrationComponent.builder().build()
//        component.inject(this)
//        userRegistrationService.register("wyz@gmail.com", "123nce")
        /**
         *
         * 5.
         * But now our UserRegistrationService class is tightly coupled with userRepository and EmailService
         * Or there might be new requirement
         *
         * that instead of Mail we need Message now
         *
         * So to fix it check them now->
         *
         * 5. Point would be written there  UserRegistrationService
         *
         *
         */

        /**
         *
         * 16. Now we have came to build NotificationService Module with a value
         *
         */

//        val component =
//            DaggerUserRegistrationComponent.builder()
//                .notificationServiceModule(NotificationServiceModule(3))
//                .build()
//        component.inject(this)
//        userRegistrationService.register("wyz@gmail.com", "123nce")

        /**
         *
         * 17.
         * There is one flaw in this, if we forgot to build this notificationServiceModule object then?
         * It would give run time error
         * So to fix this go to user registration component
         *
         */


        /**
         *
         * 19 . Here for fixing error.
         *
         * Here we  don't have builder now, we have factory now.
         *
         */

        val component =
            DaggerUserRegistrationComponent.factory().create(3)

        component.inject(this)
        userRegistrationService.register("wyz@gmail.com", "123nce")

        /**
         *
         *
         * 20. SingleTon Classes ( @Singleton annotations)
         * Single object for whole application
         *
         */


    }
}