package com.devacademy.myapplication;

import java.util.Date;

/**
 * Created by radus on 12/7/2015.
 */
public class Weather {
    public int icon, emoticon, roadImg;
    public String title, pace, totalTime;
    public Date date;
    public Weather(){
        super();
    }

    public Weather(int icon, int emoticon, int roadImg, String title, Date date, String pace, String totalTime) {
        super();
        this.emoticon = emoticon;
        this.icon = icon;
        this.title = title;
        this.roadImg = roadImg;
        this.date = date;
        this.pace = pace;
        this.totalTime = totalTime;
    }

    public Date getDateTime() {
        return date;
    }
}
