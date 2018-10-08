package com.iecas.testspringboot.service;

import com.iecas.testspringboot.domain.Girl;
import com.iecas.testspringboot.domain.Result;
import com.iecas.testspringboot.enums.ResultEnum;
import com.iecas.testspringboot.exception.GirlException;
import com.iecas.testspringboot.repository.GirlRepository;
import com.iecas.testspringboot.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;
    @Transactional
    public void insertTwo(){
        Girl girlA=new Girl();
        girlA.setAge(18);
        girlA.setCupSize("F");
        girlRepository.save(girlA);
        Girl girlB=new Girl();
        girlB.setAge(19);
        girlB.setCupSize("A");
        girlRepository.save(girlB);
    }

    public Result getAge(Integer id){
        //return girlRepository.findByAge(age);
        Girl girl=girlRepository.findById(id).get();
        Integer age=girl.getAge();
        if(age<10){
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age>=10&& girl.getAge()<18) {
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }else {
            return ResultUtil.success(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg()
                    , girl);
        }
    }
}
