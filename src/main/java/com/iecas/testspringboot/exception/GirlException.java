package com.iecas.testspringboot.exception;

import com.iecas.testspringboot.enums.ResultEnum;

public class GirlException extends RuntimeException {
    private Integer code;
    public GirlException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code=resultEnum.getCode();
    }

    public Integer getCode(){
        return this.code;
    }
    public void setCode(Integer code){
        this.code=code;
    }
}
