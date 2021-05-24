package com.demo.bookmyticket.repository.cityTheater;

import com.demo.bookmyticket.model.Theater;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CityTheaterDao {

    HashMap<Integer, List<Theater>> cityTheaterMap = new HashMap<Integer, List<Theater>>();
    private static CityTheaterDao instance;


    public void addCityTheaterMap(int cityId, Theater theater) {
        List<Theater> list = cityTheaterMap.get(cityId);
        if (list == null)
            list = new ArrayList<Theater>();
        list.add(theater);
        cityTheaterMap.put(cityId, list);
    }

    public List<Theater> getTheaterList(int cityId) {
        return cityTheaterMap.get(cityId);
    }


    private CityTheaterDao() {

    }

    public static synchronized CityTheaterDao getInstance() {
        if (instance == null)
            instance = new CityTheaterDao();
        return instance;
    }
}
