package com.hamza.hotelresapp.userView.views;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hamza.hotelresapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Rating extends Fragment {


    public Rating() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ratingView = inflater.inflate(R.layout.fragment_rating, container, false);


        return ratingView;
    }

}
