package com.service.interviewjava.Dao;

import com.service.interviewjava.Entity.Employees;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeesDaoImpl implements EmployeesDao{

    private final EntityManager entityManager;

    public EmployeesDaoImpl(EntityManager entityManager){
        this.entityManager= entityManager;
    }

    @Override
    public List<Employees> findAll(){
        return
                entityManager.createQuery("SELECT u FROM Employees u", Employees.class).getResultList();
    }

    @Override
    public Optional<Employees>findById(Long id){
        Employees employees = entityManager.find(Employees.class, id);
        return Optional.ofNullable(employees);
    }

    @Override
    public Employees save(Employees employees){
        return entityManager.merge(employees);
    }

    @Override
    public void deleteById(Long id){
        Employees employees = entityManager.find(Employees.class, id);

        if(employees!=null){
            entityManager.remove(employees);
        }
    }
}
