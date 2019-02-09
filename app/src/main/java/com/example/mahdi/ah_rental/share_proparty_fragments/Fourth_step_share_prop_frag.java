package com.example.mahdi.ah_rental.share_proparty_fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.mahdi.ah_rental.HomeActivity;
import com.example.mahdi.ah_rental.R;
import com.example.mahdi.ah_rental.interfaces.share_fragments_data;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fourth_step_share_prop_frag extends Fragment {

    share_fragments_data fragments_data;
    View rootView;
    Bundle bundle;

    public Fourth_step_share_prop_frag() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_fourth_step_share_prop_frag, container, false);
        fragments_data = (share_fragments_data) getActivity();
        bundle = new Bundle();
        bundle.putInt("step", 4);
        final EditText address = rootView.findViewById(R.id.txt_share_address);
        final EditText district = rootView.findViewById(R.id.txt_share_district);
        final EditText description = rootView.findViewById(R.id.txt_share_description);
        Button btn_finish = rootView.findViewById(R.id.btn_share_next_finish);
        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString("address", address.getText().toString());
                bundle.putString("district", district.getText().toString());
                bundle.putString("description", description.getText().toString());
                fragments_data.oneDoneClick(bundle);
            }
        });
        return rootView;
    }


}
