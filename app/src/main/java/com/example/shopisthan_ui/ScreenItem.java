package com.example.shopisthan_ui;

public class ScreenItem {

    String Title, Description,Description2;
    int img;

    public ScreenItem(String title, String description,String description2, int img) {
        Title = title;
        Description = description;
        Description2 = description2;
        this.img = img;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setDescription2(String description2) {
        Description2 = description2;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }

    public String getDescription2() {
        return Description2;
    }

    public int getImg() {
        return img;
    }
}
