package com.example.achordandroidapp.Editor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.achordandroidapp.NewSongViewModel;
import com.example.achordandroidapp.R;

import java.util.ArrayList;
import java.util.List;

public class EditorActivity extends AppCompatActivity implements BarAdapter.OnListItemClickListener {

    RecyclerView recyclerViewEd;
    NewSongViewModel newSongViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);
        recyclerViewEd = findViewById(R.id.recyclerViewEditor);
        recyclerViewEd.setLayoutManager(new LinearLayoutManager(this));

        recyclerViewEd.hasFixedSize();

        newSongViewModel = new ViewModelProvider(this).get(NewSongViewModel.class);
        List<Bar> bars = new ArrayList<>();

        bars.add(new Bar("CMajor"));
        bars.add(new Bar("DMajor"));
        bars.add(new Bar("EMajor"));

        BarAdapter barAdapter = new BarAdapter(bars, this);
        recyclerViewEd.setAdapter(barAdapter);
    }

    @Override
    public void onClick(int position) {
        Toast.makeText(this, "Position: " + position, Toast.LENGTH_SHORT).show();
    }
}