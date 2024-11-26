package com.TripPlanning.TripBackend.Repository;

import com.TripPlanning.TripBackend.Entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends JpaRepository<  Trip, Integer> {
}
