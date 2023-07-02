package com.day_record.server.config.annotation;

import java.lang.annotation.*;

/**
 * @author JereChen
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface TokenToUser {

}
