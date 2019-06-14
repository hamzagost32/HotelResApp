package com.hamza.hotelresapp.controller;

import com.hamza.hotelresapp.model.Hotel;

import java.util.ArrayList;

public interface HotelListAsyncResponse {
    void processFinished(ArrayList<Hotel> hotelsArrayList,String respone);
}
