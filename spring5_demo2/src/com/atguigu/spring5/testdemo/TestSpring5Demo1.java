package com.atguigu.spring5.testdemo;

import com.atguigu.spring5.collectiontype.Stu;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：10/14/20 3:23 PM
 */


public class TestSpring5Demo1 {
    @Test
    public void testBean1(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("bean1.xml");
        Stu stu = applicationContext.getBean("stu",Stu.class);
        System.out.println(stu);
    }
}
