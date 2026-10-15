package com.service.interviewjava.Mapper;

import com.service.interviewjava.Dto.EmployeesDto;
import com.service.interviewjava.Entity.Employees;

public class EmployeesMapper {

    public EmployeesDto toDto(Employees employees){

        EmployeesDto employeesDto = new EmployeesDto();

        employeesDto.setSalary(employees.getSalary());
        employeesDto.setName(employees.getName());
        employeesDto.setHireDate(employees.getHireDate());
        employeesDto.setAge(employees.getAge());
        employeesDto.setId(employees.getId());
        employeesDto.setEmail(employees.getEmail());

        return employeesDto;
    }

    public Employees toEntity(EmployeesDto employeesDto){

        Employees employees = new Employees();

        employees.setSalary(employeesDto.getSalary());
        employees.setName(employeesDto.getName());
        employees.setHireDate(employeesDto.getHireDate());
        employees.setAge(employeesDto.getAge());
        employees.setEmail(employeesDto.getEmail());

        return employees;
    }
}
