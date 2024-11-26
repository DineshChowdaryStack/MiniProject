package com.TripPlanning.TripBackend.Service;

import com.TripPlanning.TripBackend.Entity.Announcement;

import java.util.List;

public interface AnnouncementService {
    public Announcement addannoucement(Announcement annoucement);
    public List<Announcement> getAllAnnoucements();
    public void deletebyid (Long id);
    public Announcement getAnnouncementByIdAndDate(Long id, String date);
}
