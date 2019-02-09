package com.example.mahdi.ah_rental.share_proparty_fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.mahdi.ah_rental.R;
import com.example.mahdi.ah_rental.interfaces.share_fragments_data;

/**
 * A simple {@link Fragment} subclass.
 */
public class Third_step_share_prop_frag extends Fragment {


    View rootView;
    share_fragments_data fragments_data;
    Bundle bundle;
    public Third_step_share_prop_frag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_third_step_share_prop_frag, container, false);
        fragments_data = (share_fragments_data) getActivity();
        bundle = new Bundle();
        bundle.putInt("step",3);
        final EditText rooms = rootView.findViewById(R.id.txt_share_room);
        final EditText toilets = rootView.findViewById(R.id.txt_share_toilets);
        final EditText bathroom = rootView.findViewById(R.id.txt_share_bathroom);
        final EditText moreTag = rootView.findViewById(R.id.txt_share_moretage);
        Button btn_next = rootView.findViewById(R.id.btn_share_next_third);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString("rooms",rooms.getText().toString());
                bundle.putString("toilets",toilets.getText().toString());
                bundle.putString("bathroom",bathroom.getText().toString());
                bundle.putString("moreTag",moreTag.getText().toString());
                fragments_data.oneDoneClick(bundle);
            }
        });






        return rootView;
    }

}
