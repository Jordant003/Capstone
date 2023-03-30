package com.capstone.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capstone.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

    @Query(value = "select * from user where email = ?1 && password = ?2", nativeQuery = true)
    public User login(String email, String password);

    @Query(value = "select * from user where email = ?1", nativeQuery = true)
    public User getUserByEmail(String email);

    @Query(value = "select * from user where id = ?1", nativeQuery = true)
    public User findUserById(Integer id);

    @Query(value = "select * from user where lat = ?1 && lat = ?2", nativeQuery = true)
    public User getUserLngLat(Double lng, Double lat);
    
}
