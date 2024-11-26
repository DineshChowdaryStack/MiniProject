package com.TripPlanning.TripBackend.Controller;

public class TripNotFoundException extends RuntimeException {

    public TripNotFoundException(String message) {
        super(message);
    }

}
