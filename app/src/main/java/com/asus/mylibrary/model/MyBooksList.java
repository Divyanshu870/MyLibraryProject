package com.asus.mylibrary.model;

public class MyBooksList {
    int thumbnail;
    String title;

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MyBooksList(int thumbnail, String title) {
        this.thumbnail = thumbnail;
        this.title = title;
    }
}
