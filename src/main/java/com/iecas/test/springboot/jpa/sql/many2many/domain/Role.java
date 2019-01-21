package com.iecas.testspringboot.sql.many2many.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 多方
 */
//@Proxy(lazy = false)
//org.hibernate.LazyInitializationException:
// could not initialize proxy [com.iecas.testspringboot.sql.one2many.dao.Empl#1]
// - no Session
@Entity
//使用 @Data 注解导致 hashCode 方法死循环。
//@Data
@Table
//@Proxy(lazy = false)
public class Role {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;

	@ManyToMany(mappedBy = "roles")
	private Set<User> users=new HashSet<>();


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getUsers() {
		return users;
	}
}
