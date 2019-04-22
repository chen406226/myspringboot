package com.note.mapper;

import com.note.schema.Book;

import java.util.List;

/**
 * Created by Administrator on 2019/4/16.
 */
public interface BookMapper {

    public List<Book> findAll();
    public long updateBook(Book book);
}
