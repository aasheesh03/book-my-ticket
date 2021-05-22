package com.model;

import java.util.HashMap;

public class Seat {
    int seatID;
    int movieSlot;
    Constants.SeatStatus status;

    public Seat(int seatID, Constants.SeatStatus status) {
        this.seatID = seatID;
        this.status=status;
    }

    public int getSeatID() {
        return this.seatID;
    }

    public void setSeatID(int seatID) {
        this.seatID = seatID;
    }

    public Constants.SeatStatus getStatus() {
        return this.status;
    }

    public void setStatus(Constants.SeatStatus seatStatus) {
        this.status=seatStatus;
    }


    public Seat(int seatID, int movieSlot, Constants.SeatStatus status) {
        this.seatID = seatID;
        this.movieSlot = movieSlot;
        this.status = status;
    }
}
