package com.example.mahdi.ah_rental.share_proparty_fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mahdi.ah_rental.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class First_step_share_prop_frag extends Fragment {

    View view;

    public First_step_share_prop_frag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_first_step_fragment, container, false);

        return view;
    }



}
