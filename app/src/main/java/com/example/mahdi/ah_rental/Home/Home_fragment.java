package com.example.mahdi.ah_rental.Home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mahdi.ah_rental.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Home_fragment extends Fragment {

    RecyclerView recyclerView;
    HomeAdapter homeAdapter;
    List<Home> homeList;

    public Home_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        homeList = new ArrayList<>();
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home_fragment, container, false);
        recyclerView = view.findViewById(R.id.home_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        homeList.add(new Home(1,0,"2232 afg","Home","4 bathroom","4 people","Kabul Afghanistan","2018/5/9"));
        homeList.add(new Home(2,0,"2232 afg","Home","4 bathroom","4 people","Kabul Afghanistan","2018/5/9"));
        homeList.add(new Home(3,0,"2232 afg","Home","4 bathroom","4 people","Kabul Afghanistan","2018/5/9"));
        homeAdapter = new HomeAdapter(getActivity(),homeList);
        recyclerView.setAdapter(homeAdapter);
        return view;
    }

}
