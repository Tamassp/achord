package com.example.achordandroidapp;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

public class SongListViewModel extends AndroidViewModel {
    private Repository repository;

    public SongListViewModel(Application app){
        super(app);
        repository = Repository.getInstance(app);
    }
}
