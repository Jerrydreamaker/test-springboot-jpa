package com.iecas.service;

import com.iecas.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service

public class EmployeeService {
    @Autowired
    EmployeeRepository repository;
    @Transactional
    public void update(String name,Integer id){
        repository.update(name,id);
    }

}
