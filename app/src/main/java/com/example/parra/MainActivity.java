package com.example.parra;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

    }
        private  BottomNavigationView.OnNavigationItemSelectedListener navListener =

                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                            Fragment selectedFragment = null;

                            switch (menuItem.getItemId()) {
                                case R.id.nav_home:
                                    selectedFragment = new HomeFragment();
                                    break;
                                case R.id.nav_activity:
                                    selectedFragment = new ActivityFragment();
                                    break;
                                case R.id.nav_Account:
                                    selectedFragment = new AccountFragment();
                                    break;
                            }
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                            return true;
                        }

                };

}
