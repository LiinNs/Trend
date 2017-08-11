package xyz.liinns.exception.annotation;


import xyz.liinns.exception.TrendExceptionType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description:
 * Created by LiinNs on 2017-8-3 0003.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TrendExceptionAt {

    TrendExceptionType value();
}
