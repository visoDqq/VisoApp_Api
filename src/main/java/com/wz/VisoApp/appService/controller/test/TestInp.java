package com.wz.VisoApp.appService.controller.test;

import com.wz.VisoApp.common.beans.ResultBean;
import com.wz.VisoApp.common.exception.CheckException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chenwuxiong on 2017/12/7.
 */
@RestController
@RequestMapping("/inp")
public class TestInp {

    @GetMapping
    public ResultBean test(){
        if ("1".equals("1"))
            throw new CheckException("测试异常");
        return new ResultBean("123432");
    }
}
