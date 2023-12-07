package com.example.duan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.duan.adapter.ProductViewPagerAdapter;
import com.example.duan.adapter.ViewPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ProductActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private BottomNavigationView bottomNavigationView;
    private TabLayout tabLayout;
    private ProductViewPagerAdapter productViewPagerAdapter;
    private int[] tabIcons = {
            R.string.xac_nhan_fragment,
            R.string.thuc_hien_fragment,
            R.string.don_huy_fragment
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        // find view by id
        viewPager2 = findViewById(R.id.viewPager2);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        tabLayout = findViewById(R.id.tabLayout);

        // set adapter
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager2.setAdapter(viewPagerAdapter);
        productViewPagerAdapter = new ProductViewPagerAdapter(this);

        // set tablayout
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setSelectedItemId(R.id.user);
        viewPager2.setAdapter(productViewPagerAdapter);

        // set bottom navigation
        bottomNavigationView.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                int id = item.getItemId();
                     if (item.getItemId() == R.id.home) {
                            Intent intent = new Intent(ProductActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                      }
                      else if (id == R.id.product){
                            viewPager2.setCurrentItem(0);
                      }else {
                            Intent intent = new Intent(ProductActivity.this, UserActivity.class);
                            startActivity(intent);
                            finish();
                      }
            }
        });
        // set tablayout
        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab( TabLayout.Tab tab, int position) {
                tab.setText(ProductActivity.this.getResources().getString(tabIcons[position]));
            }
        }).attach();

        // set viewpager2
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (viewPager2.getCurrentItem()){
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.product).setChecked(true);
                        break;
                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.user).setChecked(true);
                        break;
                }
            }
        });
    }
}