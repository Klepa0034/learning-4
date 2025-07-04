package org.example.entity;

import org.example.annatation.Component;

@Component
public class Employee {
    private String name;
    private Long salary;
    private Integer id;


    public void setName(String name) {
        this.name = name;
    }



    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String toString() {
        return "Имя %d,%d %s ".formatted(id,salary,name);
    }

}
