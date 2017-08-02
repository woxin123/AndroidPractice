package com.example.listviewtest;

/**
 * Created by 孟晨 on 2017/7/24.
 */

public class Fruit {
    private String name;
    private int imagedId;

    public Fruit(String name, int imagedId) {
        this.name = name;
        this.imagedId = imagedId;
    }
    public String getName() {
        return name;
    }

    public int getImagedId () {
        return imagedId;
    }
}
