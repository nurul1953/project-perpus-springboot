package com.example.coba.repositories;


import com.example.coba.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Admin findAdminByUsernameAndPassword(String username, String password);

    @Query(value = "select * from Admin where id like %:cariParam% or nama like %:cariParam% or email like %:cariParam% or username like %:cariParam% or password like %:cariParam%", nativeQuery = true)
    public List<Admin> getAdmin(@Param("cariParam") String cari);

    @Query("from Admin")
    public List<Admin> getAdmin();
}
