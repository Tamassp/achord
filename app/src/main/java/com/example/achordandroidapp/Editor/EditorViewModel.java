package com.example.achordandroidapp.Editor;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.example.achordandroidapp.Repository;
import com.example.achordandroidapp.Sheet;

public class EditorViewModel extends AndroidViewModel {

        private Repository sheetRepo;
        public EditorViewModel(@NonNull Application application) {
            super(application);
            sheetRepo = Repository.getInstance(application);
        }

        public void insert(Sheet sheet){
            sheetRepo.insert(sheet);
        }

}
