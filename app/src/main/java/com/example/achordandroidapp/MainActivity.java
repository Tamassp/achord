package com.example.achordandroidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.achordandroidapp.Library.LibraryActivity;

public class MainActivity extends AppCompatActivity {

    MainActivityViewModel mainViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //textView = findViewById(R.id.textView2);
        mainViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        //Test method -- can be deleted later
        mainViewModel.getMessage().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String message) {
                //textView.setText(message);
            }
        });


        //Button for navigating to the newSongActivity
        Button buttonNewSong = findViewById(R.id.buttonNewSong);
        buttonNewSong.setOnClickListener(v -> {
            Intent intentNewSong = new Intent(this, NewSongActivity.class);
            startActivity(intentNewSong);
        });


        //Button for navigating to the LibraryActivity
        Button buttonLibrary = findViewById(R.id.buttonLibrary);
        buttonLibrary.setOnClickListener(v->{
            Intent intentLibrary = new Intent(this, LibraryActivity.class);
            startActivity(intentLibrary);
        });
    }


    //Test Method -- can be deleted at releasing process
//    public void retrieveDataFromInternet(View view){
//        mainViewModel.retrieveData();
//    }

}