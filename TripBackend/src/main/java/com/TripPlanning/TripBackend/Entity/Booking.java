package com.TripPlanning.TripBackend.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String type;
    private String name;
    private String location;
    @Column(name = "check_in_date")
    private String checkInDate;
    @Column(name = "check_out_date")
    private String checkOutDate;
    @ManyToOne
    @JoinColumn(name = "trip_id")
    @JsonBackReference  // This will prevent Jackson from serializing the 'trip' field in the 'Booking' entity
    private Trip trip;
}
