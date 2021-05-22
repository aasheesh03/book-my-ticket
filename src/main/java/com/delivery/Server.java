package com.delivery;

import com.google.gson.Gson;
import com.model.*;
import com.usecase.booking.Booking;
import com.usecase.getdata.GetData;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.List;

import static spark.Spark.*;

public class Server {
    int port = 9000;

    public void startServer() {
        System.out.println("starting service on 9000");
        port(9000);
        /*HttpServer server = null;
        try {
            server = HttpServer.create(new InetSocketAddress(port), 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("server started at " + port);
        server.createContext("/ping", new PingHandler());
        server.createContext("/getcity", new GetCities());
        server.createContext("/bookseat", new BookSeat());
        server.setExecutor(null);
        server.start();*/
        get("/hello", (req, res) -> "Hello World");
        get("/getcity", (req, res) -> {
            res.type("application/json");
            int cityId = 0;
            GetData getData = new GetData();
            cityId = Integer.parseInt(req.queryParams("cityId"));
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


            theaterID = Integer.parseInt(req.queryParams("theaterId"));
            userID = Integer.parseInt(req.queryParams("userId"));
            movieID = Integer.parseInt(req.queryParams("movieId"));
            String[] strArray = req.queryParams("seatIds").toString().split(",");
            String reqMovieTime= req.queryParams("timeslot");
            if (reqMovieTime==null){
                return new Gson()
                        .toJson(new Resposne(401, "Invalid Parameters"));
            }
            int timeSlot = Integer.parseInt(reqMovieTime);
            int size = strArray.length;
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = Integer.parseInt(strArray[i]);
            }

            if (!booking.bookTicket(arr, theaterID, userID, movieID,Constants.MovieTimeSlots.valueOf(timeSlot)))
                return new Gson()
                        .toJson(new Resposne(403, "Failure"));

            return new Gson()
                    .toJson(new Resposne(200, "Success"));
        });


        get("/gettheater", (req, res) -> {
            res.type("application/json");
            int cityId = 0;
            GetData getData = new GetData();
            cityId = Integer.parseInt(req.queryParams("cityId"));
            List<Theater> cityList = getData.getTheater(cityId);



            return new Gson()
                    .toJson(new Resposne(200, "Success", new Gson()
                            .toJsonTree(cityList)));
        });

        get("/getmovies", (req, res) -> {
            res.type("application/json");
            int theaterId = 0;
            GetData getData = new GetData();
            String reqTheaterId= req.queryParams("theaterId");
            if (reqTheaterId==null){
                return new Gson()
                        .toJson(new Resposne(401, "Invalid Parameters"));
            }
            theaterId = Integer.parseInt(reqTheaterId);
            List<Movies> movieList = getData.getMovies(theaterId);
            return new Gson()
                    .toJson(new Resposne(200, "Success", new Gson()
                            .toJsonTree(movieList)));
        });

        get("/getseats", (req, res) -> {
            res.type("application/json");
            int theaterId = 0;
            int movieId=0;
            GetData getData = new GetData();
            String reqTheaterId= req.queryParams("theaterId");
            if (reqTheaterId==null){
                return new Gson()
                        .toJson(new Resposne(401, "Invalid Parameters"));
            }
            theaterId = Integer.parseInt(reqTheaterId);

            String reqMovieId= req.queryParams("movieId");
            if (reqMovieId==null){
                return new Gson()
                        .toJson(new Resposne(401, "Invalid Parameters"));
            }

            String reqMovieTime= req.queryParams("timeslot");
            if (reqMovieTime==null){
                return new Gson()
                        .toJson(new Resposne(401, "Invalid Parameters"));
            }
            int timeSlot = Integer.parseInt(reqMovieTime);
            List<Seat> seatList = getData.getSeatList(theaterId,movieId, Constants.MovieTimeSlots.valueOf(timeSlot));



            return new Gson()
                    .toJson(new Resposne(200, "Success", new Gson()
                            .toJsonTree(seatList)));
        });


    }
}
