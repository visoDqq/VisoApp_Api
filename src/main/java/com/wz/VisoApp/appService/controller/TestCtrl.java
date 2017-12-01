package com.wz.VisoApp.appService.controller;

import com.wz.VisoApp.appService.service.TestService;
import com.wz.VisoApp.common.aop.ControllerAop;
import com.wz.VisoApp.common.beans.ResultBean;
import com.wz.VisoApp.common.exception.CheckException;
import com.wz.VisoApp.common.util.UserUtil;
import com.wz.VisoApp.model.entity.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger logger = LoggerFactory.getLogger(TestCtrl.class);

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
    public ResultBean<Test> test2(){
        Test test1 = new Test();
        try {
            test1 = testService.getEntityById("1");
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("ctrl UserUtil.getUserId()=" + UserUtil.getUserId());
        if ("1".equals("1")){
            throw new CheckException("抛出异常");
        }
        return new ResultBean<Test>(test1);
    }

    @RequestMapping(method = RequestMethod.PUT, produces = "application/json")
    public ResultBean<Test> test3(){
        Test test1 = new Test();
        String s = null;
        if (s.equals("1")){
        }
        return new ResultBean<Test>(test1);
    }


    public static void main(String[] args) {
        TestCtrl controllerAop = new TestCtrl();
        try {
            throw new Exception("111");
        }catch (Exception e){
            controllerAop.logger.error("123",e);
        }

    }

}
