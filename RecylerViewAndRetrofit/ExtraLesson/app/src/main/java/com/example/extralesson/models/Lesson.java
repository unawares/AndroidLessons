package com.example.extralesson.models;

import java.util.Date;

public class Lesson {

    private String title;

    private String description;

    private Integer price;

    private Date date;

    public Lesson(String title, String description, Integer price, Date date) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
