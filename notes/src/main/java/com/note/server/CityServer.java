package com.note.server;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2019/4/16.
 */
public interface CityServer {
    Long addNote(String name);
}
