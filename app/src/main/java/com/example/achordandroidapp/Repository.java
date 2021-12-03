package com.example.achordandroidapp;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository {
    private static Repository instance;
    private final SheetDao sheetDao;
    private final LiveData<List<Sheet>> allSheets;
    private final ExecutorService executorService;

    private Repository(Application application){
        SheetDatabase database = SheetDatabase.getInstance(application);
        sheetDao = database.getSheetDao();
        allSheets = sheetDao.getAllSheets();
        executorService = Executors.newFixedThreadPool(2);
    }

    public static synchronized Repository getInstance(Application application){
        if(instance == null){
            instance = new Repository(application);
        }
        return instance;
    }

    public LiveData<List<Sheet>> getAllSheets(){
        return allSheets;
    }



    public void insert(Sheet sheet){
        executorService.execute(() -> sheetDao.insert(sheet));
    }


    //Delete every sheet from the local database
    public void deleteAllSheets(){
        executorService.execute(sheetDao::deleteAllNotes);
    }
}
