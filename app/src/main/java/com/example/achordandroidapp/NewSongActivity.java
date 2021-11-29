package com.example.achordandroidapp;

import android.content.ClipData;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.achordandroidapp.databinding.ActivityNewSongBinding;

public class NewSongActivity extends AppCompatActivity {

    private ActivityNewSongBinding binding;
    NewSongViewModel newSongViewModel;
    TextView createTitleTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNewSongBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nameFragment, R.id.authorFragment, R.id.keyFragment, R.id.signatureFragment, R.id.startEditingFragment)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_new_song);
        //We don't need this since we disabled the default action bar
        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        newSongViewModel = new ViewModelProvider(this).get(NewSongViewModel.class);


        //Observing the Title TextView in the activity


        //
        createTitleTextView = findViewById(R.id.textViewCreateTitle);
        createTitleTextView.setText("Name");




    }



}