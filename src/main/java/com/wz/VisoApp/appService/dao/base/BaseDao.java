package com.wz.VisoApp.appService.dao.base;

/**
 * Created by chenwuxiong on 2017/11/30.
 */
public interface BaseDao {

    <T> void saveEntity(T t)throws Exception;

    <T> void updateEntity(T t)throws Exception;

    <T> T getEntityById(String id, Class<T> clazz)throws Exception;
}
