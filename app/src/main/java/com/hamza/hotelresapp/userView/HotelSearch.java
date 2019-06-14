package com.hamza.hotelresapp.userView;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.hamza.hotelresapp.R;
import com.hamza.hotelresapp.controller.HotelAdapter;
import com.hamza.hotelresapp.controller.HotelListAsyncResponse;
import com.hamza.hotelresapp.data.DatabaseData;
import com.hamza.hotelresapp.model.Hotel;
import com.hamza.hotelresapp.model.User;

import java.util.ArrayList;
import java.util.Date;

public class HotelSearch extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private HotelAdapter hotelAdapter;
    private static final String HOST ="http://10.0.2.2/hotelApp/hotel_api/api/hotel/read_by_location.php";

    private EditText searchText;
    private ImageButton btnSearch;
    private AlertDialog.Builder currentAlertDialog;
    private AlertDialog dialog;
    private CardView cardView;
    private LinearLayout linearLayout;


    private User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_search);

        linearLayout = findViewById(R.id.view_element);


        searchLocation();
        cardView = findViewById(R.id.search_cardv);
        cardView.setOnClickListener(this);

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setOnClickListener(this);




    }

    private void searchLocation() {
        setUpView();
        Intent intent = getIntent();
        String location = intent.getStringExtra("searchTxt");
        user = (User) intent.getSerializableExtra("user");
        searchText.setText(location);
        serchForHotel(location);
    }

    private void setUpView() {
        searchText = findViewById(R.id.search_hotle);
        btnSearch = findViewById(R.id.search_startIB);


    }

    private void serchForHotel(String location) {
        DatabaseData getHotels = new DatabaseData();
        String  url =HOST+"?location=" +location;

        Log.d("RESPONSE",url);
        getHotels.getAllHotelByLocation(url, new HotelListAsyncResponse() {
            @Override
            public void processFinished(ArrayList<Hotel> hotelsArrayList, String respone) {

                if(hotelsArrayList.isEmpty()) {
                    Log.d("RESPONDE", respone.toString());
                    Toast.makeText(HotelSearch.this,"Data not found try shearch another",
                            Toast.LENGTH_LONG).show();
                }else{
                    setAdapter(hotelsArrayList);
                    Log.d("RESPONDE", respone.toString());
                }
            }
        });
    }

    private void setAdapter( ArrayList<Hotel> hotels){
        //Log.d("RESPONSE",hotels.get(0).getName());

        recyclerView = findViewById(R.id.recycler);
        hotelAdapter = new HotelAdapter(getApplicationContext(),hotels, user);
        recyclerView.setAdapter(hotelAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));


    }

    public void onButtonSearch(View view){

        String txt =searchText.getText().toString();
        if(!txt.isEmpty()){
            serchForHotel(txt);
        }else {
            Toast.makeText(HotelSearch.this,"Plase enter Location to start",
                    Toast.LENGTH_LONG).show();
        }

    }

    public void onButtonCheckIn(final View view){
        currentAlertDialog = null;
        dialog = null;

        currentAlertDialog = new AlertDialog.Builder(view.getContext());
        final View checkInView = getLayoutInflater().inflate(R.layout.check_in_dialog,null,false);
        // TODO you can get date from checkInView
        Button doneTxt= checkInView.findViewById(R.id.done_btn);
        doneTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO get what the user select for the date and call the right method
                DatePicker checkInDate = checkInView.findViewById(R.id.check_in_date);

                //checkInDate.setMinDate(user.getUserCheckIn());

                int day =checkInDate.getDayOfMonth();
                // TODO pass check in date to user.set_check_in_date
                //user.setUserCheckIn();

                Toast.makeText(view.getContext(),
                        Integer.valueOf(day).toString(),
                        Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
        });

        Button cancel = checkInView.findViewById(R.id.clear_txt);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


        currentAlertDialog.setView(checkInView);
        dialog = currentAlertDialog.create();
        dialog.show();
    }

    public void onButtonCheckOut(final View view){
        currentAlertDialog = null;
        dialog = null;

        currentAlertDialog = new AlertDialog.Builder(view.getContext());
        final View checkInView = getLayoutInflater().inflate(R.layout.check_in_dialog,null,false);

        // TODO you can get date from checkInView
        Button doneTxt= checkInView.findViewById(R.id.done_btn);
        doneTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO get what the user select for the date and call the right method
                DatePicker checkOutDate = checkInView.findViewById(R.id.check_in_date);

                //checkOutDate.setMinDate();
                int day =checkOutDate.getDayOfMonth();

                // TODO pass chekin date to user.set_check_out_date

                Toast.makeText(view.getContext(),
                        Integer.valueOf(day).toString(),
                        Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
        });

        Button cancel = checkInView.findViewById(R.id.clear_txt);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


        currentAlertDialog.setView(checkInView);
        dialog = currentAlertDialog.create();
        dialog.show();
    }

    public void onButtonRoom(View view) {

        currentAlertDialog = null;
        dialog = null;

        currentAlertDialog = new AlertDialog.Builder(view.getContext());
        final View roomType = getLayoutInflater().inflate(R.layout.room_type,null,false);


        currentAlertDialog.setView(roomType);
        dialog = currentAlertDialog.create();
        dialog.show();



    }

    @Override
    public void onClick(View v) {
        if(v.getId() != cardView.getId()){
            linearLayout.setVisibility(View.GONE);
        }else if(v.getId() == cardView.getId())  {
            linearLayout.setVisibility(View.VISIBLE);
        }
    }
}
