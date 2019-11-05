package com.note.schema;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/4/16.
 */
public class City implements Serializable{
    private static final long serialVersionUID = -134L;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
