package com.iecas.testspringboot.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//获取前缀为 "girl" 的配置
@Component
@ConfigurationProperties(prefix = "girl")
public class Girlproperties {
    private String cupSize;
    private Integer age;

    public String getCupSize() {
        return cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
