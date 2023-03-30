package com.capstone.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capstone.entity.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer>{
    

    @Query(value = "select * from admin where email = ?1 && password = ?2", nativeQuery = true)
    public Admin login(String email, String password);

    @Query(value = "select * from admin where email = ?1", nativeQuery = true)
    public Admin getAdminByEmail(String email);
}
