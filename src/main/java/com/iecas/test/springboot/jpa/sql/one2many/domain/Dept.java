package com.iecas.testspringboot.sql.one2many.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * 一方
 */
//@Data
@Entity
// 使用 @Table 不仅可指定表名，
// 而且 避免 @GeneratedValue(strategy=GenerationType.IDENTITY)
// 注解报错。
@Table(name="dept")
public class Dept {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@Column(name="id")
	private Integer id;
	
	//@Column(name="dept_name")
	private String deptName;
	
	//关联员工（多方）
	@OneToMany(mappedBy="dept")
	private Set<Emp> emps = new HashSet<Emp>();


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Set<Emp> getEmps() {
		return emps;
	}

	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}
}
