package org.example.mapper.impl;

import org.example.array.CustomArray;
import org.example.mapper.Mapper;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperImpl<T> implements Mapper<T> {

    @Override
    public CustomArray<T> resultToListMapper(ResultSet resultSet, Class<T> tClass) throws SQLException {
        Field[] declaredFields = tClass.getDeclaredFields();
        while(resultSet.next()){
            for (int i = 0; i < declaredFields.length; i++) {
                Field declaredField = declaredFields[i];

            }
        }
        return null;
    }
}
