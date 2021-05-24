package com.demo.bookmyticket.usecase.booking;

import com.demo.bookmyticket.model.Constants;
import com.demo.bookmyticket.model.Seat;
import com.demo.bookmyticket.model.Theater;
import com.demo.bookmyticket.model.User;
import com.demo.bookmyticket.repository.movies.MoviesDao;
import com.demo.bookmyticket.repository.theater.TheaterDao;
import com.demo.bookmyticket.repository.user.UserDao;

import java.util.List;

public class Booking {

    UserDao userDao;
    TheaterDao theaterDao;
    MoviesDao movieDao;

    public Booking(UserDao userDao, TheaterDao theaterDao, MoviesDao movieDao) {
        this.userDao = userDao;
        this.theaterDao = theaterDao;
        this.movieDao = movieDao;
    }

    public boolean bookTicket(int[] seatIDs, int theaterID, int userId, int movieID, Constants.MovieTimeSlots timeslot) {


        User user;
        Theater theater;
        List<Seat> seatList;


//get User
        user = userDao.getUser(userId);

// get Theater
        theater = theaterDao.getTheater(theaterID);
//get seat for timelsot

        seatList = theater.getSeats(timeslot);
        return bookSlot(seatList, seatIDs);

    }

    private synchronized boolean bookSlot(List<Seat> seatList, int[] seatIDs) {

        for (int seatIndex : seatIDs) {
            if (seatList.get(seatIndex - 1).getStatus() != Constants.SeatStatus.SEAT_NOT_BOOKED)
                return false;
        }

        for (int seatIndex : seatIDs) {
            seatList.get(seatIndex - 1).setStatus(Constants.SeatStatus.SEAT_BOOKED);
        }

        return true;
    }


}
