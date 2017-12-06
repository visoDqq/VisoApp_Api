package com.wz.VisoApp.appService.test;

import com.mongodb.DB;
import com.mongodb.Mongo;

import java.util.Set;

/**
 * Created by chenwuxiong on 2017/12/6.
 */
public class MongoTest {

    public static void main(String[] args) {
        Mongo mongo = new Mongo("192.168.107.129",27017);
        DB db = mongo.getDB("test");
        Set<String> set = db.getCollectionNames();
        for (String s : set){
            System.out.println(s);
        }
    }
}
