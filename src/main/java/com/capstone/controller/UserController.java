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

import com.capstone.entity.User;
import com.capstone.service.UserService;

@RestController
@RequestMapping(value ="/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(
        value = "/signUp",
        consumes = MediaType.APPLICATION_JSON_VALUE, 
        produces = MediaType.APPLICATION_JSON_VALUE, 
        method = RequestMethod.POST
    )

    public ResponseEntity<Object> signUp(@RequestBody User user) {

        try {

            user = userService.save(user);

            return new ResponseEntity<>(user, HttpStatus.CREATED);
            
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

    public ResponseEntity<Object> login(@RequestBody User user) {

        try {

           User loggedInUser = userService.login(user);

            return new ResponseEntity<>(loggedInUser, HttpStatus.OK);
            
        } catch (Exception e) {

            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            
        } catch (Error e) {

            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }
        
    }

    @RequestMapping(
        value = "/getUserByEmail/{email}",
        produces = MediaType.APPLICATION_JSON_VALUE, 
        method = RequestMethod.GET
    )

    public ResponseEntity<Object> getUserByEmail(@PathVariable String email) {

        try {

            User user = userService.getUserByEmail(email);

            return new ResponseEntity<>(user, HttpStatus.OK);
            
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

    public ResponseEntity<Object> getUserByEmail(@RequestBody User user) {

        try {

            user = userService.updateUser(user);

            return new ResponseEntity<>(user, HttpStatus.OK);
            
        } catch (Exception e) {

            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            
        } catch (Error e) {

            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }
        
    }

    @RequestMapping(
        value = "/delete/{userId}",
        method = RequestMethod.DELETE
    )

    public ResponseEntity<Object> deleteUserById(@PathVariable Integer userId) {

        try {

            userService.deleteUserById(userId);

            return new ResponseEntity<>(HttpStatus.OK);
            
        } catch (Exception e) {

            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            
        } catch (Error e) {

            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }
        
    }

    @RequestMapping(
        value = "/findUserById/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE, 
        method = RequestMethod.GET
    )

    public ResponseEntity<Object> findUserById(@PathVariable Integer id) {

        try {

            User user = userService.findUserById(id);

            return new ResponseEntity<>(user, HttpStatus.OK);
            
        } catch (Exception e) {

            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            
        } catch (Error e) {

            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @RequestMapping(
        value = "/getUserLngLat/{lng}{lat}",
        produces = MediaType.APPLICATION_JSON_VALUE, 
        method = RequestMethod.GET
    )

    public ResponseEntity<Object> getUserLngLat(@PathVariable Double lng, @PathVariable Double lat) {

        try {

            User user = userService.getUserLngLat(lng, lat);

            return new ResponseEntity<>(user, HttpStatus.OK);
            
        } catch (Exception e) {

            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            
        } catch (Error e) {

            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }
        
    }

    
}
