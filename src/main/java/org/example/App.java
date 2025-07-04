package org.example;

import org.example.annatation.Component;
import org.example.array.CustomArray;
import org.example.entity.Employee;
import org.example.factory.BeanFactory;
import org.example.factory.BeanProcessor;
import org.example.factory.impl.BeanFactoryImpl;
import org.example.factory.impl.BeanProcessorImpl;
import org.example.repository.EmployeeRepository;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.*;
@Component
public class App
{
    public static void main( String[] args ) throws SQLException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Map<String,Object> map = new HashMap<>();
        BeanFactory beanFactory = new BeanFactoryImpl();
        Reflections reflections = new Reflections("org.example");
        Set<Class<?>> typesAnnotatedWith = reflections.getTypesAnnotatedWith(Component.class);
        Iterator<Class<?>> iterator = typesAnnotatedWith.iterator();
        while (iterator.hasNext()){
            Class<?> next = iterator.next();
            Object object = beanFactory.createObject(next);
            map.put(next.getSimpleName(),object);
        }
        BeanProcessor beanProcessor= new BeanProcessorImpl(map);
        beanProcessor.initialize();
        Object o = map.get(EmployeeRepository.class.getSimpleName());
        EmployeeRepository employeeRepository = (EmployeeRepository) o;
        CustomArray<Employee> all = employeeRepository.findAll();
        all.print();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id для удаления");
        int index = scanner.nextInt();
        all.deleteElement(index);
    }
}
