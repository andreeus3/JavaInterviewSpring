package com.service.interviewjava.Service;

import com.service.interviewjava.Dto.EmployeeDto;
import com.service.interviewjava.Entity.Employees;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<EmployeeDto> findAll();
    Optional<EmployeeDto> findById(Long id);
    Employees save(EmployeeDto EmployeeDto);
    void deleteById(Long id);

}
