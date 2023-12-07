package com.example.duan.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.duan.R;
import com.example.duan.adapter.ProductViewPagerAdapter;
import com.example.duan.adapter.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class ProductFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private ProductViewPagerAdapter ProductViewPagerAdapter;
    public ProductFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return   inflater.inflate(R.layout.fragment_product, container, false);

    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}