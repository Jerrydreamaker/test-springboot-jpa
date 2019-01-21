package com.iecas.testspringboot.nosql.cache.ehcache.service;

import com.iecas.testspringboot.nosql.cache.ehcache.domain.Empl;
import com.iecas.testspringboot.nosql.cache.ehcache.repo.EmplRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class EmplService {
    @Resource
    private EmplRepository emplRepository;
    @Cacheable(value = "emp")
    public Empl findById(Integer id){
        return emplRepository.getOne(id);
    }

    @CacheEvict(value = "emp",allEntries = true)
    public void save(Empl empl){
        emplRepository.save(empl);
    }
}
