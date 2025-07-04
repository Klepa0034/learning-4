package org.example.repository.impl;

import org.example.annatation.Autowired;
import org.example.annatation.Component;
import org.example.array.CustomArray;
import org.example.array.impl.CustomArrayImpl;
import org.example.manager.ConnectionManager;
import org.example.entity.Employee;
import org.example.manager.impl.SqlManagerImpl;
import org.example.mapper.Mapper;
import org.example.repository.EmployeeRepository;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class EmployeeRepositoryImpl<T> implements EmployeeRepository<T> {
    CustomArray<T> customArray = new CustomArrayImpl<>();
    @Autowired
    SqlManagerImpl sqlManager;
    @Autowired
    private Mapper<Employee> mapper;
    @Autowired
    private ConnectionManager connectionManager;

    @Override
    public CustomArray<Employee> findAll() throws SQLException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Connection connection = connectionManager.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM employee");
        return mapper.resultToListMapper(resultSet,Employee.class);
    }

    public void setMapper(Mapper<Employee> mapper) {
        this.mapper = mapper;
    }

    public void setConnectionManager(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }
    public void deleteElement(int index) throws SQLException{
        Statement statement = connectionManager.getConnection().createStatement();
        statement.execute(sqlManager.deleteQuery("employees","id_employee","(%d)".formatted(index)));
    }
    public void insertElement(int index, T value,Class<T> tClass) throws SQLException {
        Field[] declaredFields = tClass.getDeclaredFields();
        Statement statement = connectionManager.getConnection().createStatement();
        statement.execute(sqlManager.insertQuery("employee","(name,salary)", "('%s',%d)".formatted(declaredFields,declaredFields)));
    }

}
