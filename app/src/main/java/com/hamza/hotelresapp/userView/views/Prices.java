package com.hamza.hotelresapp.userView.views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hamza.hotelresapp.R;

public class Prices extends Fragment {


    public Prices() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View pricesView =inflater.inflate(R.layout.fragment_prices, container, false);



        return pricesView;
    }

}
