package com.example.achordandroidapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface SheetDao {
    @Insert
    void insert(Sheet sheet);

    @Update
    void update(Sheet sheet);

    @Delete
    void delete(Sheet sheet);

    @Query("DELETE FROM sheet_table")
    void deleteAllNotes();

    @Query("SELECT * FROM sheet_table")
    LiveData<List<Sheet>> getAllSheets();
    //future order by author maybe
}
