package com.example.lab2_bai_5;

public enum Thumbnail {
    ThumbnailL1("Thumbnail 1", R.drawable.first_thumbnail),
    ThumbnailL2("Thumbnail 2", R.drawable.second_thumbnail),
    ThumbnailL3("Thumbnail 3", R.drawable.third_thumbnail),
    ThumbnailL4("Thumbnail 4", R.drawable.fourth_thumbnail);

    private String name;
    private int img;

    Thumbnail(String name, int img) {
        this.name = name;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public int getImg() {
        return img;
    }
}