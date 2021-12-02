package com.example.achordandroidapp;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.versionedparcelable.VersionedParcelize;

import com.example.achordandroidapp.Editor.Bar;

import java.util.List;


@Entity (tableName = "sheet_table")
public class Sheet implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String author;
    private String key;
    private String timeSignature;
    private int tempo;
    //private List<Bar> barList;

    public Sheet(){

    }

    public Sheet(String title, String author, String key, String timeSignature, int tempo) {
        this.title = title;
        this.author = author;
        this.key = key;
        this.timeSignature = timeSignature;
        this.tempo = tempo;
    }

    protected Sheet(Parcel in) {
        id = in.readInt();
        title = in.readString();
        author = in.readString();
        key = in.readString();
        timeSignature = in.readString();
        tempo = in.readInt();
    }

    public static final Creator<Sheet> CREATOR = new Creator<Sheet>() {
        @Override
        public Sheet createFromParcel(Parcel in) {
            return new Sheet(in);
        }

        @Override
        public Sheet[] newArray(int size) {
            return new Sheet[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(title);
        parcel.writeString(author);
        parcel.writeString(key);
        parcel.writeString(timeSignature);
        parcel.writeInt(tempo);
    }
//
//    public List<Bar> getBarList() {
//        return barList;
//    }
//
//    public void setBarList(List<Bar> barList) {
//        this.barList = barList;
//    }
//
//    public void addBarToList(Bar bar){
//        barList.add(bar);
//    }
}
