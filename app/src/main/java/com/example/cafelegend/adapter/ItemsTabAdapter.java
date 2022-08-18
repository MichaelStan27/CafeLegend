package com.example.cafelegend.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.cafelegend.fragment.BeverageFragment;
import com.example.cafelegend.fragment.AppetizerFragment;
import com.example.cafelegend.fragment.MainCourseFragment;

public class ItemsTabAdapter extends FragmentStateAdapter {

    public ItemsTabAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return new AppetizerFragment();
            case 1: return new MainCourseFragment();
            case 2: return new BeverageFragment();
        }
        return new AppetizerFragment();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
