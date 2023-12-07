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
        if (position==0){
            return new XacNhanFragment();
        } else if (position==1){
            return new HoanThanhFragment();
        } else if (position==2){
            return new DonHuyFragment();
        } else {
            return new XacNhanFragment();

        }
    }

    @Override
    public int getItemCount() {

        return 3;
    }
    public CharSequence getPageTitle(int position){
        switch (position){
            case 0:
                return "Đang xác nhận";
            case 1:
                return "Đã hoàn thành";
            case 2:
                return "Đã hủy";
            default:
                return "Đang xác nhận";
        }
    }
}
