package com.service.interviewjava.Dao;

import com.service.interviewjava.Entity.Employees;

import java.util.List;
import java.util.Optional;

public interface EmployeesDao {
    List<Employees> findAll();
    Optional<Employees> findById(Long id);
    Employees save(Employees employees);
    void deleteById(Long id);

}
