package it.sponzi.gamma.common.util;

import it.sponzi.gamma.common.exception.InternalException;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Ref;

@Slf4j
public class ReflectionUtils {

    private ReflectionUtils(){}

    public static <T> T getInstanceOf(Class<T> clazz){
        try {
            Constructor<T> constructor = clazz.getConstructor();
            return constructor.newInstance();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException ex) {
            log.error(ex.getMessage());
            throw new InternalException(ex.getMessage(),ex);
        }
    }

}
