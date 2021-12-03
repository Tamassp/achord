package com.example.achordandroidapp.Library;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.achordandroidapp.MainActivity;
import com.example.achordandroidapp.NewSongActivity;
import com.example.achordandroidapp.NewSongViewModel;
import com.example.achordandroidapp.R;
import com.example.achordandroidapp.Sheet;

import java.util.ArrayList;
import java.util.List;

public class LibraryActivity extends AppCompatActivity implements SheetAdapter.OnLibraryListCLickListener {
    RecyclerView recyclerViewLibrary;
    LibraryViewModel libraryViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        libraryViewModel= new ViewModelProvider(this).get(LibraryViewModel.class);

        recyclerViewLibrary = findViewById(R.id.recyclerViewLibrary);

        recyclerViewLibrary.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewLibrary.hasFixedSize();

        List<Sheet> sheetList = new ArrayList<>();

        sheetList.add(new Sheet("The Best", "Tina Turner", "F", "4/4",120));
        sheetList.add(new Sheet("Proud Mary","Tina Turner", "Dm", "4/4",100 ));
        sheetList.add(new Sheet("Let Me Entertain You","Robbie Williams", "F", "4/4",100 ));
        sheetList.add(new Sheet("Take Five","Dave Brubeck", "Ebm", "5/4",96 ));
        sheetList.add(new Sheet("Money Money Money","ABBA", "Am", "4/4",100 ));
        sheetList.add(new Sheet("Imagine","John Lennon", "C", "4/4",78 ));

        //sheetList = libraryViewModel.getSheetList();


        SheetAdapter sheetAdapter = new SheetAdapter(sheetList, this);
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

    //Recycler view click on element
    @Override
    public void onListItemClick(int position) {
        Toast.makeText(this, "Position: " + position, Toast.LENGTH_SHORT).show();
    }
}