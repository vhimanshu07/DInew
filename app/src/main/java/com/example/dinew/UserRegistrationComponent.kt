package com.example.dinew

import com.example.dinew.module.NotificationServiceModule
import com.example.dinew.module.UserRepositoryModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


/**
 *
 * 1.
 *  Now we made a component with @Component annotation
 *  and written the function we need by using dagger ... And added @Inject in that Service
 *
 */
@Singleton
@Component(modules= [NotificationServiceModule::class, UserRepositoryModule::class])
interface UserRegistrationComponent {



    /**
     *
     * 2.
     * But there is one limitation in this implementation, what if there are several service or things are needed
     * then should we be writing them again and again no?
     *
     *
     */
    //fun getUserRegistrationService(): UserRegistrationService
     /**
     * 3.
     * So to resolve this we will be writing a function (inject)
     *
     */
    fun inject(mainActivity: MainActivity)


    /**
     *
     * 7. Come here after creating module
     *
     * So now write
     * @Component (module [NotificationServiceModule::class, UserRepositoryModule:class]
     *
     *
     * After doing this go to Modules....
     * See how to create objects of the repository which has @Inject annotation in it's constructor
     * 8.
     *
     */


    /**
     *
     *
     * 17. Continue, we need to make factory here now, which will provide runtime values
     *
     */
    @Component.Factory
    interface Factory{
        fun create(@BindsInstance retryCount:Int):UserRegistrationComponent
    }
    /**
     *
     * 18. what this Factory will do is it will provide the runtime value through dagger, now go to NotificationServiceModule
     *
     */


}