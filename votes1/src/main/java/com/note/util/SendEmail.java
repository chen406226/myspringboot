package com.note.util;

import com.note.mapper.BookMapper;
import com.note.schema.Reception;
import com.note.server.MailServer;
import com.note.server.ReceptionServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/4/17.
 */
@Component
@Service
public class SendEmail {

    @Autowired
    ReceptionServer receptionServer;

    @Autowired
    BookMapper bookMapper;

    @Autowired
    MailServer mailServer;

    public void sendmail(int bookId,String uname,String checkkey){
        List<Reception> receptions = receptionServer.findByBookId(bookId);
        for (Reception reception:receptions) {
            String email = reception.getEmail();
            String title = uname+checkkey;
            String context = "你好！你关注的小说："+uname+"更新到第"+checkkey+"章节了";
            mailServer.sendSimpleMail(email,title,context);
            System.out.print("发送邮件");
        }
    }
}
