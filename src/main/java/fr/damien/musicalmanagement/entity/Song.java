package fr.damien.musicalmanagement.entity;

import java.sql.Time;
import java.util.Date;

public class Song {

    private int id;
    private String title;
    private Date date;
    private Time duration;

    public Song() {
    }

    public Song(String title, Date date, Time duration) {
        this.title = title;
        this.date = date;
        this.duration = duration;
    }

    public Song(int id, String title, Date date, Time duration) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }
}
