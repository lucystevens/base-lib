package uk.co.lukestevens.encryption

import kotlin.annotation.AnnotationTarget.VALUE_PARAMETER
import kotlin.annotation.AnnotationTarget.FIELD
import kotlin.annotation.AnnotationTarget.FUNCTION
import kotlin.annotation.Retention
import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention

@Qualifier
@Target(FIELD, VALUE_PARAMETER, FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class EncryptionKey