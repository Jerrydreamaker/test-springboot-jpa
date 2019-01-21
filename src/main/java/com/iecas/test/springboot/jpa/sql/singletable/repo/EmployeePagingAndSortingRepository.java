package com.iecas.test.springboot.jpa.sql.singletable.repository;


import com.iecas.test.springboot.jpa.sql.singletable.domain.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeePagingAndSortingRepository extends
        PagingAndSortingRepository<Employee,Integer> {
}
