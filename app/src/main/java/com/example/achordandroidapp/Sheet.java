package com.example.achordandroidapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "sheet_table")
public class Sheet {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String author;
    private String key;
    private String timeSignature;
    private int tempo;

    public Sheet(String title, String author, String key, String timeSignature, int tempo) {
        this.title = title;
        this.author = author;
        this.key = key;
        this.timeSignature = timeSignature;
        this.tempo = tempo;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTimeSignature() {
        return timeSignature;
    }

    public void setTimeSignature(String timeSignature) {
        this.timeSignature = timeSignature;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }
}
