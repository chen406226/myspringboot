package com.note.server;

import com.note.schema.Reception;

import java.util.List;

/**
 * Created by Administrator on 2019/4/18.
 * 因为SendEmail里面没发用@AUtowrite获得实例所以提供server
 */
public interface ReceptionServer {
    public List<Reception> findByBookId(int bookId);
}
