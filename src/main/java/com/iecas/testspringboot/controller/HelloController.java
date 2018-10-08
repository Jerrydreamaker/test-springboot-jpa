package com.iecas.testspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hi")
public class HelloController {
    //@Value("${cupSize}")
    //将配置文件的值注给属性变量。
    //private String cupSize;
    //@Value("${age}")
    //将配置文件的值注给属性变量。
    //private int age;
    //@Value("${content}")
    //组合使用配置文件属性值。
    //private String content;
    //@Autowired
    //private Girlproperties girlproperties;
    @GetMapping("/hello")
    public String say(@RequestParam(value = "id",required = false,defaultValue = "0") int id){
        return "id:"+id;
    }
}
