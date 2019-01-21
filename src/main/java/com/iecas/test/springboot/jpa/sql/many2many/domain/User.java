package com.iecas.testspringboot.sql.many2many.domain;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
// 使用 @Table 不仅可指定表名，
// 而且 避免 @GeneratedValue(strategy=GenerationType.IDENTITY)
// 注解报错。
@Table
@Proxy(lazy = false)
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@Column(name="id")
	private Integer id;

	private String name;

	private String password;

	@ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	//Caused by: org.hibernate.MappingException:
	// Could not determine type for:
	// java.util.Set, at table: user, for columns:
	// [org.hibernate.mapping.Column(roles)]
	@JoinTable(joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name="role_id"))
	private Set<Role> roles = new HashSet<Role>();


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public String getName() {
		return name;
	}
}
