package com.TripPlanning.TripBackend.Service;

import com.TripPlanning.TripBackend.Entity.CollegeMap;
import com.TripPlanning.TripBackend.Repository.CollegeMapRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CollegeMapServiceImpl implements CollegeMapService{
    @Autowired
    private CollegeMapRepository  collegeMapRepository;

    @Override
    public CollegeMap addMap(CollegeMap collegeMap) {
        return collegeMapRepository.save(collegeMap);
    }
    @Override
    public List<CollegeMap> getAllMap(){
        return collegeMapRepository.findAll();
    }

}
