package com.iecas.testspringboot.enums;

public enum ResultEnum {
    UNKNOW_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    PRIMARY_SCHOOL(100,"你可能还在上小学"),
    MIDDLE_SCHOOL(101,"你可能在上初中"),
    ;
    private Integer code;
    private String msg;
    ResultEnum(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }
    public String getMsg(){
        return this.msg;
    }

    public Integer getCode(){
        return this.code;
    }
}
