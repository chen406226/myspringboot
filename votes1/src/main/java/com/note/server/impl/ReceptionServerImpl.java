package com.note.server.impl;

import com.note.mapper.ReceptionMapper;
import com.note.schema.Reception;
import com.note.server.ReceptionServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2019/4/18.
 */

@Service
@Transactional
public class ReceptionServerImpl implements ReceptionServer{
    @Autowired
    private ReceptionMapper receptionMapper;

    public List<Reception> findByBookId(int bookId){
        return receptionMapper.findByBookId(bookId);
    }
}
