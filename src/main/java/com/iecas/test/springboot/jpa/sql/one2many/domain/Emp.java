package com.iecas.testspringboot.sql.one2many.domain;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;

/**
 * 多方
 */
@Proxy(lazy = false)
//org.hibernate.LazyInitializationException:
// could not initialize proxy [com.iecas.testspringboot.sql.one2many.dao.Empl#1]
// - no Session
@Entity
//使用 @Data 注解导致 hashCode 方法死循环。
//@Data
@Table(name="emp")
public class Emp {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@Column(name="id")
	private Integer id;
	
	//@Column(name="name")
	private String name;
	
	//@Column(name="gender")
	private String gender;
	
	//@Column(name="telephone")
	private String telephone;
	
	//@Column(name="address")
	private String address;
	
	//关联部门（1方）
	@ManyToOne(cascade=CascadeType.PERSIST)
	//@JoinColumn：维护外键字段
	@JoinColumn(name="dept_id")
	private Dept dept;


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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Empl [id=" + id + ", name=" + name + ", gender=" + gender + ", telephone=" + telephone + ", address="
				+ address + "]";
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}
}
