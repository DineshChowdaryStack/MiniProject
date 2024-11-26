package com.TripPlanning.TripBackend.Repository;

import com.TripPlanning.TripBackend.Entity.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
    @Query("SELECT a FROM Announcement a WHERE a.id = :id AND a.date = :date")
    Announcement findByIdAndDate(@Param("id") Long id, @Param("date") String date);
}
