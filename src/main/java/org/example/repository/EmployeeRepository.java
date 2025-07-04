package org.example.repository;

import org.example.array.CustomArray;
import org.example.entity.Employee;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public interface EmployeeRepository <T>{
     CustomArray<Employee> findAll() throws SQLException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException;
      void deleteElement(int index) throws SQLException;
    void insertElement(int index, T value,Class<T> tClass) throws SQLException;

}
