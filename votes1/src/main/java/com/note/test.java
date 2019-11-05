package com.note;

import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2019/4/16.
 */
@RestController
public class test {
    @RequestMapping("/hello")
    public String he(){
        return "hellow sdf";
    }
}
