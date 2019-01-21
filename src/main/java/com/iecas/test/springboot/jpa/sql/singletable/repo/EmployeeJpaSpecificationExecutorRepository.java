package com.iecas.test.springboot.jpa.sql.singletable.repository;


import com.iecas.test.springboot.jpa.sql.singletable.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeJpaSpecificationExecutorRepository extends
        JpaSpecificationExecutor<Employee>, JpaRepository<Employee,Integer> {
}
