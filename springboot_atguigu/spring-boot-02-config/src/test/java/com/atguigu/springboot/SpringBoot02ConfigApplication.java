package com.atguigu.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：11/2/20 3:34 PM
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot02ConfigApplication {
    @Autowired
    ApplicationContext ioc;

    @Test
    public void testIoc(){
        String[] beans = ioc.getBeanDefinitionNames();
        System.out.println(beans);
    }
}
