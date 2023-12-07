package com.example.duan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private ViewPager2 viewPager2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (item.getItemId() == R.id.home) {
                    viewPager2.setCurrentItem(0);
                }
                else if (id == R.id.product){
                    Intent intent = new Intent(MainActivity.this, ProductActivity.class);
                    startActivity(intent);
                    finish();
                }else if (id == R.id.ship){
                    viewPager2.setCurrentItem(2);
                }else {
                    viewPager2.setCurrentItem(3);
                }
            }
        });
    }
}