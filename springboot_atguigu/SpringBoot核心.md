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

## 3、配置文件值注入

### 3.0、Value用法

配置文件（application.properties)

```properties
person.lastName=ck
```

JavaBean:

```java

@Componet
public class Person{
    @Value("${person.lastName}")
    private String lastName;
}

```

RestController使用的时候，直接@Autowired，注入到类中即可。

```java

@RestController
public class RController{
    @Autowired
    private Person person;
    
    @GetMapping("/person")
    public String person(
    	return person.toString();
    )
}
```

### 3.1、ConfigurationProperties用法



配置文件（application.yml）

```yaml
person:
	lastName: hello
	age: 18
	boss: false
	birth: 2017/12/12
	maps: {k1: v1,k2: 12}
	lists:
		- lisi
		- zhaoliu
	dog:
		name: 小狗
		age: 18
```

JavaBean:

```java
/** 将配置文件中配置的每一个属性的值，映射到这个组件中，
 * @ConfigurationProperties: 告诉SpringBoot将本类中的所有属性和配置文件中相关的配置进行绑定。
 		@ConfigurationProperties(value = "person")，配置文件中person.xxx的所有属性一一对应。
 * 只用将这个组件注册到容器中的时候，使用（@Component）才能
@Componet
@ConfigurationProperties(value = "person")
public class Person{
	private String lastName;
	private Integer age;
	private Boolean boss;
	private Date birth;
	
	private Map<String,Object> maps;
	private List<Object> lists;
	private Dog dog;
}

```

在maven中倒入spring-boot-configuration-processor

```xml

<!‐‐导入配置文件处理器,配置文件进行绑定就会有提示‐‐>

<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring‐boot‐configuration‐processor</artifactId>
	<optional>true</optional>
</dependency>
```

### 3.2、@Value获取值与@ConfigurationProperties获取值比较



|          | @ConfigurationProperties | @Value     |
| -------- | :----------------------: | ---------- |
| 功能     | 批量注入配置文件中的属性 | 一个个指定 |
| 松散绑定 |           支持           | 不支持     |
|          |                          |            |
|          |                          |            |
|          |                          |            |

* 如果说，我们只是在某个业务逻辑中需要获取配置文件中的某个值，使用@Value
* 如果说，我们专门编写了一个JavaBean来和配置文件进行映射，我们使用@ConfigurationProperties

### 3.3、配置文件注入值数据教研

使用@Validated注解、@Email注解验证邮箱验证。

### 3.4、@PropertySource与@ImportResource & @Bean

@PropertySource:加载指定的配置文件。

```java
@PropertySource(value = {"classpath:person.properties"})
@Component
@ConfigurationProperties(prefix = "person")
public class Person{
    ...
}
```

上面的意思指的是从类路径中找到person.properties中找到person为前缀的配置，将配置注入到Person中。

[@PropertySource与@ConfigurationProperties](https://juejin.im/post/6844903992544198664)

### 3.5、使用@Configuration与@Bean给容器中添加组件

```java
/**
* @Configuration:当前类是一个配置类，用来替换之前的Spring文件。
* 等同于<bean></bean>
*/
@Configuration
public class MyAppConfig{
    //将方法的返回值返回到容器中；容器中这个组件的默认id就是方法名helloService02
    @Bean
    public HelloService helloService02(){
        return new HelloService();
    }
}

```













































































