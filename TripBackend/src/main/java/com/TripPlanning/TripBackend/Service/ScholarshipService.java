package com.TripPlanning.TripBackend.Service;

import com.TripPlanning.TripBackend.Entity.Scholarship;
import com.TripPlanning.TripBackend.Repository.ScholarshipRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ScholarshipService {
    @Autowired
    private ScholarshipRepository scholarshipRepository;
    public Scholarship addscholarship(Scholarship scholarship){
        return scholarshipRepository.save(scholarship);
    }
    public Optional<Scholarship> getById(Integer id){
        return scholarshipRepository.findById(id);
    }
}
