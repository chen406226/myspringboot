package com.note.task;

import com.note.mapper.BookMapper;
import com.note.schema.Book;
import com.note.template.Booktemplate;
import com.note.util.SendEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/4/17.
 */

@Component
@Service
public class Receptiontask {

    @Autowired
    BookMapper bookMapper;

    @Autowired
    SendEmail sendEmail;

//    @Scheduled(cron = "0/10 10 * * * ?")
    @Scheduled(initialDelay=1000,fixedRate=600000)
    private void process(){
        System.out.println("task run");
        List<Book> list = bookMapper.findAll();
        for (Book book:list) {
            int btype = book.getBtype();
            String checkkey = book.getCheckkey();
            String url = book.getUrl();
            String uname = book.getUname();
            String booki = book.getBook();
            int id = book.getId();
            switch (btype){
                case 1:
                    String checkstring = Booktemplate.youle(url,booki,checkkey);
                    if (!checkstring.equals(checkkey)){
                        Book bok = new Book();
                        bok.setId(id);
                        bok.setCheckkey(checkstring);
                        bookMapper.updateBook(bok);
                        sendEmail.sendmail(id,uname,checkstring);
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
