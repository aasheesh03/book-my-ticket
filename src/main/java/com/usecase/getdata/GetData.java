package com.usecase.getdata;

import com.model.*;
import com.repository.cities.CitiesDao;
import com.repository.cityTheater.CityTheaterDao;
import com.repository.movies.MoviesDao;
import com.repository.theater.TheaterDao;
import com.repository.user.UserDao;

import java.util.ArrayList;
import java.util.List;

public class GetData {

    UserDao userDao = UserDao.getInstance();
    TheaterDao theaterDao = TheaterDao.getInstance();
    MoviesDao movieDao = MoviesDao.getInstance();
    CitiesDao citiesDao = CitiesDao.getInstance();
    CityTheaterDao cityTheaterDao = CityTheaterDao.getInstance();


    public List<Seat> getSeatList(int theaterID, Constants.MovieTimeSlots timeslot) {
        return theaterDao.getTheater(theaterID).getSeats(timeslot);
    }

    public List<City> getCities(int cityId) {
        List<City> list;
        if (cityId != 0) {
            list = new ArrayList<City>();
            list.add(citiesDao.getCity(cityId));
            return list;
        } else {
            list = citiesDao.getAllCities();
            return list;
        }

    }

    public List<Theater> getTheater(int cityId) {

        if (cityId != 0) {
            return cityTheaterDao.getTheaterList(cityId);
        } else {
            return theaterDao.getAllTheaterList();
        }
    }

    public List<Movies> getMovies(int theaterId) {
        if (theaterId != 0) {
            return theaterDao.getTheater(theaterId).getMovies();
        }
        return movieDao.getAllMovies();


    }

}
