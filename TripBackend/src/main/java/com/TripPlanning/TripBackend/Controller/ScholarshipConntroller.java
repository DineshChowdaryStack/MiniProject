package com.TripPlanning.TripBackend.Controller;

import com.TripPlanning.TripBackend.Entity.Scholarship;
import com.TripPlanning.TripBackend.Service.ScholarshipService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping ("/api/scholarship")
@AllArgsConstructor
public class ScholarshipConntroller {
    @Autowired
    private ScholarshipService scholarshipService;
    @PostMapping  ("/add")
    public ResponseEntity<Scholarship> addscholarship(@RequestBody Scholarship scholarship){
        Scholarship scholarship1 = scholarshipService.addscholarship(scholarship);
        return new ResponseEntity<>(scholarship1, HttpStatus.CREATED);
    }
    @GetMapping ("/{id}")
    public ResponseEntity<Optional<Scholarship>> getbyid(@PathVariable Integer id){
        Optional<Scholarship> scholarship =  scholarshipService.getById(id);
        return new ResponseEntity<>(scholarship,HttpStatus.OK);
    }
}
