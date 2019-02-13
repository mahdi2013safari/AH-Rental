package com.example.mahdi.ah_rental.Home;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mahdi.ah_rental.MapsSearch;
import com.example.mahdi.ah_rental.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Search_fragment extends Fragment {


    View rootView;
    public Search_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_search_fragment, container, false);
        Button btn_search = rootView.findViewById(R.id.btn_search);
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openGoogleMap = new Intent(getActivity(), MapsSearch.class);
                startActivity(openGoogleMap);
            }
        });
        return rootView;
    }

}
