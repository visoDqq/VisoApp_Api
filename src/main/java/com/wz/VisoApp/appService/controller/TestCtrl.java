package com.wz.VisoApp.appService.controller;

import com.wz.VisoApp.appService.service.TestService;
import com.wz.VisoApp.model.entity.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by chenwuxiong on 2017/11/30.
 */
@RestController
@RequestMapping(value = "/test")
public class TestCtrl {

    @Resource
    private TestService testService;

    @RequestMapping(value = "test2", method = RequestMethod.GET, produces = "application/json")
    public Test test1(){
        Test test = new Test();
        test.setName("a");
        try {
            testService.saveEntity(test);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return test;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public Test test2(){
        Test test1 = new Test();
        try {
            test1 = testService.getEntityById("1");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return test1;
    }
}
