package com.TripPlanning.TripBackend.Controller;

import com.TripPlanning.TripBackend.Entity.Announcement;
import com.TripPlanning.TripBackend.Service.AnnouncementService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/announcement")
@AllArgsConstructor
public class AnnouncementController {
    @Autowired
    public AnnouncementService announcementService;
    @PostMapping ("/add")
    public ResponseEntity<Announcement> addAnnouncement(@RequestBody Announcement annoucement){
        Announcement annoucement1 = announcementService.addannoucement(annoucement);
        return  new ResponseEntity<>(annoucement1, HttpStatus.CREATED);
    }
    @GetMapping("/getall")
    public ResponseEntity<List<Announcement>> getall(){
        List<Announcement> annoucement = announcementService.getAllAnnoucements();
        return new ResponseEntity<>(annoucement, HttpStatus.OK);
    }
    @DeleteMapping ("/delete/{id}")
    public String deleteannouncement(@PathVariable Long id){
        announcementService.deletebyid(id);
        return "Annouuncement deleted sucessfully";
    }
    @GetMapping("/{id}/{date}")
    public ResponseEntity<Announcement> getAnnouncementByIdAndDate(@PathVariable Long id, @PathVariable String date) {
        Announcement announcement = announcementService.getAnnouncementByIdAndDate(id, date);
        if (announcement != null) {
            return new ResponseEntity<>(announcement, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
