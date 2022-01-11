package com.redis.service;

import com.redis.entity.EmployeeEntity;
import com.redis.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public void saveEmployee(EmployeeEntity employeeEntity) {
        employeeRepository.saveEmployee(employeeEntity);
    }

    public List<EmployeeEntity> getListOfEmployee() {
        return employeeRepository.getListOfEmployee();
    }

    public EmployeeEntity getEmployeeById(String id) {
        return employeeRepository.getEmployeeById(id);
    }
}
