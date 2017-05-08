package com.club_hayat.ThinkGreen.CATEGORIES;

/**
 * Created by Naoufal on 2/20/2017.
 */

public class Picture {

    private int picture;
    private String userName;
    private String time;
    private String videoId ;

    public Picture(int picture, String userName, String time, String videoId) {
        this.picture = picture;
        this.userName = userName;
        this.time = time;
        this.videoId = videoId;


    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }
}
