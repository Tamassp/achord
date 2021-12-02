package com.example.achordandroidapp.Library;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.achordandroidapp.Repository;
import com.example.achordandroidapp.Sheet;

import java.util.ArrayList;
import java.util.List;

public class LibraryViewModel extends AndroidViewModel {
    Repository sheetRepo;
    public LibraryViewModel(@NonNull Application application) {
        super(application);
        sheetRepo = Repository.getInstance(application);
    }

    public List<Sheet> getSheetList(){
        return sheetRepo.getAllSheets().getValue();
    }
}
