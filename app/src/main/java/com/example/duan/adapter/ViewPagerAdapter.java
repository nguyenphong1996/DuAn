package com.example.duan.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.duan.MainActivity;
import com.example.duan.fragment.DonHuyFragment;
import com.example.duan.fragment.XacNhanFragment;
import com.example.duan.fragment.ProductFragment;

public class ViewPagerAdapter  extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 0:
                return new ProductFragment();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
