package com.iecas.service;

import com.iecas.entity.Employee;
import com.iecas.repository.EmployeeCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeCrudService {
    @Autowired
    EmployeeCrudRepository employeeCrudRepository;
    @Transactional
    //不加注解也能插入，但若存在多个 Repository 操作，不加不能保证原子性。
    public void saveAll(List<Employee> employees){
        employeeCrudRepository.saveAll(employees);
    }
}
