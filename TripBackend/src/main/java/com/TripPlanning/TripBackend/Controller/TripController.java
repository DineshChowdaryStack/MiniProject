package com.TripPlanning.TripBackend.Controller;

import com.TripPlanning.TripBackend.Entity.Activity;
import com.TripPlanning.TripBackend.Entity.Booking;
import com.TripPlanning.TripBackend.Entity.Trip;
import com.TripPlanning.TripBackend.Repository.ActivityRepository;
import com.TripPlanning.TripBackend.Repository.BookingRepository;
import com.TripPlanning.TripBackend.Repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class TripController {
    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ActivityRepository activityRepository;


    @GetMapping("/")
    public String welcome() {
        return "Welcome to the Travel Planning API";
    }


    @GetMapping("/trips")
    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }


    @PostMapping("/trips")
    @ResponseStatus(HttpStatus.CREATED)
    public Trip createTrip(@RequestBody Trip trip) {
        return tripRepository.save(trip);
    }


    @GetMapping("/trips/{tripId}")
    public Trip getTripById(@PathVariable int tripId) {
        return tripRepository.findById(tripId).orElseThrow(() -> new TripNotFoundException("Trip not found"));
    }


    @DeleteMapping("/trips/{tripId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTrip(@PathVariable int tripId) {
        tripRepository.deleteById(tripId);
    }


    @PostMapping("/trips/{tripId}/bookings")
    public Booking addBooking(@PathVariable int tripId, @RequestBody Booking booking) {
        Trip trip = tripRepository.findById(tripId).orElseThrow(() -> new TripNotFoundException("Trip not found"));
        booking.setTrip(trip);
        return bookingRepository.save(booking);
    }


    @DeleteMapping("/trips/{tripId}/bookings/{bookingId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeBooking(@PathVariable int tripId, @PathVariable int bookingId) {
        Trip trip = tripRepository.findById(tripId).orElseThrow(() -> new TripNotFoundException("Trip not found"));
        bookingRepository.deleteById(bookingId);
    }


    @PostMapping("/trips/{tripId}/activities")
    public Activity addActivity(@PathVariable int tripId, @RequestBody Activity activity) {
        Trip trip = tripRepository.findById(tripId).orElseThrow(() -> new TripNotFoundException("Trip not found"));
        activity.setTrip(trip);
        return activityRepository.save(activity);
    }


    @DeleteMapping("/trips/{tripId}/activities/{activityId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeActivity(@PathVariable int tripId, @PathVariable int activityId) {
        Trip trip = tripRepository.findById(tripId).orElseThrow(() -> new TripNotFoundException("Trip not found"));
        activityRepository.deleteById(activityId);
    }

    //     Fetch activity suggestions based on destination
    @GetMapping("/activities/suggestions")
    public List<Activity> getActivitySuggestions(@RequestParam String destination) {
        // You can fetch activity suggestions from an external service, but for simplicity, we're just returning static data.
        Trip trip = tripRepository.findById(1).orElseThrow(() -> new TripNotFoundException("Trip not found"));

        return List.of(
                new Activity(1L, destination, "Visit Museum", trip),
                new Activity(2L, destination, "Beach Day", trip),
                new Activity(3L, destination, "City Tour", trip)
        );
    }

    @GetMapping("/weather")
    public String getWeather(@RequestParam String destination) {
        return "Temperature: 25°C, Forecast: Sunny with occasional clouds in " + destination;
    }

    @GetMapping("/transport")
    public String getTransport(@RequestParam String destination) {
        String fromLocation = "Mumbai";  // For example, you can hardcode or fetch dynamically
        String toLocation = destination; // Assuming 'destination' is the place you want to travel to

        return "[\n" +
                "  { \"id\": 1, \"type\": \"Flight\", \"from\": \"" + fromLocation + "\", \"to\": \"" + toLocation + "\", \"departure\": \"2024-12-01 10:00\", \"duration\": \"2h\", \"price\": \"$200\" },\n" +
                "  { \"id\": 2, \"type\": \"Train\", \"from\": \"" + fromLocation + "\", \"to\": \"" + toLocation + "\", \"departure\": \"2024-12-01 14:00\", \"duration\": \"4h\", \"price\": \"$150\" },\n" +
                "  { \"id\": 3, \"type\": \"Bus\", \"from\": \"" + fromLocation + "\", \"to\": \"" + toLocation + "\", \"departure\": \"2024-12-01 18:00\", \"duration\": \"6h\", \"price\": \"$50\" }\n" +
                "]";
    }
}
