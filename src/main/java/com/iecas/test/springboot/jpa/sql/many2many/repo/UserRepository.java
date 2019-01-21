package com.iecas.testspringboot.sql.many2many.repo;

import com.iecas.testspringboot.sql.many2many.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
