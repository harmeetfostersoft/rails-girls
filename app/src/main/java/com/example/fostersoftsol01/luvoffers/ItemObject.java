package com.example.fostersoftsol01.luvoffers;

import java.security.PublicKey;

/**
 * Created by fostersoftsol01 on 3/5/17.
 */

public class ItemObject {

    private String name,subValue, subValueText;
    private int photo;

    public ItemObject(String name,String subValue,String subValueText, int photo) {
        this.name = name;
        this.subValue = subValue;
        this.subValueText = subValueText;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubValue() {
        return subValue;
    }

    public void setSubValue(String subValue) {
        this.subValue = subValue;
    }

    public String getSubValueText() {
        return subValueText;
    }

    public void setSubValueText(String subValueText) {
        this.subValueText = subValueText;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}