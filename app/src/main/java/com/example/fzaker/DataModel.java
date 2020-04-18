package com.example.fzaker;

public class DataModel {

    String Title,Content,Date;
    int Photo;

    public DataModel() {
    }


    public DataModel(String title, String content, String date, int Photo) {
        Title = title;
        Content = content;
        Date = date;
        this.Photo = Photo;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setContent(String content) {
        Content = content;
    }

    public void setDate(String date) {
        Date = date;
    }

    public void setPhoto(int Photo) {
        this.Photo = Photo;
    }

    public String getTitle() {
        return Title;
    }

    public String getContent() {
        return Content;
    }

    public String getDate() {
        return Date;
    }

    public int getPhoto() {
        return Photo;
    }
}
