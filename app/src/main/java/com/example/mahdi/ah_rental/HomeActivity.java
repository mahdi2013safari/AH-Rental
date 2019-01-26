package com.example.mahdi.ah_rental;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mahdi.ah_rental.Home.Home_fragment;
import com.example.mahdi.ah_rental.Home.Notification_fragment;
import com.example.mahdi.ah_rental.Home.Search_fragment;
import com.example.mahdi.ah_rental.share_proparty_fragments.First_step_share_prop_frag;

public class HomeActivity extends AppCompatActivity {

    private TextView mTextMessage;
    Home_fragment home_fragment;
    Notification_fragment notification_fragment;
    Search_fragment search_fragment;
    FloatingActionButton button_new_share;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Toast.makeText(HomeActivity.this, "Click Home", Toast.LENGTH_SHORT).show();
                    changeFragment(home_fragment);
                    return true;
                case R.id.navigation_notifications:
                    changeFragment(notification_fragment);
                    Toast.makeText(HomeActivity.this, "Nofitcations", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.navigation_search:
                    changeFragment(search_fragment);
                    Toast.makeText(HomeActivity.this, "Searching Proparty", Toast.LENGTH_SHORT).show();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        button_new_share = findViewById(R.id.floatingButtonNewShare);
        button_new_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                startActivity(i);
            }
        });

        home_fragment = new Home_fragment();
        notification_fragment = new Notification_fragment();
        search_fragment = new Search_fragment();
        changeFragment(home_fragment);
    }

    public void changeFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_content_home,fragment);
        fragmentTransaction.commit();
    }

}
