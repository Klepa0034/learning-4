package org.example.bean.impl;

import org.example.annatation.Component;
import org.example.bean.BeanFactory;

import java.lang.reflect.InvocationTargetException;

public class BeanFactoryImpl implements BeanFactory {
    @Override
    public <T> T createObject(Class<T> tClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        boolean annotationPresent = tClass.isAnnotationPresent(Component.class);
        if(annotationPresent){
            tClass.getDeclaredConstructor().newInstance();
        }
        return null;
    }
}
