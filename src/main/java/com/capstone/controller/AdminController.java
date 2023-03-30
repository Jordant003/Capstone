package com.capstone.controller;

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
import com.capstone.service.AdminService;

@RestController
@RequestMapping(value ="/admin")
@CrossOrigin("*")
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping(
        value = "/signUp",
        consumes = MediaType.APPLICATION_JSON_VALUE, 
        produces = MediaType.APPLICATION_JSON_VALUE, 
        method = RequestMethod.POST
    )

    public ResponseEntity<Object> signUp(@RequestBody Admin admin) {

        try {

            admin = adminService.save(admin);

            return new ResponseEntity<>(admin, HttpStatus.CREATED);
            
        } catch (Exception e) {

            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            
        } catch (Error e) {

            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }
        
    }

    @RequestMapping(
        value = "/login",
        consumes = MediaType.APPLICATION_JSON_VALUE, 
        produces = MediaType.APPLICATION_JSON_VALUE, 
        method = RequestMethod.POST
    )

    public ResponseEntity<Object> login(@RequestBody Admin admin) {

        try {

           Admin loggedInAdmin = adminService.login(admin);

            return new ResponseEntity<>(loggedInAdmin, HttpStatus.OK);
            
        } catch (Exception e) {

            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            
        } catch (Error e) {

            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }
        
    }

    @RequestMapping(
        value = "/getAdminByEmail/{email}",
        produces = MediaType.APPLICATION_JSON_VALUE, 
        method = RequestMethod.GET
    )

    public ResponseEntity<Object> getAdminByEmail(@PathVariable String email) {

        try {

            Admin admin = adminService.getAdminByEmail(email);

            return new ResponseEntity<>(admin, HttpStatus.OK);
            
        } catch (Exception e) {

            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            
        } catch (Error e) {

            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }
        
    }

    @RequestMapping(
        value = "/update",
        consumes = MediaType.APPLICATION_JSON_VALUE, 
        produces = MediaType.APPLICATION_JSON_VALUE, 
        method = RequestMethod.POST
    )

    public ResponseEntity<Object> getAdminByEmail(@RequestBody Admin admin) {

        try {

            admin = adminService.updateAdmin(admin);

            return new ResponseEntity<>(admin, HttpStatus.OK);
            
        } catch (Exception e) {

            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            
        } catch (Error e) {

            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }
        
    }

    @RequestMapping(
        value = "/delete/{adminId}",
        method = RequestMethod.DELETE
    )

    public ResponseEntity<Object> deleteAdminById(@PathVariable Integer adminId) {

        try {

            adminService.deleteAdminById(adminId);

            return new ResponseEntity<>(HttpStatus.OK);
            
        } catch (Exception e) {

            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            
        } catch (Error e) {

            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }
        
    }

    
}
