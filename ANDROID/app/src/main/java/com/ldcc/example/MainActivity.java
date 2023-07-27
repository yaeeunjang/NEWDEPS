package com.ldcc.example;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class MainActivity extends AppCompatActivity {

    BottomNavigationView bnv;
    FrameLayout fl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnv = findViewById(R.id.menu_bottom_navigation);
        fl = findViewById(R.id.menu_frame_layout);

        bnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_share:
                        changeFragment(new ShareFragment());
                        break;

                    case R.id.menu_main:
                        changeFragment(new MainFragment());
                        break;

                    case R.id.menu_recommend:
                        changeFragment(new RecommendFragment());
                        break;
                }

                return true;
            }
        });

        bnv.setSelectedItemId(R.id.menu_main);
    }

    public void changeFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(fl.getId(), fragment).commit();
    }

}