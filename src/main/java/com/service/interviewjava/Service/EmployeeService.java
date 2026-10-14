package com.service.interviewjava.Service;

import com.service.interviewjava.Dto.EmployeesDto;
import com.service.interviewjava.Entity.Employees;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<EmployeesDto> findAll();
    Optional<EmployeesDto> findById(Long id);
    Employees save(EmployeesDto EmployeesDto);
    void deleteById(Long id);

}
