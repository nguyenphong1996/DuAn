package com.example.duan.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.duan.fragment.DonHuyFragment;
import com.example.duan.fragment.HoanThanhFragment;
import com.example.duan.fragment.XacNhanFragment;

public class ProductViewPagerAdapter extends FragmentStateAdapter {

    public ProductViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 0:
                return new XacNhanFragment();
            case 1:
                return new HoanThanhFragment();
            case 2:
                return new DonHuyFragment();
            default:
                return new XacNhanFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
