package com.note.schema;

/**
 * Created by Administrator on 2019/4/16.
 */
public class Reception {
    private int id;
    private int bookId;

    private String email;
    public int getBookId() {
        return bookId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }


}
