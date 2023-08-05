package com.ldcc.example;

public class RecycleViewItem {
    private int image;
    private String title;
    private String date;



    public RecycleViewItem(int image, String title, String date) {
        this.image = image;
        this.title = title;
        this.date = date;
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

        public int getImage() {
            return this.image;
        }

        public void setImage(int image) {
            this.image = image;
        }
}
