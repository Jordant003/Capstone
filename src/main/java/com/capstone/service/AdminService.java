package com.capstone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.entity.Admin;
import com.capstone.entity.Notification;
import com.capstone.repo.AdminRepo;

@Service
public class AdminService {

    @Autowired
    AdminRepo adminRepo;

    public Admin save(Admin admin) {

        return adminRepo.save(admin);
    }

    public Admin findAdminById(Integer id) {

        return adminRepo.findById(id).get();
    }

    public Admin updateAdmin(Admin admin) throws Exception {

        if (admin.getId() != null || findAdminById(admin.getId()) != null) {

            return save(admin);

        }

        throw new Exception("Must have existing ID");

    }

    public Admin login(Admin admin) throws Exception {

        admin = adminRepo.login(admin.getEmail(), admin.getPassword());

        if (admin != null) {
            return admin;
        }

        throw new Exception("Email or password incorrect. Try again");

    }

    public Admin getAdminByEmail(String email) throws Exception {

        Admin admin = adminRepo.getAdminByEmail(email);

        if (admin != null) {
            return admin;
        }

        throw new Exception("Email did not exist. Login");
    }

    public void deleteAdminById(Integer id) {

        adminRepo.deleteById(id);

    }

    public void addNotication(Notification notification) {

        List<Admin> admins = adminRepo.findAll();

        for (Admin admin : admins) {
            admin.getNotification().add(notification);
            save(admin);
        }

    }

    public void deleteNotification(Admin admin, Notification notification) {

        admin.getNotification().remove(notification);

        save(admin);

    }

}
