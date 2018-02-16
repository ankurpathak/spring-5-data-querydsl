package com.ankurpathak.spring5dataquerydsl;

import com.querydsl.core.annotations.QueryEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.math.BigInteger;

@Document(collection = "employees")
@QueryEntity
public class Employee  {
    @Id
    private String id;

    @Indexed(unique = true, sparse = true)
    private BigInteger employeeId;

    public Employee(BigInteger employeeId, String name, BigDecimal salary){
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
    }



    private BigDecimal salary;

    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigInteger getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(BigInteger employeeId) {
        this.employeeId = employeeId;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", employeeId=" + employeeId +
                ", salary=" + salary +
                ", name='" + name + '\'' +
                '}';
    }
}
