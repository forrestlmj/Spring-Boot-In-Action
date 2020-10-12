package com.atguigu.spring5;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：10/12/20 8:07 PM
 */


public class User {
    public void add(){
        System.out.println("add....");
    }
    @Test
    public void testAdd(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("bean1.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println(user);
        user.add();
    }
    @Test
    public void testBook(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("bean1.xml");
        Book book = applicationContext.getBean("book", Book.class);
        System.out.println(book);
    }
}
