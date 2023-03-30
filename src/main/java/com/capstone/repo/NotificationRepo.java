package com.capstone.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.entity.Notification;

@Repository
public interface NotificationRepo extends JpaRepository<Notification, Integer>{
    
}
