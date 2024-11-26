package com.TripPlanning.TripBackend.Controller;

import com.TripPlanning.TripBackend.Entity.Faculty;
import com.TripPlanning.TripBackend.Service.FacultyService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping ("/api/faculty")
@AllArgsConstructor
public class FacultyController {
    @Autowired
    private FacultyService facultyService;
    @PostMapping ("/add")
    public ResponseEntity<Faculty> addfaculty(@RequestBody Faculty faculty){
        Faculty faculty1 = facultyService.addfaculty(faculty);
        return new ResponseEntity<>(faculty1, HttpStatus.CREATED);
    }
    @GetMapping ("/{id}")
    public ResponseEntity<Optional<Faculty>> getbyid(@PathVariable Integer id){
        Optional<Faculty> faculty = facultyService.getfaultyById(id);
        return new ResponseEntity<>(faculty, HttpStatus.OK);
    }
}
