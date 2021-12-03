package com.example.achordandroidapp.ui.author;

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
 * Use the {@link AuthorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AuthorFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    //Sheet sheet = new Sheet("","","","",0);
    Sheet  tempSheet = new Sheet("","","","",0);
    private TextView nameTextView;

    //One common viewmodel for all of the fragments in this activity
    private NewSongViewModel viewModel;


    public AuthorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AuthorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AuthorFragment newInstance(String param1, String param2) {
        AuthorFragment fragment = new AuthorFragment();
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

    // ON CREATE VIEW ////////////////////////////////////////////
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.author_fragment, container, false);


        TextView textViewName = view.findViewById(R.id.textViewName);

        //One common viewmodel for all of the fragments in this activity
        viewModel = new ViewModelProvider(requireActivity()).get(NewSongViewModel.class);


        //sending the value to the proper textView
        viewModel.getSheetMut().observe(getViewLifecycleOwner(), new Observer<Sheet>() {
            @Override
            public void onChanged(Sheet sheet) {
                textViewName.setText(sheet.getTitle());
            }
        });

        //after the text has changed, the data is updated
        EditText editTextSongAuthor = view.findViewById(R.id.editTextSongAuthor);
        editTextSongAuthor.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                //after the text has changed, the data is updated
                viewModel.setAuthor(editable.toString());
            }
                                                }
        );



        //          Bundle attempt
//        Bundle bundle = getArguments();
//        if (bundle != null) {
//            Sheet receivedSheet = bundle.getParcelable("sheetObject"); // Key
//            //System.out.println(receivedSheet.getTitle());
//            //Log.d("CUSTOMINFO", receivedSheet.getTitle());
//           // textViewName.setText(receivedSheet.getTitle());
//        }

        return view ;
    }
}