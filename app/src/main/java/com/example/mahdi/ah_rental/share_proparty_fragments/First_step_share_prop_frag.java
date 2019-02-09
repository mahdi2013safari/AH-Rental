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
public class First_step_share_prop_frag extends Fragment {

    share_fragments_data fragments_data;
    Bundle bundle;
    View rootView;


    public First_step_share_prop_frag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView =  inflater.inflate(R.layout.fragment_first_step_fragment, container, false);
        bundle = new Bundle();
        bundle.putInt("step",1);
        fragments_data = (share_fragments_data) getActivity();
        final EditText select_type = rootView.findViewById(R.id.txt_share_select_type);
        final EditText for_rent = rootView.findViewById(R.id.txt_share_for_rent);
        final EditText price = rootView.findViewById(R.id.txt_share_prices);
        Button btn_next_step_one = rootView.findViewById(R.id.btn_share_next_one);


        btn_next_step_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString("select_type",select_type.getText().toString());
                bundle.putString("for_rent",for_rent.getText().toString());
                bundle.putString("price",price.getText().toString());
                fragments_data.oneDoneClick(bundle);
            }
        });




        return rootView;
    }






}
