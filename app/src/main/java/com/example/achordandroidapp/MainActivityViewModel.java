package com.example.achordandroidapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<String> message = new MutableLiveData<>();

    public LiveData<String> getMessage(){
        return message;
    }

    public void retrieveData(){
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                message.postValue("HeloHelo");
            }
        },3000);
    }
}
