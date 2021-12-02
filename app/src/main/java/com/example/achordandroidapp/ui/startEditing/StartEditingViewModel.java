package com.example.achordandroidapp.ui.startEditing;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.example.achordandroidapp.Repository;

public class StartEditingViewModel extends AndroidViewModel {
    private Repository sheetRepo;
    public StartEditingViewModel(@NonNull Application application) {
        super(application);
        sheetRepo = Repository.getInstance(application);
    }


    // TODO: Implement the ViewModel
}