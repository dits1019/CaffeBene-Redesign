package com.example.caffebenecopy;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.caffebenecopy.Fragment.LoginFragment;
import com.example.caffebenecopy.Fragment.MainFragment;
import com.example.caffebenecopy.Fragment.NotificationFragment;

public class VerticalViewPagerAdapter extends FragmentStateAdapter {
    public int mcount;

    public VerticalViewPagerAdapter(FragmentActivity fa, int count){
        super(fa);
        mcount = count;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        int index = 1;
        index = getRealPosition(position);


        if(index==0) return new LoginFragment();
        else if(index==1) return new MainFragment();
        else return new NotificationFragment();
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public int getRealPosition(int position){
        return position % mcount;
    }
}
