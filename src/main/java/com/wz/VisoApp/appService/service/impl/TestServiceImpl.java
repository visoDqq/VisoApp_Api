package com.wz.VisoApp.appService.service.impl;

import com.wz.VisoApp.appService.dao.TestDao;
import com.wz.VisoApp.appService.service.TestService;
import com.wz.VisoApp.model.entity.Test;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by chenwuxiong on 2017/11/30.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TestServiceImpl implements TestService{

    @Resource
    private TestDao testDao;

    @Override
    public void saveEntity(Test test) throws Exception {
        testDao.saveEntity(test);
    }

    @Override
    public void updateEntity(Test test) throws Exception {
        testDao.updateEntity(test);
    }

    @Override
    public Test getEntityById(String id) throws Exception {
        return testDao.getEntityById(id,Test.class);
    }
}
