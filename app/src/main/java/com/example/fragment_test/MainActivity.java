package com.example.fragment_test;

import android.os.Bundle;
import android.widget.FrameLayout;
import com.google.android.material.tabs.TabLayout;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    TabLayout tablayout;
    FrameLayout framelayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        framelayout = findViewById(R.id.framelayout1);
        tablayout = findViewById(R.id.tablayout);

        // Khởi tạo Fragment đầu tiên
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.framelayout1, new FirstFragment())
                .addToBackStack(null)
                .commit();

        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment = null;
                switch (tab.getPosition()) {
                    case 0:
                        fragment = new FirstFragment();
                        break;
                    case 1:
                        fragment = new Second_Fragment();
                        break;
                    case 2:
                        fragment = new Thirdfragment();
                        break;
                }

                if (fragment != null) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.framelayout1, fragment)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            .commit();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}