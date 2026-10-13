package com.service.interviewjava.Entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="EMPLOYEES")
public class Employees {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 150, unique = true)
    private String email;

    private Integer age;

    @Column(name = "HIRE_DATE", nullable = false)
    private LocalDate hireDate;

    @Column(nullable = false, precision = 7, scale = 2)

    private BigDecimal salary;

    public Employees(Long id, String name, String email, Integer age, LocalDate hireDate, BigDecimal salary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.hireDate = hireDate;
        this.salary = salary;
    }

    public Employees() {

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

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }
}
