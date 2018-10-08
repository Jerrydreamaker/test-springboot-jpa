package com.iecas.testspringboot.controller;

import com.iecas.testspringboot.domain.Girl;
import com.iecas.testspringboot.domain.Result;
import com.iecas.testspringboot.repository.GirlRepository;
import com.iecas.testspringboot.service.GirlService;
import com.iecas.testspringboot.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
public class GirlController {
    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;

    /**
     * 查询所有女生列表
     * @return
     */
    @GetMapping("/girls")
    public List<Girl> girlList(){
        return girlRepository.findAll();
    }


    /**
     * 添加一个女生
     * @param girl
     * @return
     */
    @PostMapping("/girls")
    public Result girlAdd(@Valid Girl girl, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }

        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
        return ResultUtil.success(0,"成功",girlRepository.save(girl));
    }

    /**
     * 根据 id 查询一个女生
     * @param id
     * @return
     */
    @GetMapping("/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id){
        return girlRepository.findById(id).get();
    }

    /**
     * 根据 id 更新一个女生
     * @param id
     * @return
     */
    @PutMapping("/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id,
                            @RequestParam("cupSize") String cupSize,
                            @RequestParam("age") Integer age){
        Girl girl=new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    /**
     * 根据 id 删除一个女生
     * @param id
     */
    @DeleteMapping("/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id){
        Girl girl=new Girl();
        girl.setId(id);
        girlRepository.delete(girl);
    }

    /**
     * 根据年龄查询女生列表
     */
    @GetMapping("/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    /**
     * 插入两条数据
     */
    @PostMapping("/girls/two")
    public void insertTwo(){
        girlService.insertTwo();
    }

    /**
     * 获取女生年龄
     */
    @GetMapping("/girls/getAge/{id}")
    public Result getAge(@PathVariable("id") Integer id){
        return girlService.getAge(id);
    }
}
