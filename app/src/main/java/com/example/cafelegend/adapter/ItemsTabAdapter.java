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

    private String username;

    public ItemsTabAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return AppetizerFragment.newInstance(username);
            case 1: return MainCourseFragment.newInstance(username);
            case 2: return BeverageFragment.newInstance(username);
        }
        return AppetizerFragment.newInstance(username);
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
