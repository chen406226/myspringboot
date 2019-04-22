package com.note.controller;

import com.note.mapper.BookMapper;
import com.note.mapper.ReceptionMapper;
import com.note.server.CityServer;
import com.note.server.ReceptionServer;
import com.note.util.SendEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2019/4/16.
 */
@RestController
public class citycontroller {

    @Autowired
    private CityServer cityServer;
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private ReceptionMapper receptionMapper;
    @Autowired
    private ReceptionServer receptionServer;
    @Autowired
    SendEmail sendEmail;

    @RequestMapping("/note")
    public Long note(String name){
        return cityServer.addNote(name);
    }
    @RequestMapping("/sdf")
    public void df(){
//        List<Book> list = bookMapper.findAll();
//        List<Reception> list = receptionMapper.findAll();

//        List<Reception> list = receptionServer.findByBookId(1);

        sendEmail.sendmail(1,"冰山吗","2225");

//        Book bok = new Book();
//        bok.setCheckkey("2222");
//        bok.setId(1);
//        long list = bookMapper.updateBook(bok);
//        for (Reception reception:list
//             ) {
//            System.out.print("out");
//        }
//        return list;
    }
}
