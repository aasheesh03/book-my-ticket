package com.model;

import java.util.List;

public class City {
    int cityID;
    String cityName;

    public City(int cityID, String cityName, List<Theater> list) {
        this.cityID = cityID;
        this.cityName = cityName;
    }


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