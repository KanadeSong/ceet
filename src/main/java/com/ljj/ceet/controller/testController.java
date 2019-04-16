package com.ljj.ceet.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @CLassName testController
 * @Description TODO
 * @Author LeeJack
 * @Date 2019/4/16/016 10:11
 * @Version 1.0
 */
@RestController
public class testController {
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        return "test";
    }

}
