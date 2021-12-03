package com.example.achordandroidapp.ui.name;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.achordandroidapp.NewSongViewModel;
import com.example.achordandroidapp.R;
import com.example.achordandroidapp.Sheet;


//The factory methods can be deleted. I have not done it because in the future they may be handy
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NameFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NameFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //One common viewmodel for all of the fragments in this activity
    private NewSongViewModel viewModel;


    public NameFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NameFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NameFragment newInstance(String param1, String param2) {
        NameFragment fragment = new NameFragment();
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
        View view = inflater.inflate(R.layout.name_fragment, container, false);


        //One common viewmodel for all of the fragments in this activity
        viewModel = new ViewModelProvider(requireActivity()).get(NewSongViewModel.class);


        //Setting up the default data
        viewModel.setTitle("Name");
        viewModel.setAuthor("Author");
        viewModel.setKey("C");
        viewModel.setTimeSignature("4/4");



        viewModel.getSheetMut().observe(getViewLifecycleOwner(), new Observer<Sheet>() {
            @Override
            public void onChanged(Sheet sheet) {
                //this fragment doesn't have anything to display
            }
        });


        //I tried to use a button to move to the next fragment but using the navbar element I didn't need it anymore
//        buttonNextName = view.findViewById(R.id.nextButtonName);
//        buttonNextName.setOnClickListener(v -> {
//                    if (!editTextSongName.equals("")) {
//
//                    } else {
//                        Toast.makeText(getActivity(), "Please enter the Title", Toast.LENGTH_SHORT).show();
//                    }
//                }
//        );

        //Dummy test data
        //Sheet sheet = new Sheet("TITLE","AUTHOR","C","44",100 );


        EditText editTextSongName = view.findViewById(R.id.editTextSongName);
        editTextSongName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                //after the text has changed, the data is updated
                viewModel.setTitle(editable.toString());

            }
        });


        //I tried to pass the data with bundles but I realised, it is better to use a viewModel instead
//        Bundle bundle = new Bundle();
//        bundle.putParcelable("sheetObject", sheet);
//        setArguments(savedInstanceState);
        //getParentFragmentManager().beginTransaction().replace(R.id.authorFragment, this).commit();


        return view;
    }


}