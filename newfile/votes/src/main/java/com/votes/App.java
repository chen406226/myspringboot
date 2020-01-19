package com.votes;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * votes
 *
 */
@SpringBootApplication
@MapperScan("com.votes.mapper")
public class App 
{
//    private static Object SpringApplication;

    public static void main(String[] args )
    {
        System.out.println( "Start runing!" );
//        System.out.println(SpringApplication.run);
        SpringApplication.run(App.class, args);
    }
}
