package com.model;

import java.util.ArrayList;
import java.util.List;

public class City {
    int cityID;
    String cityName;

    public City(int cityID, String cityName,List<Theater> list) {
        this.cityID = cityID;
        this.cityName = cityName;
        //this.theaterList=list;
    }

    /*public List<Theater> getTheaterList() {
        return theaterList;
    }

    public void setTheaterList(List<Theater> theaterList) {
        this.theaterList = theaterList;
    }
*/
    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}