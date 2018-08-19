package com.kfit;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;

/**
 * Hello world!
 *spring boot 启动类
 */
@SpringBootApplication
@MapperScan("com.kfit*") //"com.kfit.*.mapper"扫描该包下相应的class主要是mybatis持久化
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SpringApplication.run(App.class, args);
    }
}
/*xml动态sql
 * if标签
 * if+where条件判断
 * if+set更新
 * if+trim代替where/set标签
 * choose(when,otherwist)
 * foreach
 */