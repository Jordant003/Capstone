package com.capstone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.entity.Admin;
import com.capstone.entity.Notification;
import com.capstone.service.AdminService;
import com.capstone.service.NotificationService;

@RestController
@RequestMapping("/notification")
@CrossOrigin("*")
public class NotificationController {

    @Autowired
    AdminService adminService;

    @Autowired
    NotificationService notificationService;

    @RequestMapping(
        value = "/create",
        consumes = MediaType.APPLICATION_JSON_VALUE, 
        produces = MediaType.APPLICATION_JSON_VALUE, 
        method = RequestMethod.POST
    )

    public ResponseEntity<Object> create(@RequestBody Notification notification) {

        try {

            notification = notificationService.save(notification);

            adminService.addNotication(notification);

            return new ResponseEntity<>(notification, HttpStatus.CREATED);
            
        } catch (Exception e) {

            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            
        } catch (Error e) {

            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }
        
    }

    @RequestMapping(
        value = "/findAll", 
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = RequestMethod.GET)

        public ResponseEntity<Object> findAll() {

            try {
                
                List<Notification> notification = notificationService.findAll();
    
                return new ResponseEntity<>(notification, HttpStatus.OK);
    
            } catch (Exception e) {
                
                System.out.println(e.getMessage());
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    
            } catch (Error e) {
                
                System.out.println(e.getMessage());
                return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        @RequestMapping(
        value = "/delete/{notificationId}",
        consumes = MediaType.APPLICATION_JSON_VALUE, 
        produces = MediaType.APPLICATION_JSON_VALUE, 
        method = RequestMethod.POST
    )

    public ResponseEntity<Object> deleteById(@PathVariable Integer notificationId, @RequestBody Admin admin) {

        try {

            Notification notification = notificationService.findNotificationById(notificationId);

            adminService.deleteNotification(admin, notification);

            notificationService.deleteById(notificationId);

            return new ResponseEntity<>(admin, HttpStatus.OK);
            
        } catch (Exception e) {

            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            
        } catch (Error e) {

            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }
        
    }
    
}
