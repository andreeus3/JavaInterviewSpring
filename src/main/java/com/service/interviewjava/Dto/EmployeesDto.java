package com.service.interviewjava.Dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EmployeesDto {
    private Long id;
    private String name;
    private String email;
    private Integer age;
    private LocalDate hireDate;
    private BigDecimal salary;

    public EmployeesDto() {
    }

    public EmployeesDto(Long id, String name, String email, Integer age, LocalDate hireDate, BigDecimal salary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.hireDate = hireDate;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
