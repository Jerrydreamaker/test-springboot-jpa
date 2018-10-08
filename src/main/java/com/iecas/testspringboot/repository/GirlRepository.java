package com.iecas.testspringboot.repository;

import com.iecas.testspringboot.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GirlRepository extends JpaRepository<Girl,Integer>{
    public List<Girl> findByAge(Integer age);
}
