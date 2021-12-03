package com.example.achordandroidapp.ui.key;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link KeyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class KeyFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    //One common viewmodel for all of the fragments in this activity
    private NewSongViewModel viewModel;

    public KeyFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment KeyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static KeyFragment newInstance(String param1, String param2) {
        KeyFragment fragment = new KeyFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.key_fragment, container, false);

        //One common viewmodel for all of the fragments in this activity
        viewModel = new ViewModelProvider(requireActivity()).get(NewSongViewModel.class);


        TextView textViewKeyName = view.findViewById(R.id.textViewKeyName);
        TextView textViewKeyAuthor = view.findViewById(R.id.textViewKeyAuthor);
        viewModel.getSheetMut().observe(getViewLifecycleOwner(), new Observer<Sheet>() {
            @Override
            public void onChanged(Sheet sheet) {
                textViewKeyName.setText(sheet.getTitle());
                textViewKeyAuthor.setText(sheet.getAuthor());
            }
        });

        //after the text has changed, the data is updated
        EditText editTextSongKey = view.findViewById(R.id.editTextSongKey);
        editTextSongKey.addTextChangedListener(new TextWatcher() {
                                                      @Override
                                                      public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                      }

                                                      @Override
                                                      public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                      }

                                                      @Override
                                                      public void afterTextChanged(Editable editable) {
                                                          //after the text has changed, the data is updated
                                                          viewModel.setKey(editable.toString());
                                                      }
                                                  }
        );






        // Inflate the layout for this fragment
        return view;
    }
}