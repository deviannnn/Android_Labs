package com.example.bai01;

public class Phone {
    private int picAvatar;
    private String name;
    private boolean isChecked;

    public Phone(int picAvatar, String name) {
        this.picAvatar = picAvatar;
        this.name = name;
        this.isChecked = false;
    }

    public Phone(int picAvatar, String name, boolean isChecked) {
        this.picAvatar = picAvatar;
        this.name = name;
        this.isChecked = isChecked;
    }

    public int getPicAvatar() {
        return picAvatar;
    }

    public void setPicAvatar(int picAvatar) {
        this.picAvatar = picAvatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}