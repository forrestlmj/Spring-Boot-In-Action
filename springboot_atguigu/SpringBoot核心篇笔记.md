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

## 4、配置文件占位符

## 5、Profie

### 5.1、多Profile文件

默认使用application.yml文件

### 5.2 yml支持多文档块方式

yml的多文档块比properties好，因为可以在一个文件中管理所有环境。

```yaml
server:
	port: 8081
spring:
	profiles:
		active: prod
---
spring:
	profiles: dev
server:
	port: 8083

---
spring:
	profiles: prod
server:
	port: 8084
```

### 5.3、激活指定的profile

1、在yml文件中定义默认的：spring.profiles.activate=dev

2、在命令行：

java -jar spring-boot-02-config-0.0.1-SNAPSHOT.jar --spring.profiles.activate=dev;

3、虚拟机参数

-Dspring.profiles.activate=dev

## 6、配置文件的加载位置

从高到低：

-file:./config

-file:./

-classpath:/config

-classpath:/

## 7、外部配置加载顺序

从高到低：

* ###### 1、命令行参数：java -jar xxx.jar --server.port=8081

* 2、来自java:comp/env的JNDI属性

* 3、Java系统属性（System.getProperties()）

* 4、操作系统环境变量

* 5、RandomValuePropertySource

* ###### 6、jar包外部的application-{profile}.properties

* ###### 7、jar包内部的application-{profile}.properties

* ###### 8、jar包外部的application.properties

* ###### 9、jar包内部的application.properties

* 10、@Configuration注解类上的@PropertySource

## 8、自动配置原理

### 8.0、Java的四个元注解

在学习Spring的自动配置原理之前，必须了解Java的四个元注解：@Documented、@Target、@Retention、@Inherited

