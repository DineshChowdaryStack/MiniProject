package com.TripPlanning.TripBackend.Controller;

import com.TripPlanning.TripBackend.Entity.CollegeMap;
import com.TripPlanning.TripBackend.Service.CollegeMapService;
import lombok.AllArgsConstructor;
import lombok.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping ("/api/college")
public class CollegeMapController {
    @Autowired
    private CollegeMapService collegeMapService;
    @PostMapping ("/addmap")
    public ResponseEntity<CollegeMap> addmap(@RequestBody CollegeMap collegeMap){
        CollegeMap collegeMap1 = collegeMapService.addMap(collegeMap);
        return new ResponseEntity<>(collegeMap1, HttpStatus.OK);
    }
    @GetMapping ("/allmaps")
    public ResponseEntity<List<CollegeMap>> getAllMaps(){
        List<CollegeMap> collegeMap= collegeMapService.getAllMap();
        return new ResponseEntity<>(collegeMap, HttpStatus.OK);
    }
}
