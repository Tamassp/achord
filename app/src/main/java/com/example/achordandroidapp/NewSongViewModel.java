package com.example.achordandroidapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NewSongViewModel extends ViewModel {

    private MutableLiveData<String> title = new MutableLiveData<>();

    public LiveData<String> getTitle() {
        return title;
    }


}