可以看这篇[博客](https://blog.csdn.net/lkp1603645756/article/details/84072600)，初步理解。

* @Documented。它代表着此注解会被Javadoc工具提取成文档。
* **@Target**。这个注解比较重要，代表注解可以用在什么地方。
  - ElementType.**TYPE**。类、接口、enum。
  - ElementType.**CONSTRUCTOR**。构造器声明。
  - ElemenetType.**METHOD**。方法。
  - ElemenetType.**FIELD**。域声明（包括 enum 实例） 
  - ElemenetType.**PARAMETER**。参数声明。比如@RequestParam
  - ElemenetType.**PACKAGE**。包声明
  - ElemenetType.**LOCAL_VARIABLE**。局部变量声明
* **@Retention**。表示在哪个阶段保留注解信息
  - RetentionPolicy.SOURCE。源码保留，但会被编译器丢弃。
  - RetentionPolicy.CLASS。class中可用但会被VM丢弃。
  - RetentionPolicy.RUNTIME。VM保留，因此可以通过**反射机制**读取注解的信息。
* @Inherited。允许子类继承父类中的注解。

比如经常使用的@Service注解源码是这样的：

```java
package org.springframework.stereotype;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.TYPE})
@Retention({RententionPolicy.RUNTIME})
@Component
public @interface Service{
    String value() default "";
}
```



### 8.1、自动配置原理

1、SpringBoot启动的时候加载**主配置类**，开启了自动配置功能**@EnableAutoConfiguration**。

2、@EnableAutoConfiguration作用：

* 利用EnableAutoConfigurationImportSelector给容器导入了一些组件。
* 可以查看selectImports()方法
* List configurations = getCandidateConfigurations(annotationMetadata, attributes)

```
解释：
1、SpringFactoriesLoader.loadFactoryNames()。
2、扫描所有jar包类路径下，META-INF/spring.factories。
3、把扫描到的这些文件的内容包装成properties对象。
4、从properties中获取到EnableAutoConfiguration.class类（类名）对应的值，然后把他们添加在容器中。

```

将类路径下META-INF/spring.factories里面配置的所有EnableAutoConfiguration的值加载到容器中：

```xml

# Initializers
org.springframework.context.ApplicationContextInitializer=\
org.springframework.boot.autoconfigure.SharedMetadataReaderFactoryContextInitializer,\
org.springframework.boot.autoconfigure.logging.AutoConfigurationReportLoggingInitializer

# Application Listeners
org.springframework.context.ApplicationListener=\
org.springframework.boot.autoconfigure.BackgroundPreinitializer

# Auto Configuration Import Listeners
org.springframework.boot.autoconfigure.AutoConfigurationImportListener=\
org.springframework.boot.autoconfigure.condition.ConditionEvaluationReportAutoConfigurationImportListener

# Auto Configuration Import Filters
org.springframework.boot.autoconfigure.AutoConfigurationImportFilter=\
org.springframework.boot.autoconfigure.condition.OnClassCondition

# Auto Configure
org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
org.springframework.boot.autoconfigure.admin.SpringApplicationAdminJmxAutoConfiguration,\
org.springframework.boot.autoconfigure.aop.AopAutoConfiguration,\
org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration,\
org.springframework.boot.autoconfigure.batch.BatchAutoConfiguration,\
org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration,\
org.springframework.boot.autoconfigure.cassandra.CassandraAutoConfiguration,\
org.springframework.boot.autoconfigure.cloud.CloudAutoConfiguration,\
org.springframework.boot.autoconfigure.context.ConfigurationPropertiesAutoConfiguration,\
org.springframework.boot.autoconfigure.context.MessageSourceAutoConfiguration,\
org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration,\
org.springframework.boot.autoconfigure.couchbase.CouchbaseAutoConfiguration,\
org.springframework.boot.autoconfigure.dao.PersistenceExceptionTranslationAutoConfiguration,\
org.springframework.boot.autoconfigure.data.cassandra.CassandraDataAutoConfiguration,\
org.springframework.boot.autoconfigure.data.cassandra.CassandraRepositoriesAutoConfiguration,\
org.springframework.boot.autoconfigure.data.couchbase.CouchbaseDataAutoConfiguration,\
org.springframework.boot.autoconfigure.data.couchbase.CouchbaseRepositoriesAutoConfiguration,\
org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchAutoConfiguration,\
org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchDataAutoConfiguration,\
org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchRepositoriesAutoConfiguration,\
org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration,\
org.springframework.boot.autoconfigure.data.ldap.LdapDataAutoConfiguration,\
org.springframework.boot.autoconfigure.data.ldap.LdapRepositoriesAutoConfiguration,\
org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration,\
org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration,\
org.springframework.boot.autoconfigure.data.neo4j.Neo4jDataAutoConfiguration,\
org.springframework.boot.autoconfigure.data.neo4j.Neo4jRepositoriesAutoConfiguration,\
org.springframework.boot.autoconfigure.data.solr.SolrRepositoriesAutoConfiguration,\
org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration,\
org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration,\
org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration,\
org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration,\
org.springframework.boot.autoconfigure.elasticsearch.jest.JestAutoConfiguration,\
org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration,\
org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration,\
org.springframework.boot.autoconfigure.h2.H2ConsoleAutoConfiguration,\
org.springframework.boot.autoconfigure.hateoas.HypermediaAutoConfiguration,\
org.springframework.boot.autoconfigure.hazelcast.HazelcastAutoConfiguration,\
org.springframework.boot.autoconfigure.hazelcast.HazelcastJpaDependencyAutoConfiguration,\
org.springframework.boot.autoconfigure.info.ProjectInfoAutoConfiguration,\
org.springframework.boot.autoconfigure.integration.IntegrationAutoConfiguration,\
org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration,\
org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration,\
org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration,\
org.springframework.boot.autoconfigure.jdbc.JndiDataSourceAutoConfiguration,\
org.springframework.boot.autoconfigure.jdbc.XADataSourceAutoConfiguration,\
org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration,\
org.springframework.boot.autoconfigure.jms.JmsAutoConfiguration,\
org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration,\
org.springframework.boot.autoconfigure.jms.JndiConnectionFactoryAutoConfiguration,\
org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration,\
org.springframework.boot.autoconfigure.jms.artemis.ArtemisAutoConfiguration,\
org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration,\
org.springframework.boot.autoconfigure.groovy.template.GroovyTemplateAutoConfiguration,\
org.springframework.boot.autoconfigure.jersey.JerseyAutoConfiguration,\
org.springframework.boot.autoconfigure.jooq.JooqAutoConfiguration,\
org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration,\
org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapAutoConfiguration,\
org.springframework.boot.autoconfigure.ldap.LdapAutoConfiguration,\
org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration,\
org.springframework.boot.autoconfigure.mail.MailSenderAutoConfiguration,\
org.springframework.boot.autoconfigure.mail.MailSenderValidatorAutoConfiguration,\
org.springframework.boot.autoconfigure.mobile.DeviceResolverAutoConfiguration,\
org.springframework.boot.autoconfigure.mobile.DeviceDelegatingViewResolverAutoConfiguration,\
org.springframework.boot.autoconfigure.mobile.SitePreferenceAutoConfiguration,\
org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration,\
org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration,\
org.springframework.boot.autoconfigure.mustache.MustacheAutoConfiguration,\
org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration,\
org.springframework.boot.autoconfigure.reactor.ReactorAutoConfiguration,\
org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration,\
org.springframework.boot.autoconfigure.security.SecurityFilterAutoConfiguration,\
org.springframework.boot.autoconfigure.security.FallbackWebSecurityAutoConfiguration,\
org.springframework.boot.autoconfigure.security.oauth2.OAuth2AutoConfiguration,\
org.springframework.boot.autoconfigure.sendgrid.SendGridAutoConfiguration,\
org.springframework.boot.autoconfigure.session.SessionAutoConfiguration,\
org.springframework.boot.autoconfigure.social.SocialWebAutoConfiguration,\
org.springframework.boot.autoconfigure.social.FacebookAutoConfiguration,\
org.springframework.boot.autoconfigure.social.LinkedInAutoConfiguration,\
org.springframework.boot.autoconfigure.social.TwitterAutoConfiguration,\
org.springframework.boot.autoconfigure.solr.SolrAutoConfiguration,\
org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration,\
org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration,\
org.springframework.boot.autoconfigure.transaction.jta.JtaAutoConfiguration,\
org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration,\
org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration,\
org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration,\
org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration,\
org.springframework.boot.autoconfigure.web.HttpEncodingAutoConfiguration,\
org.springframework.boot.autoconfigure.web.HttpMessageConvertersAutoConfiguration,\
org.springframework.boot.autoconfigure.web.MultipartAutoConfiguration,\
org.springframework.boot.autoconfigure.web.ServerPropertiesAutoConfiguration,\
org.springframework.boot.autoconfigure.web.WebClientAutoConfiguration,\
org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration,\
org.springframework.boot.autoconfigure.websocket.WebSocketAutoConfiguration,\
org.springframework.boot.autoconfigure.websocket.WebSocketMessagingAutoConfiguration,\
org.springframework.boot.autoconfigure.webservices.WebServicesAutoConfiguration

# Failure analyzers
org.springframework.boot.diagnostics.FailureAnalyzer=\
org.springframework.boot.autoconfigure.diagnostics.analyzer.NoSuchBeanDefinitionFailureAnalyzer,\
org.springframework.boot.autoconfigure.jdbc.DataSourceBeanCreationFailureAnalyzer,\
org.springframework.boot.autoconfigure.jdbc.HikariDriverConfigurationFailureAnalyzer

# Template availability providers
org.springframework.boot.autoconfigure.template.TemplateAvailabilityProvider=\
org.springframework.boot.autoconfigure.freemarker.FreeMarkerTemplateAvailabilityProvider,\
org.springframework.boot.autoconfigure.mustache.MustacheTemplateAvailabilityProvider,\
org.springframework.boot.autoconfigure.groovy.template.GroovyTemplateAvailabilityProvider,\
org.springframework.boot.autoconfigure.thymeleaf.ThymeleafTemplateAvailabilityProvider,\
org.springframework.boot.autoconfigure.web.JspTemplateAvailabilityProvider

```

每一个这样的xxxAutoConfiguration类都是容器中的一个组件，都加入到容器中；用他们来做配置。

3、每一个自动配置类进行自动配置功能。

4、以**HttpEncodingAutoConfiguration**为例解释自动配置原理。TODO

```java
@Configuration
@EnableConfigurationProperties(HttpEncodingProperties.class)
@ConditionOnWebApplication
@ConditionOnClass

```



# 三、日志

TODO

# 四、Web开发



### 8、配置嵌入式Servlet容器

TODO

# 

# 六、SpringBoot与数据访问



## 6.1、JDBC

```xml
<dependency>
	<groupId>org.framework.boot</groupId>	
    <artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>
<dependency>
	<groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
</dependency>
```

```yml
spring:
	datasource:
		username: root
		password: 123456
		url: jdbc:mysql:///jdbc
		driver-class-name: com.mysql.jdbc.Driver
```

效果：

默认是用org.springframework.boot.autoconfigure.jdbc作为数据源;

数据源的相关配置在DataSourceProperties里面。

自动配置原理：

org.springframework.boot.autoconfigure.jdbc:

1、参考DataSourceConfiguration，根据配置创建数据源，默认使用Tomcat连接池；可以使用spring.datasource.type指定自定义的数据源类型。

2、SpringBoot默认可以支持：

```
org.apache.tomcat.jdbc.pool.DataSource、HikariDataSource、BasicDataSource、
```

3、自定义数据源类型

```java
@ConditionalOnMissingBean(DataSource.class)
@ConditionalOnProperty(name = "spring.datasource.type")
static class Generic {
    @Bean
    public DataSource dataSource(DataSourceProperties properties){
        // 使用DataSourceBuilder创建数据源，利用反射创建相应type的数据源，并且相关属性。
        return properties.initializeDataSourceBuilder().build();
    }
}
```

4、DataSourceInitializer:ApplicationListener;

```yml
schema:
	- classpath:department.sql
```



## 6.2、整合Druid数据源

#### 6.2.1、如果不是用Druid也可以

上述过程如果不整合durid也可以访问，只需要配置yml文件中的以下配置即可

```yml
spring:
	datasource:
		username: root
		password: root
		url: jdbc:mysql:///jdbc
		driver-class-name: com.mysql.jdbc.Driver
```

在Controller中引入JDBCTemplate

```java
@Autowired
private JDBCTemplate jdbcTemplate
    
```

然后在Controller直接写sql即可

```java
List<Map<String, Object>> map =  jdbcTemplate.query("select * from departement");
```

这个时候使用的Connection类型是：

```yml
org.apache.tomcat.jdbc.pool.DataSource
```

#### 6.2.2、如果使用的是Druid

只需要在yml文件中定义好datasource为druid即可，同时添加以下Druid的Config 文件，用于把ServletRegistrationBean、FilterRegistrationBean注册到SpringBoot的Servlet容器中，这样可以访问Druid的配置页面。

```java
@Configuration
public class DruidConfig {
    @ConfigurationProperties(prefix="spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }
    
    //配置Druid的配置
    //1、配置一个管理后台的Servlet
    @Bean
    public ServletRegistration statViewServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), '/druid/*');
        Map<String,String> initParams = new HashMap<>();
        // 配置druid的登陆用户名
        initParams.put("loginUsername","admin");
        initParams.put("loginPassword","123456");
        // 默认就是允许所有访问
        initParams.put("allow","");
        
        bean.setInitParameters(initParams);
        return bean;
    }
}
```

## 6.3 整合MyBatis

```xml
<dependency>
	<groupId>org.mybatis.spring.boot</groupId>
	<artifactId>mybatis-spring-boot-starter</artifactId>
	<version>1.3.1</version>
</dependency>

```

步骤：

6.3.1、配置数据源相关属性。

6.3.2、给数据库建表。

6.3.3、创建JavaBean。

6.3.4、注解版

```java
@Mapper
public interface DepartmentMapper{
    @Select("select * from department where id = #{id}")
    public Department getDeptById(Integer id);
    
    @Delete("delete from department where id  = #{id}")
    public int deleteDeptById(Integer id);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into department(departmentName) value (#{departmentName})")
    public int insertDept(Department department);
    
    @Update("update department set departmentName = #{departmentName} where id = #{id}")
    public int updateDept(Department department);
}

```

6.3.5、注解版本

```xml
mybatis:
	config-location: classpath:mybatis/mybatis-config.xml
 	mapper-locations: classpath:mybaits/mapper/*.xml
```

## 6.4、整合SpringData JPA



### 6.4.1、SpringData简介

Application->SpringData->SpringData JPA/SpringData Redis/SpringData MongoDB->JPA规范->Hibernate/Toplink/OpenJPA

### 6.4.2、整合SpringData JPA

JPA;ORM 映射

1、编写一个实体类（bean）和数据表进行映射、并且配置好映射关系。

```java
@Entity
@Table(name="tbl_user")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "last_name",length = 50)
    private String lastName;
    @Column
    private String email;
}

```

2、编写一个Dao接口来操作实体类对应的数据表

```java
public interface UserRepository extends JpaRepository<User, Integer>{
    
}
```

3、基本的JpaProperties

```java
spring:
	jpa:
		hibernate:
			ddl-auto: update
         show-sql: true
```





























































