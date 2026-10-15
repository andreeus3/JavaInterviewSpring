package com.service.interviewjava.Service;

import com.service.interviewjava.Dao.EmployeesDao;
import com.service.interviewjava.Dto.EmployeesDto;
import com.service.interviewjava.Entity.Employees;
import com.service.interviewjava.Mapper.EmployeesMapper;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeesDao employeesDao;
    private final EmployeesMapper employeesMapper;

    public EmployeeServiceImpl(EmployeesDao employeesDao, EmployeesMapper employeesMapper){
        this.employeesDao = employeesDao;
        this.employeesMapper = employeesMapper;
    }

    @Override
    public List<EmployeesDto> findAll(){

        List<Employees> employeesList = employeesDao.findAll();
        List<EmployeesDto> employeesDtoList = new ArrayList<>();

        for(Employees employees: employeesList){
            EmployeesDto employeesDTO = employeesMapper.toDto(employees);
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
        employeesDto.setEmail(employees.getEmail());
        employeesDto.setName(employees.getName());
        employeesDto.setHireDate(employees.getHireDate());

        return Optional.of(employeesDto);

    }

    @Override
    @Transactional
    public EmployeesDto save(EmployeesDto employeesDto){

        Employees employees = employeesMapper.toEntity(employeesDto);

        Employees savedEmployees = employeesDao.save(employees);

        return employeesMapper.toDto(savedEmployees);
    }

    @Override
    @Transactional
    public void deleteById(Long id){
        Optional<Employees> optionalEmployees = employeesDao.findById(id);

        try {
            if(optionalEmployees.isPresent()){
                employeesDao.deleteById(id);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
