# 一、Spring Boot入门

## 1、Spring Boot简介

## 2、微服务

## 3、环境准备

## 4、Spring Boot HelloWorld

### 4.1 创建maven项目

### 4.2 导入Spring boot相关依赖

```xml
<parent>
	<groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>1.5.9.RELEASE</version>
</parent>
<dependencies>
<dependency>
	<groupId>org.springframework.boot</groupId>
 	<artifactId>spring‐boot‐starter‐web</artifactId>
</dependency>
</dependencies>


```

### 4.3 编写一个主程序，启动Spring Boot应用

```java
@SpringBootApplication
public class HelloWorldApplication{
    public static void main(String[] args){
        SpringApplication.run(HelloWorldApplication.class, args);
    }
}

```

### 4.4 编写相关Controller

```java
@RestController
public class HelloController{
    @RequestMapping("/hello")
    public String hello(){
        return "hello;";
    }
}

```

## 5、Hello World探究

# 二、配置文件

## 1、配置文件

SpringBoot使用一个全局的配置文件，配置文件名是固定的：

* application.properties
* application.yml

配置文件作用：

* 修改SpringBoot自动配置的默认值
* SpringBoot在底层都自动配置好

YAML：

```yaml
server:
  port: 8081
 
```

XML：

```xml
<server>
	<port>8081</port>
</server>
```

## 2、YAML语法

### 2.1、基本语法

k:(空格)v：表示一对键值对，空格必须有。

以空格的缩进来控制层级关系。只要是左对齐的一列数据，都是一个层级的。

```yaml
server:
	port: 8081
	path: /hello

```

### 2.2、值的写法

分为普通写法与行内写法。

1、对象、Map

普通写法：

```yaml
friends: 
		lastName: zhangsan
		age: 20
```

行内写法：

```yaml
friends: {lastName: zhangsan,age: 18}
```

2、数组（List/Set）

```yaml
pets: 
	- cat
	- dog
	- pig

```

行内写法：

```yaml
pets: [cat,dog,pig]
```





[@PropertySource与@ConfigurationProperties](https://juejin.im/post/6844903992544198664)















































































