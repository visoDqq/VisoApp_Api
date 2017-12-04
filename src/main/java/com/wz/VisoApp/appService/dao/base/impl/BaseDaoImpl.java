package com.wz.VisoApp.appService.dao.base.impl;

import com.wz.VisoApp.appService.dao.base.BaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.annotation.Resource;

/**
 * Created by chenwuxiong on 2017/11/30.
 */
public class BaseDaoImpl implements BaseDao{

    @Resource
    private SessionFactory sessionFactory;

    protected Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    protected Session getNewSession(){
        return sessionFactory.openSession();
    }

    @Override
    public <T> void saveEntity(T t) throws Exception {
        sessionFactory.getCurrentSession().save(t);
    }

    @Override
    public <T> void updateEntity(T t) throws Exception {
        sessionFactory.getCurrentSession().update(t);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T getEntityById(String id, Class<T> clazz) throws Exception {
        return (T)sessionFactory.getCurrentSession().get(clazz, id);
    }
}
