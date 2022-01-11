package com.redis.controller;

import com.redis.entity.EmployeeEntity;
import com.redis.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class EmployeeController {

    final Logger LOG= LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/saveEmployee", method= RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void saveEmployee(@RequestBody EmployeeEntity employeeEntity){
        LOG.info("from Radis DB START");
        employeeService.saveEmployee(employeeEntity);
    }

    @RequestMapping(value = "/getEmployees", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EmployeeEntity> getListOfEmployee(){
        LOG.info("from Radis DB START");
       return employeeService.getListOfEmployee();
    }

    @RequestMapping(value = "/get/{id}", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeEntity getEmployeeById(@PathVariable("id") String id){
        LOG.info("from Radis DB START");
        return employeeService.getEmployeeById(id);
    }
}
