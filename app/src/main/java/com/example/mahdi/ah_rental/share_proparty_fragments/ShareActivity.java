package com.example.mahdi.ah_rental.share_proparty_fragments;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.mahdi.ah_rental.HomeActivity;
import com.example.mahdi.ah_rental.R;
import com.example.mahdi.ah_rental.interfaces.share_fragments_data;

public class ShareActivity extends AppCompatActivity implements share_fragments_data {


    First_step_share_prop_frag first_step;
    Second_step_share_prop_frag second_step;
    Third_step_share_prop_frag third_step;
    Fourth_step_share_prop_frag fourth_step;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        first_step = new First_step_share_prop_frag();
        second_step = new Second_step_share_prop_frag();
        third_step = new Third_step_share_prop_frag();
        fourth_step = new Fourth_step_share_prop_frag();
        changeFragment(first_step);
    }


    public void changeFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_content_share,fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void oneDoneClick(Bundle bundle) {
        int step = bundle.getInt("step");
        switch(step){
            case 1 :
                Toast.makeText(this, "this is step one ", Toast.LENGTH_SHORT).show();
                changeFragment(second_step);
                break;
            case 2 :
                Toast.makeText(this, "this is step two", Toast.LENGTH_SHORT).show();
                changeFragment(third_step);
                break;
            case 3 :
                Toast.makeText(this, "this is step third", Toast.LENGTH_SHORT).show();
                changeFragment(fourth_step);
                break;
            case 4 :
                Toast.makeText(this, "this is final step", Toast.LENGTH_SHORT).show();
                Intent intent_to_home = new Intent(this, HomeActivity.class);
                startActivity(intent_to_home);
                break;
        }
    }
}
