package com.repository.theater;

import com.model.Theater;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TheaterDao {

    private HashMap<Integer, Theater> theaterMap = new HashMap<Integer, Theater>();
    private static TheaterDao instance;


    public void addTheater(Theater theater) {
        theaterMap.put(theater.getTheaterId(), theater);

    }

    public Theater getTheater(int theaterID) {
        return theaterMap.getOrDefault(theaterID, null);
    }

    public List<Theater> getAllTheaterList() {
        return theaterMap.values().stream()
                .collect(Collectors.toList());
    }

    private TheaterDao() {

    }

    public static synchronized TheaterDao getInstance() {
        if (instance == null)
            instance = new TheaterDao();
        return instance;
    }
}
