package com.TripPlanning.TripBackend.Service;

import com.TripPlanning.TripBackend.Entity.Faculty;
import com.TripPlanning.TripBackend.Repository.FacultyRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class FacultyService {
    @Autowired
    private FacultyRepository facultyRepository;

    public Faculty addfaculty(Faculty faculty){
        return facultyRepository.save(faculty);
    }
    public Optional<Faculty> getfaultyById(Integer id){
        return facultyRepository.findById(id);
    }
}
