package com.example.achordandroidapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NewSongViewModel extends ViewModel {

    private MutableLiveData<Sheet> sheet = new MutableLiveData<Sheet>();

    public LiveData<Sheet> getSheet() {
        return sheet;
    }

    public void updateSheet (Sheet sheet){
        this.sheet.setValue(sheet);
    }

    public String getTitle(){
        return  this.getTitle();
    }




}
