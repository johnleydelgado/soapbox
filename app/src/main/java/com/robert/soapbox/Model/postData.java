package com.robert.soapbox.Model;

public class postData {
    String content;
    String image;
    String title;
    String status;
    String date;
    String size;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    String color;
    int imageArray;


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public postData(String content, String image, String title, String status, String date, String size, String color) {
        this.content = content;
        this.image=image;
        this.title = title;
        this.status=status;
        this.date=date;
        this.size=size;
        this.color=color;

    }



}
