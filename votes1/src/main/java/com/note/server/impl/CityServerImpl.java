package com.note.server.impl;

import com.note.mapper.CityMapper;
import com.note.server.CityServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2019/4/16.
 */
//@Service
@Component
@Transactional
public class CityServerImpl implements CityServer{
    @Autowired
    private CityMapper cityMapper;
    public Long addNote(String name){
        return cityMapper.addNote(name);
    }
}
