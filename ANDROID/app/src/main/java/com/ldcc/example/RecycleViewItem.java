package com.ldcc.example;

import android.graphics.drawable.Drawable;

public class RecycleViewItem {
    private int image;
    private String title;
    private String date;

    boolean selected;



    public RecycleViewItem(int image, String title, String date, Boolean selected) {
        this.image = image;
        this.title = title;
        this.date = date;
        this.selected = selected;
    }

    public RecycleViewItem() {

    }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDate() {
            return this.date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public Boolean getSelectedTF() {
            return this.selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        public int getImage() {
            return this.image;
        }

        public void setImage(int image) {
            this.image = image;
        }
}
