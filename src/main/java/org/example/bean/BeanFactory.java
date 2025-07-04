package org.example.bean;

import java.lang.reflect.InvocationTargetException;

public interface BeanFactory {
    <T> T createObject(Class<T> tClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;
}
