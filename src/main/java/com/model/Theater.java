package com.model;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Theater {

    int theaterId;
    String theaterName;
    City city;
    HashMap<Constants.MovieTimeSlots,Movies> moviesMap=new HashMap<Constants.MovieTimeSlots,Movies>();;
    transient HashMap<Constants.MovieTimeSlots,List<Seat>>  seatMap= new HashMap<Constants.MovieTimeSlots,List<Seat>>();
    float rating;

    public int getTheaterId() {
        return this.theaterId;
    }

    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
    }

    public String getTheaterName() {
        return this.theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public City getCity() {
        return this.city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Seat> getSeats(Constants.MovieTimeSlots timeSlot) {
        return this.seatMap.get(timeSlot);
    }

    public void setSeats(Constants.MovieTimeSlots timeSlot,List<Seat> seats) {
        this.seatMap.put(timeSlot, seats);
    }


    public List<Movies> getMovies() {
        return this.moviesMap.values().stream()
                .collect(Collectors.toList());
    }

    public void setMoviesWithTime(HashMap<Constants.MovieTimeSlots,Movies> movies) {
        this.moviesMap= movies;
    }

    public float getRating() {
        return this.rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public Theater(int theaterId, String theaterName, City city, HashMap<Constants.MovieTimeSlots,Movies> movies, HashMap<Constants.MovieTimeSlots, List<Seat>> seatMap, float rating) {
        this.theaterId = theaterId;
        this.theaterName = theaterName;
        this.city = city;
        this.moviesMap = movies;
        this.seatMap = seatMap;
        this.rating = rating;
    }
}