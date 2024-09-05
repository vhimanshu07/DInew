package com.example.dinew.annotations

import java.lang.annotation.Documented
import javax.inject.Qualifier


/**
 *
 * 13. we made our own annotation
 *
 * @Qualifier means we are making our own Qualifier
 * @Documented means would it come in Java doc or not
 * @Retention defines the timeline till which it would be valid
 *
 *
 */
@Qualifier
@Documented
@Retention(AnnotationRetention.RUNTIME)
annotation class MessageQualifier()


/**
 *
 *  14. go to user registration service
 *
 *
 */
