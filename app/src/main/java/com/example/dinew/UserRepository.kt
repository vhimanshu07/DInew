package com.example.dinew

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

/**
 *
 * 5. to reduce coupling
 *
 */
//
//interface UserRepository{
//    fun saveUser(email: String, password: String)
//}
//class SQLRepository @Inject constructor() :UserRepository{
//    override fun saveUser(email: String, password: String) {
//        Log.d("DI","Data save in SQL repo")
//    }
//}
//class FirebaseRepository :UserRepository{
//    override fun saveUser(email: String, password: String) {
//        Log.d("DI","Data save in FirebaseRepository repo")
//    }
//}

/**
 *
 * 21. Making Sql repository Single ton
 * Now go to User registration component and make it single too.
 *
 */

@Singleton
interface UserRepository{
    fun saveUser(email: String, password: String)
}
@Singleton
class SQLRepository @Inject constructor() :UserRepository{
    override fun saveUser(email: String, password: String) {
        Log.d("DI","Data save in SQL repo")
    }
}
class FirebaseRepository :UserRepository{
    override fun saveUser(email: String, password: String) {
        Log.d("DI","Data save in FirebaseRepository repo")
    }
}


