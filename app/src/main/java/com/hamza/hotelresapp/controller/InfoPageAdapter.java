package com.hamza.hotelresapp.controller;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import com.hamza.hotelresapp.userView.views.Details;
import com.hamza.hotelresapp.userView.views.Prices;
import com.hamza.hotelresapp.userView.views.Rating;

public class InfoPageAdapter extends FragmentPagerAdapter {


    public InfoPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Fragment getItem(int pos) {

        switch (pos){
            case 0: return new Details();
            case 1: return new Prices();
            case 2: return new Rating();
        }

        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position){
            case 0: return "Details";
            case 1: return  "Prices";
            case 2: return  "Rating";
        }

        return null;
    }
}
