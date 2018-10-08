package com.iecas.testspringboot.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

@Entity
@Data
public class Girl {
    @Id
    @GeneratedValue
    private Integer id;

    private String cupSize;
    @Min(value = 18,message = "未成年少女禁止入内!")
    private int age;

    public Girl(){

    }

    @Override
    public String toString(){
        return "Girl{"+
                "id="+id+","+
                "cupSize="+cupSize+","+
                "age="+age+
                "}";
    }
}
