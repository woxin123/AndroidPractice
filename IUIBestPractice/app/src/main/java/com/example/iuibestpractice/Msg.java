package com.example.iuibestpractice;

/**
 * Created by 孟晨 on 2017/7/26.
 */

public class Msg {
    public static final int TYPE_RECEIVED = 0;
    public static final int TYPE_SEND = 1;
    private String content;
    private int type;

    public Msg(String context, int type) {
        this.content = context;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public int getType() {
        return type;
    }
}
