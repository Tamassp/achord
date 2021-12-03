package com.example.achordandroidapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivityViewModel extends ViewModel {

    //TEST METHOD -- can be deleted at releasing process
    private MutableLiveData<String> message = new MutableLiveData<>();

    //TEST METHOD -- can be deleted at releasing process
    public LiveData<String> getMessage(){
        return message;
    }


    //TEST METHOD -- can be deleted at releasing process
//    public void retrieveData(){
//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//                message.postValue("HeloHelo");
//            }
//        },3000);
//    }
}
