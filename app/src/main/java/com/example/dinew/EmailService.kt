package com.example.dinew

import android.util.Log
import javax.inject.Inject

/**
 *
 * 5. to reduce coupling
 *
 */
//interface NotificationService{
//    fun send(from: String, to: String, body: String)
//}
//
//class EmailService @Inject constructor() :NotificationService{
//    override fun send(from: String, to: String, body: String) {
//        Log.d("DI","Email sent")
//    }
//}
//class MessageService() :NotificationService{
//    override fun send(from: String, to: String, body: String) {
//        Log.d("DI","Message sent ")
//    }
//}
/**
 *
 * 15. now lets say we have requirement to add retry count in this message service
 *
 */

interface NotificationService{
    fun send(from: String, to: String, body: String)
}

class EmailService @Inject constructor() :NotificationService{
    override fun send(from: String, to: String, body: String) {
        Log.d("DI","Email sent")
    }
}
class MessageService(private val retryCount:Int) :NotificationService{
    override fun send(from: String, to: String, body: String) {
        Log.d("DI","Message sent  + $retryCount  ")
    }
}