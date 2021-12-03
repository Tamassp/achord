package com.example.achordandroidapp.ui.signature;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.achordandroidapp.NewSongViewModel;
import com.example.achordandroidapp.R;
import com.example.achordandroidapp.Sheet;

public class SignatureFragment extends Fragment {


    //One common viewmodel for all of the fragments in this activity
    private NewSongViewModel viewModel;

    public static SignatureFragment newInstance() {
        return new SignatureFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.signature_fragment, container, false);

        //One common viewmodel for all of the fragments in this activity
        viewModel =  new ViewModelProvider(requireActivity()).get(NewSongViewModel.class);


        TextView textViewSigName = view.findViewById(R.id.textViewSigName);
        TextView textViewSigAuthor = view.findViewById(R.id.textViewSigAuthor);
        TextView textViewSigKey = view.findViewById(R.id.textViewSigKey);
        viewModel.getSheetMut().observe(getViewLifecycleOwner(), new Observer<Sheet>() {
            @Override
            public void onChanged(Sheet sheet) {
                textViewSigName.setText(sheet.getTitle());
                textViewSigAuthor.setText(sheet.getAuthor());
                textViewSigKey.setText(sheet.getKey());
            }
        });


        //after the text has changed, the data is updated

        EditText editTextSongSignature = view.findViewById(R.id.editTextSongSignature);
        editTextSongSignature.addTextChangedListener(new TextWatcher() {
                                                   @Override
                                                   public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                   }

                                                   @Override
                                                   public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                   }

                                                   @Override
                                                   public void afterTextChanged(Editable editable) {
                                                       //after the text has changed, the data is updated
                                                       viewModel.setTimeSignature(editable.toString());
                                                   }
                                               }
        );

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //viewModel =  new ViewModelProvider(requireActivity()).get(NewSongViewModel.class);
        // TODO: Use the ViewModel
    }

}