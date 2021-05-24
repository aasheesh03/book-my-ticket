package com.usecase.booking;

import com.model.Constants;
import com.model.Seat;
import com.model.Theater;
import com.model.User;
import com.repository.movies.MoviesDao;
import com.repository.theater.TheaterDao;
import com.repository.user.UserDao;

import java.util.List;

public class Booking {

    UserDao userDao = UserDao.getInstance();
    TheaterDao theaterDao = TheaterDao.getInstance();
    MoviesDao movieDao = MoviesDao.getInstance();

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
