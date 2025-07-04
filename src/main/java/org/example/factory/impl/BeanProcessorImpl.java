package org.example.factory.impl;

import org.example.annatation.Autowired;
import org.example.factory.BeanProcessor;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class BeanProcessorImpl implements BeanProcessor {
    private Map<String, Object> beans;

    public BeanProcessorImpl(Map<String, Object> beans) {
        this.beans = beans;
    }

    @Override
    public void initialize() throws InvocationTargetException, IllegalAccessException {
        Collection<Object> values = beans.values();
        Iterator<Object> iterator = values.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            Class<?> aClass = next.getClass();
            Field[] declaredFields = aClass.getDeclaredFields();
            Method[] declaredMethods = aClass.getDeclaredMethods();
            for (int i = 0; i < declaredFields.length; i++) {
                Field declaredField = declaredFields[i];
                boolean annotationPresent = declaredField.isAnnotationPresent(Autowired.class);
                if (!annotationPresent) {
                    continue;
                }
                String simpleName = declaredField.getType().getSimpleName() + "Impl";
                Object o = beans.get(simpleName);
                for (int j = 0; j < declaredMethods.length; j++) {
                    Method declaredMethod = declaredMethods[j];
                    String name = declaredField.getName();
                    if (!declaredMethod.getName().equals("set" + name.substring(0, 1).toUpperCase() + name.substring(1))) {
                        continue;
                    }
                    declaredMethod.invoke(next,o);

                }
            }
        }
    }
}
