package com.iecas.testspringboot.sql.one2many.repo;


import com.iecas.testspringboot.sql.one2many.domain.Emp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepository extends JpaRepository<Emp,Integer> {
}
