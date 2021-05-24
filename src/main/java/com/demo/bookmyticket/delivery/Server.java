package com.demo.bookmyticket.delivery;

import com.google.gson.Gson;
import com.demo.bookmyticket.model.*;
import com.demo.bookmyticket.usecase.booking.Booking;
import com.demo.bookmyticket.usecase.getdata.GetData;

import java.util.List;

import static spark.Spark.*;

public class Server {

    public void startServer() {
        System.out.println("starting service on 9000");
        port(9000);
        get("/hello", (req, res) -> "Hello World");
        get("/getcity", (req, res) -> {
            res.type("application/json");
            int cityId = 0;
            GetData getData = new GetData();
            String reqCityId = req.queryParams("cityid");
            if (reqCityId != null) {
                cityId = Integer.parseInt(reqCityId);
            }
            List<City> cityList = getData.getCities(cityId);
            return new Gson()
                    .toJson(new Resposne(200, "Success", new Gson()
                            .toJsonTree(cityList)));
        });

        post("/bookticket", (req, res) -> {
            res.type("application/json");
            Booking booking = new Booking();

            int theaterID = 0;
            int userID = 0;
            int movieID = 0;

            String reqTheaterId = req.queryParams("theaterid");
            if (reqTheaterId == null) {
                return new Gson()
                        .toJson(new Resposne(400, "Invalid Parameters"));
            }
            theaterID = Integer.parseInt(reqTheaterId);
            String reqUserId = req.queryParams("userid");
            if (reqUserId == null) {
                return new Gson()
                        .toJson(new Resposne(400, "Invalid Parameters"));
            }
            userID = Integer.parseInt(reqUserId);
            String reqMovieId = req.queryParams("movieid");
            if (reqMovieId == null) {
                return new Gson()
                        .toJson(new Resposne(400, "Invalid Parameters"));
            }
            movieID = Integer.parseInt(reqMovieId);
            String reqSeatIds = req.queryParams("seatids");
            if (reqSeatIds == null) {
                return new Gson()
                        .toJson(new Resposne(400, "Invalid Parameters"));
            }
            String[] strArray = reqSeatIds.toString().split(",");
            if (strArray.length == 0) {
                return new Gson()
                        .toJson(new Resposne(400, "Invalid Parameters"));
            }

            String reqMovieTime = req.queryParams("timeslot");
            if (reqMovieTime == null) {
                return new Gson()
                        .toJson(new Resposne(400, "Invalid Parameters"));
            }
            int timeSlot = Integer.parseInt(reqMovieTime);
            int size = strArray.length;
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = Integer.parseInt(strArray[i]);
            }

            if (!booking.bookTicket(arr, theaterID, userID, movieID, Constants.MovieTimeSlots.valueOf(timeSlot)))
                return new Gson()
                        .toJson(new Resposne(403, "Failure"));

            return new Gson()
                    .toJson(new Resposne(200, "Success"));
        });


        get("/gettheater", (req, res) -> {
            res.type("application/json");
            int cityId = 0;
            GetData getData = new GetData();
            String reqCityId = req.queryParams("cityid");
            if (reqCityId != null) {
                cityId = Integer.parseInt(reqCityId);
            }
            List<Theater> cityList = getData.getTheater(cityId);


            return new Gson()
                    .toJson(new Resposne(200, "Success", new Gson()
                            .toJsonTree(cityList)));
        });

        get("/getmovies", (req, res) -> {
            res.type("application/json");
            int theaterId = 0;
            GetData getData = new GetData();
            String reqTheaterId = req.queryParams("theaterid");
            if (reqTheaterId != null) {
                theaterId = Integer.parseInt(reqTheaterId);
            }

            List<Movies> movieList = getData.getMovies(theaterId);
            return new Gson()
                    .toJson(new Resposne(200, "Success", new Gson()
                            .toJsonTree(movieList)));
        });

        get("/getseats", (req, res) -> {
            res.type("application/json");
            int theaterId = 0;
            GetData getData = new GetData();
            String reqTheaterId = req.queryParams("theaterid");
            if (reqTheaterId == null) {
                return new Gson()
                        .toJson(new Resposne(400, "Invalid Parameters"));
            }
            theaterId = Integer.parseInt(reqTheaterId);

            String reqMovieTime = req.queryParams("timeslot");
            if (reqMovieTime == null) {
                return new Gson()
                        .toJson(new Resposne(400, "Invalid Parameters"));
            }
            int timeSlot = Integer.parseInt(reqMovieTime);
            List<Seat> seatList = getData.getSeatList(theaterId, Constants.MovieTimeSlots.valueOf(timeSlot));


            return new Gson()
                    .toJson(new Resposne(200, "Success", new Gson()
                            .toJsonTree(seatList)));
        });


    }
}
