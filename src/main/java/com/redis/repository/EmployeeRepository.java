package com.redis.repository;

import com.redis.entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {

    @Autowired
    RedisTemplate redisTemplate;
    private final static String KEY="EMPLOYEEENTITY";

    public void saveEmployee(EmployeeEntity employeeEntity){
        redisTemplate.opsForHash().put(KEY,employeeEntity.getId().toString(),employeeEntity);
    }

    public List<EmployeeEntity> getListOfEmployee(){
      return  redisTemplate.opsForHash().values(KEY);
    }

    public EmployeeEntity getEmployeeById(String id) {
        return (EmployeeEntity) redisTemplate.opsForHash().get(KEY,id);
    }
}
