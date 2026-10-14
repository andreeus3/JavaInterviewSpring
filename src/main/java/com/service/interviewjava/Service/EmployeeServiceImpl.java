package com.service.interviewjava.Service;

import com.service.interviewjava.Dao.EmployeesDao;
import com.service.interviewjava.Dto.EmployeesDto;
import com.service.interviewjava.Entity.Employees;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeesDao employeesDao;

    public EmployeeServiceImpl(EmployeesDao employeesDao){
        this.employeesDao = employeesDao;
    }

    @Override
    public List<EmployeesDto> findAll(){

        List<Employees> employeesList = employeesDao.findAll();
        List<EmployeesDto> employeesDtoList = new ArrayList<>();

        for(Employees employees: employeesList){
            EmployeesDto employeesDTO = new EmployeesDto();
            employeesDTO.setId(employees.getId());
            employeesDTO.setAge(employees.getAge());
            employeesDTO.setEmail(employees.getEmail());
            employeesDTO.setHireDate(employees.getHireDate());
            employeesDTO.setName(employees.getName());
            employeesDTO.setSalary(employees.getSalary());

            employeesDtoList.add(employeesDTO);
        }

        return employeesDtoList;

    }

    @Override
    public Optional<EmployeesDto> findById(Long id){
        Optional<Employees> employeeDtoOptional = employeesDao.findById(id);

        if(employeeDtoOptional.isEmpty()){
            return Optional.empty();
        }

        EmployeesDto employeesDto = new EmployeesDto();
        Employees employees = employeeDtoOptional.get();

        employeesDto.setId(employees.getId());
        employeesDto.setAge(employees.getAge());
        employeesDto.setEmail(employeesDto.getEmail());
        employeesDto.setName(employeesDto.getName());
        employeesDto.setHireDate(employeesDto.getHireDate());

        return Optional.of(employeesDto);

    }

    @Override
    @Transactional
    public Employees save(EmployeesDto employeesDto){

        Employees employees = new Employees();

        employees.setSalary(employeesDto.getSalary());
        employees.setName(employeesDto.getName());
        employees.setHireDate(employees.getHireDate());
        employees.setAge(employeesDto.getAge());
        employees.setId(employees.getId());

        Employees savedEmployees = employeesDao.save(employees);

        EmployeesDto saveEmployeesDto = new EmployeesDto();

        saveEmployeesDto.setSalary(savedEmployees.getSalary());
        saveEmployeesDto.setName(savedEmployees.getName());
        saveEmployeesDto.setHireDate(savedEmployees.getHireDate());
        saveEmployeesDto.setAge(savedEmployees.getAge());
        saveEmployeesDto.setId(savedEmployees.getId());

        return savedEmployees;
    }


}
