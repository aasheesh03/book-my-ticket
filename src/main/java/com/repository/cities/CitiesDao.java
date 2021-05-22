package com.repository.cities;

import com.model.City;
import com.model.Theater;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CitiesDao {

    HashMap<Integer,City> cityMap=new HashMap<Integer, City>();
    private static CitiesDao instance;

    public   void addCity(City city){
        cityMap.put(city.getCityID(),city);
    }

    public City getCity(int cityID){
      return   cityMap.get(cityID);
    }

    public List<City> getAllCities(){
        return cityMap.values().stream()
                .collect(Collectors.toList());
    }
    private CitiesDao(){

    }

    public  static  synchronized CitiesDao   getInstance(){
        if (instance==null)
            instance=new CitiesDao();
        return instance;
    }





}
