package com.example.mahdi.ah_rental.Home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mahdi.ah_rental.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Notification_fragment extends Fragment {


    public Notification_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notification_fragment, container, false);
    }

}
