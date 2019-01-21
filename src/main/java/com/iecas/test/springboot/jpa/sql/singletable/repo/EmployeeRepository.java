package com.iecas.test.springboot.jpa.sql.singletable.repository;


import com.iecas.test.springboot.jpa.sql.singletable.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    List<Employee> findByNameLikeAndAgeLessThan(String name, Integer age);
    List<Employee> findByNameStartingWithAndAgeLessThan(String name, Integer age);
    List<Employee> findByNameInOrAgeLessThan(List<String> names, Integer age);

    @Query("select e from Employee e where id=(select max(id) from Employee )")
    Employee findEmployeeByMaxId();

    /**
     * 索引参数
     * @param name
     * @param age
     * @return
     */
    @Query("select e from Employee e where e.name=?1 AND e.age=?2")
    List<Employee> findEmployeeByNameAndAge(String name, Integer age);

    /**
     * 命名参数
     * @param name
     * @param age
     * @return
     */
    @Query("select e from Employee e where e.name=:name AND e.age=:age")
    List<Employee> findEmployeeByNameAndAge2(@org.springframework.data.repository.query.Param("name") String name, @Param("age") Integer age);

    /**
     * like 查询
     * @param name
     * @return
     */
    @Query("select e from Employee e where name like %?1%")
    List<Employee> findEmployeeByNameLike(String name);

    /**
     * 原生查询语句
     * @param name
     * @return
     */
    @Query(nativeQuery = true,value = "select * from employee e where e.name like %?1%")
    List<Employee> findEmployeeByNameLike2(String name);

    @Modifying
    @Query("update Employee set name=:name where id=:id")
    void update(@Param("name") String name, @Param("id") Integer id);


}


