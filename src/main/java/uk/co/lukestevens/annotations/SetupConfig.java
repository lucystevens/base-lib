package uk.co.lukestevens.annotations;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import javax.inject.Qualifier;

/**
 * Injection annotation for the configuration
 * used for setting up the application config
 * 
 * @author Luke Stevens
 */
@Qualifier @Target({ FIELD, PARAMETER, METHOD }) @Retention(RUNTIME)
public @interface SetupConfig {}
