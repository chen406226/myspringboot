package com.note;

import com.note.util.HttpClientUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Hello world!
 *
 */

@EnableScheduling
@SpringBootApplication
@MapperScan("com.note.mapper")
public class App 
{
    public static void main( String[] args ){
        HttpClientUtil.init();
        SpringApplication.run(App.class, args);
    }
}
