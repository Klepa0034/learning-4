package org.example.factory;

import java.lang.reflect.InvocationTargetException;

public interface BeanProcessor {
        void initialize() throws InvocationTargetException, IllegalAccessException;
}
