package com.hamza.hotelresapp.userView;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hamza.hotelresapp.R;
import com.hamza.hotelresapp.controller.HotelListAsyncResponse;
import com.hamza.hotelresapp.controller.InfoPageAdapter;
import com.hamza.hotelresapp.data.DatabaseData;
import com.hamza.hotelresapp.model.Hotel;
import com.hamza.hotelresapp.model.User;

import java.util.ArrayList;

public class HotelInfoActivity extends AppCompatActivity {

    private ViewPager viewPagerInfo;
    private static final String HOST ="http://10.0.2.2/hotelApp/hotel_api/api/hotel/read_single.php";

    private TextView hotelName, hotelLocation, hotelRate, hotelAddress;
    private ImageView hotelPhoto;
    private User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_info);

        getHotelId();
        setViewPagerInfo();

    }

    private void getHotelId() {

        Bundle extras = getIntent().getExtras();

        int id = extras.getInt("hotel_id");
        String hid = Integer.valueOf(id).toString();
        user =(User) extras.getSerializable("user");

        getHotelData(hid);
        Log.d("USER","USER NUMBER OF ROOMnnb"+Integer.valueOf(user.getNumRoom()).toString());

    }

    private void getHotelData(String hid) {

        String url = HOST + "?id=" + hid;


        DatabaseData databaseData = new DatabaseData();
        databaseData.getHotelId(url, new HotelListAsyncResponse() {
            @Override
            public void processFinished(ArrayList<Hotel> hotelsArrayList, String respone) {

                setViewElement(hotelsArrayList.get(0));
                Log.d("PHOTOURL",hotelsArrayList.get(0).getPhotoUrl());
            }
        });
    }

    private void setViewElement(Hotel hotel) {
        initView();
        hotelName.setText(hotel.getName());
        hotelLocation.setText(hotel.getLocation());
        hotelRate.setText(hotel.getRate());
        hotelAddress.setText(hotel.getAddress());
        Glide.with(this).load(hotel.getPhotoUrl()).into(hotelPhoto);
    }

    private void initView() {
        hotelName       = findViewById(R.id.hotel_info_name);
        hotelLocation   = findViewById(R.id.hotel_info_location);
        hotelRate       = findViewById(R.id.hotel_info_rate);
        hotelAddress    = findViewById(R.id.hotel_info_address);
        hotelPhoto      = findViewById(R.id.hotel_info_photo);
    }

    private void setViewPagerInfo(){
        viewPagerInfo = findViewById(R.id.viewPagerInfo);
        viewPagerInfo.setAdapter(new InfoPageAdapter(getSupportFragmentManager()));

        TabLayout tabLayout = findViewById(R.id.tableLayoutInfoId);
        tabLayout.setupWithViewPager(viewPagerInfo);
    }

}
