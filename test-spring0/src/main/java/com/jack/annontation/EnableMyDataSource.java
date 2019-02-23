package com.jack.annontation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface EnableMyDataSource {

	String username() default "";

	String password() default "";

	String ip() default "127.0.0.1";

	int port() default 3306;
}
