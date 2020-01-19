package com.kfit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@MapperScan("com.kfit.*.mapper")  //不写找不到mapper
public class App 
{
    public static void main( String[] args ){
        System.out.println( "Hello World!" );
        SpringApplication.run(App.class, args);
        
    }
}

/*
 * 编写实体类Demo.java
 * 编写DEmo.xml主要配置sql语句
 * 编写DemoMapper供给service调用
 * 编写Service,DemoService
 * 编写DemoController,范文demoService
 * 需要再application.properties文件添加数据库配置信息以及指定mapper.xml的路径
 * 编写启动类，再启动类中使用@MapperScan指定mapper类的包路径
 * 
 * 
 * */
