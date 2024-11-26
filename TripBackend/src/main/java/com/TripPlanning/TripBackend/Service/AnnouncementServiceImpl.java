package com.TripPlanning.TripBackend.Service;

import com.TripPlanning.TripBackend.Entity.Announcement;
import com.TripPlanning.TripBackend.Repository.AnnouncementRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AnnouncementServiceImpl implements AnnouncementService{
    @Autowired
    private AnnouncementRepository announcementRepository;
    @Override
    public Announcement addannoucement(Announcement annoucement) {
        return announcementRepository.save(annoucement);
    }
    @Override
    public List<Announcement> getAllAnnoucements() {
        return announcementRepository.findAll();
    }

    @Override
    public void deletebyid(Long id) {
        announcementRepository.deleteById(id);
    }

    @Override
    public Announcement getAnnouncementByIdAndDate(Long id, String date) {
        return announcementRepository.findByIdAndDate(id, date);
    }


}
