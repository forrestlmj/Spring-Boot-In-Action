package com.yck.springbootselflearning.service;

import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class HBaseServiceTest {
    @Autowired
    private HBaseService hBaseService;
    @Test
    public void getRowKeyAndColumn() {
    }

    @Test
    public void getListRowkeyData() {
         byte[] COLUMN_FAMILY = "info1".getBytes();
         byte[] NAME = "name".getBytes();
         byte[] AGE = "age".getBytes();
        List<Result> resultList = hBaseService.getListRowkeyData("stu", Arrays.asList("1001"),"info1","name");
        for(Result result:resultList){
            String name = Bytes.toString(result.getValue(COLUMN_FAMILY,NAME));
            System.out.println(name);
        }
    }
}