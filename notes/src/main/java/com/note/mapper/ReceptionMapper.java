package com.note.mapper;

import com.note.schema.Reception;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/4/17.
 */
public interface ReceptionMapper {
    public List<Reception> findAll();
    public List<Reception> findByBookId(@Param("bookId") int bookId);
}
