package com.demo.bookmyticket.model;
public  class Movies {

    int movieId;
    String movieName;


    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }


    public Movies(int movieId, String movieName, Constants.MovieTimeSlots timeSlot) {
        this.movieId = movieId;
        this.movieName = movieName;
    }
}