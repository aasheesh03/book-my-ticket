package com.model;

import java.util.HashMap;

public class Constants {

    public enum MovieTimeSlots {
        MORNING(1),
        AFTERNOON(2),
        EVENING(3),
        NIGHT(4);
        private int value;
        private static HashMap MovieTimeSlotsMap=new HashMap();
        MovieTimeSlots(int value){
            this.value=value;
        }
        static {
            for (MovieTimeSlots movieTimeSlots : MovieTimeSlots.values()) {
                MovieTimeSlotsMap.put(movieTimeSlots.value, movieTimeSlots);
            }
        }

        public static MovieTimeSlots valueOf(int timeSlot) {
            return (MovieTimeSlots) MovieTimeSlotsMap.get(timeSlot);
        }

        public int getValue() {
            return value;
        }

    }

    public enum SeatStatus {
        SEAT_BOOKED,
        SEAT_NOT_BOOKED;
    }

    public enum MovieType {
        ENGLISH,
        HINDI;
    }

    public enum SeatType {
        NORMAL,
        EXECUTIVE,
        PREMIUM,
        VIP;
    }
}



