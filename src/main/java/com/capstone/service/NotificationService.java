package com.capstone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.entity.Notification;
import com.capstone.repo.NotificationRepo;

@Service
public class NotificationService {

    @Autowired
    NotificationRepo notificationRepo;

    public Notification save(Notification notification) {

        return notificationRepo.save(notification);
    }

    public Notification findNotificationById(Integer id) {

        return notificationRepo.findById(id).get();
    }

    public Notification updateNotification(Notification notification) throws Exception {

        if (notification.getId() != null || findNotificationById(notification.getId()) != null) {

            return save(notification);

        }

        throw new Exception("Must have existing ID");

    }

    public List<Notification> findAll() {

        return notificationRepo.findAll();

    }

    public void deleteById(Integer id) {

    notificationRepo.deleteById(id);

    }

}
    
