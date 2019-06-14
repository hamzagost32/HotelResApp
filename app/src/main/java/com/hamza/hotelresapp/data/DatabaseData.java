package com.hamza.hotelresapp.data;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import com.hamza.hotelresapp.controller.AppController;
import com.hamza.hotelresapp.controller.HotelListAsyncResponse;
import com.hamza.hotelresapp.model.Hotel;
import com.hamza.hotelresapp.userView.HotelSearch;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DatabaseData  {

    private  ArrayList<Hotel> hotels = new ArrayList<>();

    public DatabaseData() {

    }
    // TODO USE THIS Method or remove it if share
    public void getHotelId(String url, final HotelListAsyncResponse callbak){

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONObject hotelObject = response.getJSONObject("data");


                    Hotel hotel = new Hotel();

                    hotel.setName(hotelObject.getString("hotel_name"));
                    hotel.setAddress(hotelObject.getString("hotel_address"));
                    hotel.setLocation(hotelObject.getString("hotel_location"));
                    hotel.setRate(hotelObject.getString("hotel_rate"));
                    hotel.setPhotoUrl(hotelObject.getString("photoUrl"));
                    hotels.add(hotel);

                } catch (JSONException e) {
                    e.printStackTrace();
                }if(null != callbak) callbak.processFinished(hotels,response.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Log.d("RESPONSE",error .toString());
            }
        });

        AppController.getInstance().addToRequestQueue(jsonObjectRequest);

    }

    public void getAllHotelByLocation(String url,final HotelListAsyncResponse callbak) {


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    String status = response.getString("message");

                    if(status.equals("1")){

                        JSONArray data = response.getJSONArray("data");
                        for(int i=0; i < data.length();i++) {
                            JSONObject hotelObject = data.getJSONObject(i);
                            Hotel hotel = new Hotel();

                            hotel.setId(hotelObject.getInt("hotel_id"));

                            hotel.setName(hotelObject.getString("hotel_name"));
                            hotel.setAddress(hotelObject.getString("hotel_address"));
                            hotel.setLocation(hotelObject.getString("hotel_location"));
                            hotel.setRate(hotelObject.getString("hotel_rate"));
                            hotel.setPhotoUrl(hotelObject.getString("photoUrl"));

                            hotels.add(hotel);

                        }
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                } if(null != callbak) callbak.processFinished(hotels,response.toString());



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("RESPONSE",error .toString());
            }
        });

        AppController.getInstance().addToRequestQueue(jsonObjectRequest);

    }

    public void postData(){

        String link = "http://10.0.2.2/hotelApp/test.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                link, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("RESP",response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> MyData = new HashMap<String, String>();
                MyData.put("data", "just work"); //Add the data you'd like to send to the server.
                return MyData;
            }
        };

        AppController.getInstance().addToRequestQueue(stringRequest);
    }

}