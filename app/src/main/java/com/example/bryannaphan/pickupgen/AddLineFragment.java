package com.example.bryannaphan.pickupgen;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddLineFragment extends DialogFragment {

    public AddLineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_line, container, false);
        final SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);

        final EditText editText = (EditText) view.findViewById(R.id.editText);

        Button saveButton = (Button) view.findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // save preference stuff
                int count = sharedPref.getInt("count",0);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("custom" + count, editText.getText().toString());
                editor.apply();

                editor.putInt("count", count + 1);
                editor.apply();
                dismiss();

            }
        });


        return view;


    }

}
