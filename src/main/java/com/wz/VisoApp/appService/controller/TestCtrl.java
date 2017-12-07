package com.wz.VisoApp.appService.controller;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSFile;
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import com.wz.VisoApp.appService.service.TestService;
import com.wz.VisoApp.common.aop.ControllerAop;
import com.wz.VisoApp.common.beans.ResultBean;
import com.wz.VisoApp.common.exception.CheckException;
import com.wz.VisoApp.common.util.UserUtil;
import com.wz.VisoApp.model.entity.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chenwuxiong on 2017/11/30.
 */
@RestController
@RequestMapping(value = "/test")
public class TestCtrl {

    private final Logger logger = LoggerFactory.getLogger(TestCtrl.class);

    @Resource
    private TestService testService;

    @Resource
    private MongoTemplate mongoTemplate;

    @Resource
    private GridFsTemplate gridFsTemplate;

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

//    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @GetMapping
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

    @RequestMapping(value = "/file",method = RequestMethod.POST, produces = "application/json")
    public ResultBean<List<Test>> test3(@RequestParam("myFile") MultipartFile file) throws IOException {
        if (file == null){
            return new ResultBean<List<Test>>();
        }
        Test test1 = new Test();
//        Map map = new HashMap();
//        map.put("id",1);
//        map.put("name","aaa");
//        map.put("sex","f");
//        test1.setName("qweasd");
//        mongoTemplate.insert(test1,"a");
//        DBObject dbObject = new BasicDBObject();
//        dbObject.put("username","qweert");
//        dbObject.put("name","aaaa");
//        mongoTemplate.insert(dbObject,"a");
        Query query = new Query();
        Criteria criteria = new Criteria("name");
        criteria.is("aaa");
        query.addCriteria(criteria);
        List<HashMap> mapList = mongoTemplate.find(query,HashMap.class,"a");
        System.out.println(mapList);
        List<Test> test = mongoTemplate.find(new Query(new Criteria("name").is("qweasd")),Test.class,"a");

        GridFSFile gridFSFile = null;
        InputStream is = file.getInputStream();
        byte[] bytes = new byte[is.available()];
        is.read(bytes);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        DBObject dbObject2 = new BasicDBObject();
        dbObject2.put("myid","1234586");
        dbObject2.put("nameop","56746746");
        gridFSFile = gridFsTemplate.store(byteArrayInputStream,file.getOriginalFilename(),"picture",dbObject2);
        gridFSFile.save();
        return new ResultBean<List<Test>>(test);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public ResultBean<Test> test4(){
        Test test1 = new Test();
        testService.updateList();
        return new ResultBean<Test>();
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
