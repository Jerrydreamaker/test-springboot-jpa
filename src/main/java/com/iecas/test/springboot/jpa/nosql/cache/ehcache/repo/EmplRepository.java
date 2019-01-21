package com.iecas.testspringboot.nosql.cache.ehcache.repo;


import com.iecas.testspringboot.nosql.cache.ehcache.domain.Empl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmplRepository extends JpaRepository<Empl,Integer> {
}
