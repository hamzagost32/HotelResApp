package com.hamza.hotelresapp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Reservation  {
    private int id;                  // contain reservation id
    private int hotel_id;            // contain hotel id
    private int user_id;             // user id
    private List<Integer> rooms_id;  // contain list of rooms id
    private Date check_in_date;      // start date
    private Date check_out_date;     // end date

    private int roomNumber      = 1;          // room number
    private int numAdult        = 1;            // number of adult
    private int numChildren     = 0;         // number of children

    // TODO make sure the id and user id not null
    public Reservation(){

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public List<Integer> getRooms_id() {
        return rooms_id;
    }

    public void setRooms_id(List<Integer> rooms_id) {
        this.rooms_id = rooms_id;
    }

    public Date getCheck_in_date() {
        return check_in_date;
    }

    public void setCheck_in_date(Date check_in_date) {
        this.check_in_date = check_in_date;
    }

    public Date getCheck_out_date() {
        return check_out_date;
    }

    public void setCheck_out_date(Date check_out_date) {
        this.check_out_date = check_out_date;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
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

    
}
