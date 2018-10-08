package com.iecas.testspringboot.utils;

import com.iecas.testspringboot.domain.Result;

public class ResultUtil {
    public static Result error(Integer code,String message){
        Result result=new Result();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }
    public static Result success(Integer code,String message,Object object){
        Result result=new Result();
        result.setCode(code);
        result.setMessage("成功");
        result.setData(object);
        return result;
    }
}
