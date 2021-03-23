package com.example.caffebenecopy.Fragment;

import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.caffebenecopy.R;
import com.example.caffebenecopy.ViewPagerAdapter;
import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainFragment extends Fragment {
    List<Integer> listImages = new ArrayList<>();
    
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final ViewGroup rootview = (ViewGroup)inflater.inflate(R.layout.main_fragment, container, false);

        initImages();

        final HorizontalInfiniteCycleViewPager pager = rootview.findViewById(R.id.cycle_viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(listImages, getContext());
        pager.setAdapter(adapter);


        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                RelativeLayout background = rootview.findViewById(R.id.fragment_background);
                switch (pager.getRealItem()){
                    case 0:
                        background.setBackgroundResource(R.drawable.slide_bg1);
                        break;
                    case 1:
                        background.setBackgroundResource(R.drawable.slide_bg2);
                        break;
                    case 2:
                        background.setBackgroundResource(R.drawable.slide_bg3);
                        break;
                    case 3:
                        background.setBackgroundResource(R.drawable.slide_bg4);
                        break;
                }
            }
        };
        Timer timer = new Timer();
        timer.schedule(tt, 0, 300);

        
        return rootview;
    }

    private void initImages() {
        listImages.add(R.drawable.flipper_img1);
        listImages.add(R.drawable.flipper_img2);
        listImages.add(R.drawable.flipper_img3);
        listImages.add(R.drawable.flipper_img4);
    }
}
