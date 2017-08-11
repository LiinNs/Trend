package xyz.liinns.exception;

import lombok.extern.slf4j.Slf4j;
import org.reflections.Reflections;
import xyz.liinns.exception.annotation.TrendExceptionAt;
import xyz.liinns.exception.impl.TrendException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Description:
 * Created by LiinNs on 2017-8-3 0003.
 */
@Slf4j
public final class TrendExceptionBuilder {

    private static Map<TrendExceptionType, Class> allExceptions;

    private static final String EX_NOT_DEFINED = "所引用的异常尚未定义{}";

    static {
        Reflections reflections = new Reflections("xyz.liinns.exception.impl");
        Set<Class<?>> annotatedClasses = reflections.getTypesAnnotatedWith(TrendExceptionAt.class);
        allExceptions = new ConcurrentHashMap<>();
        for (Class<?> classObject : annotatedClasses) {
            TrendExceptionAt trendExceptionAt = classObject.getAnnotation(TrendExceptionAt.class);
            allExceptions.put(trendExceptionAt.value(), classObject);
        }
        allExceptions = Collections.unmodifiableMap(allExceptions);
    }

    /**
     * 根据异常类型 和 异常信息 创建自定义异常
     * @param exAlias TrendExceptionType
     * @param message 异常信息
     * @return 核保异常
     */
    public static TrendException newHbException(TrendExceptionType exAlias, String message) {
        TrendException trendException = null;
        try {
            Class aClass = allExceptions.get(exAlias);
            Method raise = aClass.getDeclaredMethod("raise", String.class);
            raise.setAccessible(true);
            trendException = (TrendException)raise.invoke(aClass, message);
        } catch (NoSuchMethodException
                | IllegalAccessException
                | InvocationTargetException e) {
            log.error(EX_NOT_DEFINED,e);
        }
        return trendException;
    }

    /**
     * 根据异常类型 异常消息 和 异常 创建自定义异常
     * @param exAlias TrendExceptionType
     * @param message 异常消息
     * @param cause 异常
     * @return
     */
    public static TrendException newHbException(TrendExceptionType exAlias, String message, Throwable cause) {
        TrendException trendException = null;
        try {
            Class aClass = allExceptions.get(exAlias);
            Method raise = aClass.getDeclaredMethod("raise", String.class, Throwable.class);
            raise.setAccessible(true);
            trendException = (TrendException) raise.invoke(aClass, message, cause);
        } catch (NoSuchMethodException
                | IllegalAccessException
                | InvocationTargetException e) {
            log.error(EX_NOT_DEFINED,e);
        }
        return trendException;
    }

    /**
     *根据异常类型 和 异常 创建自定义异常
     * @param exAlias TrendExceptionType
     * @param cause 异常
     * @return
     */
    public static TrendException newHbException(TrendExceptionType exAlias, Throwable cause) {
        TrendException trendException = null;
        try {
            Class aClass = allExceptions.get(exAlias);
            Method raise = aClass.getDeclaredMethod("raise", Throwable.class);
            raise.setAccessible(true);
            trendException = (TrendException)raise.invoke(aClass, cause);
        } catch (NoSuchMethodException
                | IllegalAccessException
                | InvocationTargetException e) {
            log.error(EX_NOT_DEFINED,e);
        }
        return trendException;
    }

    public static void main(String[] args) {
        TrendException trendException1 = newHbException(TrendExceptionType.CONTROLLER, "笨蛋1");
        System.out.println(trendException1);
        TrendException trendException2 = newHbException(TrendExceptionType.SERVICE, "笨蛋2", new RuntimeException("ben dan！"));
        System.out.println(trendException2);
        TrendException trendException3 = newHbException(TrendExceptionType.REPOSITORY, new RuntimeException("love"));
        System.out.println(trendException3);
    }

}
