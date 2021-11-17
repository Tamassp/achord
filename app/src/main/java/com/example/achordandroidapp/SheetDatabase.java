package com.example.achordandroidapp;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Sheet.class}, version = 1)
public abstract class SheetDatabase extends RoomDatabase {
    private static SheetDatabase instance;
    public abstract SheetDao getSheetDao();

    public static synchronized SheetDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    SheetDatabase.class, "sheet-database").fallbackToDestructiveMigration().build();
        }
        return instance;
    }
}
