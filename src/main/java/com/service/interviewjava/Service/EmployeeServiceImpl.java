package com.service.interviewjava.Service;

import com.service.interviewjava.Dao.EmployeesDao;
import com.service.interviewjava.Dto.EmployeeDto;
import com.service.interviewjava.Entity.Employees;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeesDao employeesDao;

    public EmployeeServiceImpl(EmployeesDao employeesDao){
        this.employeesDao = employeesDao;
    }

    public List<EmployeeDto> findAll(){

        List<Employees> employeesList = employeesDao.findAll();
        List<EmployeeDto> employeeDtoList = new ArrayList<>();

        for(Employees employees: employeesList){
            EmployeeDto employeeDTO = new EmployeeDto();
            employeeDTO.setId(employees.getId());
            employeeDTO.setAge(employees.getAge());
            employeeDTO.setEmail(employees.getEmail());
            employeeDTO.setHireDate(employees.getHireDate());
            employeeDTO.setName(employees.getName());
            employeeDTO.setSalary(employees.getSalary());

            employeeDtoList.add(employeeDTO);
        }

        return employeeDtoList;

    }


}
