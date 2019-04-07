package com.example.mahdi.ah_rental.Home;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.mahdi.ah_rental.MapsSearch;
import com.example.mahdi.ah_rental.R;
import com.example.mahdi.ah_rental.location.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class Search_fragment extends Fragment {


    int chooseLocation = 0 ;
    Double latitude,longitude;
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
        CheckBox close_to_me = rootView.findViewById(R.id.checkbox_close_to_me);
        CheckBox any_location = rootView.findViewById(R.id.checkbox_any_location);
        CheckBox location_name = rootView.findViewById(R.id.checkbox_location_name);



        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openGoogleMap = new Intent(getActivity(), MapsSearch.class);
                startActivity(openGoogleMap);
            }
        });
        close_to_me.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(getActivity(), "check box close to me location", Toast.LENGTH_SHORT).show();
                }
            }
        });
        any_location.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(getActivity(), "checkbox any location", Toast.LENGTH_SHORT).show();
                }
            }
        });
        location_name.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(getActivity(), "check box location name", Toast.LENGTH_SHORT).show();
                }
            }
        });


        return rootView;
    }

    private void getLocation() {
        if (chooseLocation == 0) {
            //TODO: get location by GPS
            GPSTracker myGps = new GPSTracker(getActivity());
            myGps.getLocation();
            if (myGps.canGetLocation) {
                latitude = myGps.getLatitude();
                longitude = myGps.getLongitude();
            } else{
                myGps.showSettingsAlert();
            }
        } else {
            //TODO: get location by map
        }
    }// end of method getLocation()

}
