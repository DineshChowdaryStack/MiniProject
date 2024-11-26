package com.TripPlanning.TripBackend.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransportOption {
    private String type;
    private String depaturetime;
    private String arrivaltime;
    private String duration;
    private String price;
}
