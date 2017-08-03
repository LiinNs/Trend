package xyz.liinns.exception;

import lombok.extern.slf4j.Slf4j;
import org.reflections.Reflections;
import xyz.liinns.exception.annotation.HbExceptionAt;
import xyz.liinns.exception.impl.HbException;

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
public final class HbExceptionBuilder {

    private static Map<HbExceptionType, Class> allHbExceptions;

    private static final String EX_NOT_DEFINED = "所引用的异常尚未定义{}";

    static {
        Reflections reflections = new Reflections("com.qy.insurance.hb.exception.impl.*&*");
        Set<Class<?>> annotatedClasses = reflections.getTypesAnnotatedWith(HbExceptionAt.class);
        allHbExceptions = new ConcurrentHashMap<>();
        for (Class<?> classObject : annotatedClasses) {
            HbExceptionAt hbExceptionAt = classObject.getAnnotation(HbExceptionAt.class);
            allHbExceptions.put(hbExceptionAt.value(), classObject);
        }
        allHbExceptions = Collections.unmodifiableMap(allHbExceptions);
    }

    /**
     * 根据异常类型 和 异常信息 创建自定义异常
     * @param exAlias HbExceptionType
     * @param message 异常信息
     * @return 核保异常
     */
    public static HbException newHbException(HbExceptionType exAlias, String message) {
        HbException hbException = null;
        try {
            Class aClass = allHbExceptions.get(exAlias);
            Method raise = aClass.getDeclaredMethod("raise", String.class);
            raise.setAccessible(true);
            hbException = (HbException)raise.invoke(aClass, message);
        } catch (NoSuchMethodException
                | IllegalAccessException
                | InvocationTargetException e) {
            log.error(EX_NOT_DEFINED,e);
        }
        return hbException;
    }

    /**
     * 根据异常类型 异常消息 和 异常 创建自定义异常
     * @param exAlias HbExceptionType
     * @param message 异常消息
     * @param cause 异常
     * @return
     */
    public static HbException newHbException(HbExceptionType exAlias, String message,Throwable cause) {
        HbException hbException = null;
        try {
            Class aClass = allHbExceptions.get(exAlias);
            Method raise = aClass.getDeclaredMethod("raise", String.class, Throwable.class);
            raise.setAccessible(true);
            hbException = (HbException) raise.invoke(aClass, message, cause);
        } catch (NoSuchMethodException
                | IllegalAccessException
                | InvocationTargetException e) {
            log.error(EX_NOT_DEFINED,e);
        }
        return hbException;
    }

    /**
     *根据异常类型 和 异常 创建自定义异常
     * @param exAlias HbExceptionType
     * @param cause 异常
     * @return
     */
    public static HbException newHbException(HbExceptionType exAlias, Throwable cause) {
        HbException hbException = null;
        try {
            Class aClass = allHbExceptions.get(exAlias);
            Method raise = aClass.getDeclaredMethod("raise", Throwable.class);
            raise.setAccessible(true);
            hbException = (HbException)raise.invoke(aClass, cause);
        } catch (NoSuchMethodException
                | IllegalAccessException
                | InvocationTargetException e) {
            log.error(EX_NOT_DEFINED,e);
        }
        return hbException;
    }

    public static void main(String[] args) {
        HbException hbException1 = newHbException(HbExceptionType.CONTROLLER, "笨蛋1");
        System.out.println(hbException1);
        HbException hbException2 = newHbException(HbExceptionType.SERVICE, "笨蛋2", new RuntimeException("ben dan！"));
        System.out.println(hbException2);
        HbException hbException3 = newHbException(HbExceptionType.REPOSITORY, new RuntimeException("love"));
        System.out.println(hbException3);
    }

}
