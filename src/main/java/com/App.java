package com;

import com.delivery.Server;
import com.model.*;
import com.repository.cities.CitiesDao;
import com.repository.cityTheater.CityTheaterDao;
import com.repository.movies.MoviesDao;
import com.repository.theater.TheaterDao;
import com.repository.user.UserDao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class App {
    public static void main(String[] args){

        UserDao userDao=UserDao.getInstance();
        TheaterDao theaterDao=TheaterDao.getInstance();
        MoviesDao movieDao=MoviesDao.getInstance();
        CitiesDao citiesDao= CitiesDao.getInstance();
        CityTheaterDao cityTheaterDao= CityTheaterDao.getInstance();
        userDao.addUser(new User(1,"aasheesh", new Date(),"9654062283","",""));
        Movies m1=new Movies(1,"movie 1", Constants.MovieTimeSlots.MORNING);
        Movies m2=new Movies(2,"movie 2",Constants.MovieTimeSlots.MORNING);
        Movies m3=new Movies(3,"movie 3",Constants.MovieTimeSlots.MORNING);
        List<Movies> movieList=new ArrayList<Movies>();
        movieList.add(m1);
        movieList.add(m2);
        movieList.add(m3);

        HashMap<Constants.MovieTimeSlots,Movies>hashMap=new HashMap<Constants.MovieTimeSlots,Movies>();
        hashMap.put(Constants.MovieTimeSlots.MORNING,m1);
        hashMap.put(Constants.MovieTimeSlots.AFTERNOON,m2);
        hashMap.put(Constants.MovieTimeSlots.EVENING,m3);
        List<Seat> seatList=new ArrayList<Seat>();
        movieDao.addMovie(m1);
        movieDao.addMovie(m2);
        movieDao.addMovie(m3);

        for (int i=1;i<100;i++){
            seatList.add(new Seat(i,Constants.SeatStatus.SEAT_NOT_BOOKED));
        }
        HashMap<Constants.MovieTimeSlots,List<Seat>> map=new HashMap<Constants.MovieTimeSlots,List<Seat>>();
        map.put(Constants.MovieTimeSlots.MORNING,seatList);
        map.put(Constants.MovieTimeSlots.AFTERNOON,seatList);
        map.put(Constants.MovieTimeSlots.EVENING,seatList);
Theater t1,t2,t3;
     t1=new Theater(1,"pvr",new City(1,"1",null),hashMap,map,4);
        t2=new Theater(2,"big",new City(1,"1",null),hashMap,map,4);
  t3=new Theater(3,"wave",new City(1,"1",null),hashMap,map,4);

        theaterDao.addTheater(t1);
        theaterDao.addTheater(t2);
        theaterDao.addTheater(t3);
        List<Theater>theaterList1=new ArrayList<Theater>();
        List<Theater>theaterList2=new ArrayList<Theater>();
        List<Theater>theaterList3=new ArrayList<Theater>();

        theaterList1.add(t1);
        theaterList1.add(t2);

        theaterList2.add(t3);
        theaterList3.add(t1);
        theaterList3.add(t3);
        citiesDao.addCity(new City(1,"Delhi",theaterList1));
        citiesDao.addCity(new City(2,"Noida",theaterList2));
        citiesDao.addCity(new City(3,"Mumbai",theaterList3));
        cityTheaterDao.addCityTheaterMap(1,t1);
        cityTheaterDao.addCityTheaterMap(1,t2);
        cityTheaterDao.addCityTheaterMap(2,t3);
        cityTheaterDao.addCityTheaterMap(3,t1);
        cityTheaterDao.addCityTheaterMap(3,t3);
        Server server=new  Server();
        server.startServer();
        
    }
    
}
