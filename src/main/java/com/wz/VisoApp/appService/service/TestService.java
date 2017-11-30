package com.wz.VisoApp.appService.service;


import com.wz.VisoApp.model.entity.Test;

/**
 * Created by chenwuxiong on 2017/11/30.
 */
public interface TestService {

    void saveEntity(Test test)throws Exception;

    void updateEntity(Test test)throws Exception;

    Test getEntityById(String id)throws Exception;
}
