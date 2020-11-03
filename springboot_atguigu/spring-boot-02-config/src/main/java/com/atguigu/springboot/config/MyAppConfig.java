package com.atguigu.springboot.config;

import com.atguigu.springboot.bean.Person;
import com.atguigu.springboot.service.HelloService;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：11/2/20 7:39 PM
 */

@Configuration
public class MyAppConfig {
    @Bean
    public HelloService helloService02(){
        System.out.println("配置类@Bean给容器添加组件");
        HelloService helloService = new HelloService();
//        System.out.println(helloService.toString());
        return new HelloService();
    }
}
