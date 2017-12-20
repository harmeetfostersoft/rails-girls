package com.example.fostersoftsol01.luvoffers.ClintionCards;

/**
 * Created by fostersoftsol01 on 3/5/17.
 */

public class Album {

    private String name;
    private int numOfCards;
    private int thumbnail;

    public Album() {
    }

    public Album(String name, int numOfCards, int thumbnail) {
        this.name = name;
        this.numOfCards = numOfCards;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfCards() {
        return numOfCards;
    }

    public void setNumOfCards(int numOfCards) {
        this.numOfCards = numOfCards;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

}
