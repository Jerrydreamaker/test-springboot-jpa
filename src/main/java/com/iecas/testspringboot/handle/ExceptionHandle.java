package com.iecas.testspringboot.handle;

import com.iecas.testspringboot.domain.Result;
import com.iecas.testspringboot.exception.GirlException;
import com.iecas.testspringboot.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionHandle {
    @ExceptionHandler(value = Exception.class)
    public Result handle(Exception e){
        if(e instanceof GirlException){
            GirlException girlException=(GirlException) e;
            return ResultUtil.error(girlException.getCode(),girlException.getMessage());
        }else {
            log.error("系统异常:{}",e);
            return ResultUtil.error(-1,"未知错误");
        }
    }
}
