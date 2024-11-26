package com.TripPlanning.TripBackend.Service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
public class TransportService {
    public List<TransportOption> gettransport (String tolocation){
        return Arrays.asList(new TransportOption("fight", "2024-11-13T10:00", "2024-11-13T12:00", "2hrs", "2570" ),(
                new TransportOption("Train", "2024-11-13T4:00","2024-11-14T18:00","26hrs","720")
        ));
    }
}
