package com.example.achordandroidapp.ui.startEditing;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.achordandroidapp.Editor.EditorActivity;
import com.example.achordandroidapp.NewSongViewModel;
import com.example.achordandroidapp.R;
import com.example.achordandroidapp.Sheet;

public class StartEditingFragment extends Fragment {

    //private StartEditingViewModel mViewModel;

    private NewSongViewModel viewModel;
    private StartEditingViewModel editingViewModel;
    private Button buttonStartEditing;
    public static StartEditingFragment newInstance() {
        return new StartEditingFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.start_editing_fragment, container, false);

        viewModel = new ViewModelProvider(requireActivity()).get(NewSongViewModel.class);


        TextView textViewSEName = view.findViewById(R.id.textViewSEName);
        TextView textViewSEAuthor = view.findViewById(R.id.textViewSEAuthor);
        TextView textViewSEKey = view.findViewById(R.id.textViewSEKey);
        TextView textViewSESignature = view.findViewById(R.id.textViewSESignature);
        viewModel.getSheetMut().observe(getViewLifecycleOwner(), new Observer<Sheet>() {
            @Override
            public void onChanged(Sheet sheet) {
                textViewSEName.setText(sheet.getTitle());
                textViewSEAuthor.setText(sheet.getAuthor());
                textViewSEKey.setText(sheet.getKey());
                textViewSESignature.setText(sheet.getTimeSignature());
            }
        });


        buttonStartEditing = view.findViewById(R.id.buttonStartEditing);
        buttonStartEditing.setOnClickListener(v -> {
            //The name and author have to be changed
            if(viewModel.getSheetMut().getValue().getTitle().equals("Name") ||
                    viewModel.getSheetMut().getValue().getAuthor().equals("Author") ){
                Toast.makeText(getContext(), "Change the name or author", Toast.LENGTH_SHORT).show();
            }
            else {
                Intent intent = new Intent(getActivity(), EditorActivity.class);
                startActivity(intent);
            }
                });

        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // TODO: Use the ViewModel
    }

}