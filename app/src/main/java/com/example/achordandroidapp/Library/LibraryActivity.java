package com.example.achordandroidapp.Library;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.achordandroidapp.MainActivity;
import com.example.achordandroidapp.NewSongActivity;
import com.example.achordandroidapp.R;
import com.example.achordandroidapp.Sheet;

import java.util.ArrayList;
import java.util.List;

public class LibraryActivity extends AppCompatActivity {
    RecyclerView recyclerViewLibrary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        recyclerViewLibrary = findViewById(R.id.recyclerViewLibrary);

        recyclerViewLibrary.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewLibrary.hasFixedSize();

        List<Sheet> sheetList = new ArrayList<>();

        sheetList.add(new Sheet("The best", "Tina Turner", "F", "4/4",120));
        sheetList.add(new Sheet("Proud Mary","Tina Turner", "Dm", "4/4",100 ));

        SheetAdapter sheetAdapter = new SheetAdapter(sheetList);
        recyclerViewLibrary.setAdapter(sheetAdapter);

        Button backButton = findViewById(R.id.buttonBackLibrary);
        backButton.setOnClickListener(v->{
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        Button buttonNewSheet = findViewById(R.id.buttonNewSheetLibrary);
        buttonNewSheet.setOnClickListener(v->{
            Intent intent = new Intent(this, NewSongActivity.class);
            startActivity(intent);
        });
    }
}