package com.note.schema;

/**
 * Created by Administrator on 2019/4/16.
 */
public class Book {
    private int id;
    private int btype;
    private String url;
    private String book;
    private String uname;

    public int getBtype() {
        return btype;
    }

    public void setBtype(int btype) {
        this.btype = btype;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    private String checkkey;


    public String getCheckkey() {
        return checkkey;
    }

    public void setCheckkey(String checkkey) {
        this.checkkey = checkkey;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
