package com.TripPlanning.TripBackend.Service;

import com.TripPlanning.TripBackend.Entity.CollegeMap;

import java.util.List;

public interface CollegeMapService {
    public CollegeMap addMap(CollegeMap collegeMap);
    public List<CollegeMap> getAllMap();
}
