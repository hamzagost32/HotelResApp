package com.hamza.hotelresapp.model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    private int id;
    private String name;
    private String password;
    private String email;
    private String photoId;

    private int numRoom;
    private int numAdult;
    private int numChildren;

    private Date userCheckIn;
    private Date userCheckOut;

    private boolean isLogedIn;

    private int hotelId;

    public User(){

        this.numAdult    = 1;
        this.numChildren = 0;
        this.numRoom = 1;
        this.isLogedIn= true;
    }

    public boolean isLogedIn() {
        return isLogedIn;
    }

    public void setLogedIn(boolean logedIn) {
        isLogedIn = logedIn;
    }




    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public int getNumRoom() {
        return numRoom;
    }

    public void setNumRoom(int numRoom) {
        this.numRoom = numRoom;
    }

    public int getNumAdult() {
        return numAdult;
    }

    public void setNumAdult(int numAdult) {
        this.numAdult = numAdult;
    }

    public int getNumChildren() {
        return numChildren;
    }

    public void setNumChildren(int numChildren) {
        this.numChildren = numChildren;
    }

    public Date getUserCheckIn() {
        return userCheckIn;
    }

    public void setUserCheckIn(Date userCheckIn) {
        this.userCheckIn = userCheckIn;
    }

    public Date getUserCheckOut() {
        return userCheckOut;
    }

    public void setUserCheckOut(Date userCheckOut) {
        this.userCheckOut = userCheckOut;
    }

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id){ this.id = id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void login(){

    }

    public void logout(){

    }


}
