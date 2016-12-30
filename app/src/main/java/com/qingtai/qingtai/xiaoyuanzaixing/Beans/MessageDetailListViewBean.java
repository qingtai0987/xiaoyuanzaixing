package com.qingtai.qingtai.xiaoyuanzaixing.Beans;

import android.graphics.Bitmap;

/**
 * Created by Administrator on 2016/12/21.
 */
public class MessageDetailListViewBean {

    private int type;
    private String text;
    private Bitmap icon;
    public MessageDetailListViewBean(){}

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Bitmap getIcon() {
        return icon;
    }

    public void setIcon(Bitmap icon) {
        this.icon = icon;
    }
}
