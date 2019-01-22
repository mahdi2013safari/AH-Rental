package com.example.mahdi.ah_rental;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
//                    mTextMessage.setText(R.string.title_home);
                    Toast.makeText(HomeActivity.this, "Click Home", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.navigation_share:
//                    mTextMessage.setText("shareproparty");
                    Toast.makeText(HomeActivity.this, "Your clicking on share button", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.navigation_notifications:
//                    mTextMessage.setText(R.string.title_notifications);
                    Toast.makeText(HomeActivity.this, "Nofitcations", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.navigation_search:
//                    mTextMessage.setText("Search");
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
    }

}
