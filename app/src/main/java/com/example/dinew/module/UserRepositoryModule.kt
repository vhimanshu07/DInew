package com.example.dinew.module

import com.example.dinew.FirebaseRepository
import com.example.dinew.SQLRepository
import com.example.dinew.UserRepository
import dagger.Binds
import dagger.Module
import dagger.Provides


/**
 *
 * After 6. of UserRegistrationService come here.
 *
 */


/**
 *
 * 7.
 * After creating this module we have to notify the component that we have made modules
 * Go to UserRegistrationComponent
 *
 */
//@Module
//class UserRepositoryModule {
//
//    @Provides
//    fun getUserFireBaseRepository (): UserRepository {
//        return FirebaseRepository()
//    }
//
//}




/**
 *
 *
 * 8. Come from UserRegistrationComponent
 *
 * In this function we are saying to dagger make a object of SQL repository and we will get it directly (returning it directly)
 *
 */

//@Module
//class UserRepositoryModule {
//
//    @Provides
//    fun getSQLRepository(sqlRepository: SQLRepository):UserRepository{
//        return sqlRepository
//    }
//
//}


/**
 *
 * 9.
 * We can use @Binds here, as sqlRepository is build and being provided by dagger we can use binds
 *
 *
 * So, whenever we need UserRepository dagger will give sql repository
 *
 *
 */


@Module
abstract class UserRepositoryModule {

    @Binds
    abstract fun getSQLRepository(sqlRepository: SQLRepository):UserRepository
}
/**
 *
 * 10 . go to notification service module
 *
 *
 */
