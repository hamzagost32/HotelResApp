package com.hamza.hotelresapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hamza.hotelresapp.data.DatabaseData;
import com.hamza.hotelresapp.model.Reservation;
import com.hamza.hotelresapp.model.User;
import com.hamza.hotelresapp.userView.HotelSearch;

public class StartApp extends AppCompatActivity {

    EditText searchET;
    ImageButton btnSearchIM;
    private  User user;
    private Reservation reservation;
    private ImageView userImage;
    private TextView userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_app);

        searchET    = findViewById(R.id.search_text);
        btnSearchIM =findViewById(R.id.search_btn);
        userImage   = findViewById(R.id.user_image);
        userName    = findViewById(R.id.user_name);

        setUserLogIn();
    }

    private void setUserLogIn() {
        user = new User();
        if(user.isLogedIn()){
            userName.setVisibility(View.VISIBLE);
            userName.setText("Hamza");

            userImage.setVisibility(View.VISIBLE);

        }
        // TODO call user.logIn() method for the user
        // this object will determine user chois for reservation
    }

    public void getLocation(View view){
        String searchTxt = searchET.getText().toString();
        if(searchTxt.equals("")){
            Toast.makeText(StartApp.this,"Please Enter location",
                    Toast.LENGTH_LONG).show();
        }else {
            Intent searchIntent = new Intent(StartApp.this, HotelSearch.class);
            searchIntent.putExtra("searchTxt",searchTxt);
            searchIntent.putExtra("user",user);
            startActivity(searchIntent);
        }
    }

}
