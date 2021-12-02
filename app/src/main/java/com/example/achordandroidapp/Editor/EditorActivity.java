package com.example.achordandroidapp.Editor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.achordandroidapp.MainActivity;
import com.example.achordandroidapp.MainActivityViewModel;
import com.example.achordandroidapp.NewSongActivity;
import com.example.achordandroidapp.NewSongViewModel;
import com.example.achordandroidapp.R;
import com.example.achordandroidapp.Sheet;

import java.util.ArrayList;
import java.util.List;

public class EditorActivity extends AppCompatActivity implements BarAdapter.OnListItemClickListener {

    RecyclerView recyclerViewEd;
    NewSongViewModel newSongViewModel;
    EditorViewModel editorViewModel;
    Button addButton, backButton, saveButton;
    EditText addEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);
        recyclerViewEd = findViewById(R.id.recyclerViewEditor);
        recyclerViewEd.setLayoutManager(new LinearLayoutManager(this));

        recyclerViewEd.hasFixedSize();

        newSongViewModel = new ViewModelProvider(this).get(NewSongViewModel.class);
        newSongViewModel.getSheetMut().observe(this, new Observer<Sheet>() {
            @Override
            public void onChanged(Sheet sheet) {
                //adding the bars as a list to the sheet object
            }
        });


        List<Bar> bars = new ArrayList<>();

        bars.add(new Bar("CMajor"));
        bars.add(new Bar("DMajor"));
        bars.add(new Bar("EMajor"));

        addButton = findViewById(R.id.buttonEdAddBar);
        addEditText = findViewById(R.id.editTextEditorAdd);
        addButton.setOnClickListener(v -> {
            bars.add(new Bar(addEditText.getText().toString()));
        });

        backButton = findViewById(R.id.buttonEditorBack);
        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, NewSongActivity.class);
            startActivity(intent);
        });


        saveButton = findViewById(R.id.buttonEditorSave);
        saveButton.setOnClickListener(v -> {
            //Saving the sheet in the local storage
            System.out.println(newSongViewModel.getSheetMut().getValue());
            if(newSongViewModel.getSheetMut().getValue() != null){
                editorViewModel.insert(newSongViewModel.getSheetMut().getValue());
            }

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });




        BarAdapter barAdapter = new BarAdapter(bars, this);
        recyclerViewEd.setAdapter(barAdapter);
    }

    @Override
    public void onClick(int position) {
        Toast.makeText(this, "Position: " + position, Toast.LENGTH_SHORT).show();
    }
}