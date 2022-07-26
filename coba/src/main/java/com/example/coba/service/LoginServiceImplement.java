package com.example.coba.service;

import com.example.coba.models.Admin;
import com.example.coba.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImplement implements LoginService{

    @Autowired
    AdminRepository adminRepository;

    @Override
    public Admin login(String username, String password) {
        Admin admin = adminRepository.findAdminByUsernameAndPassword(username, password);
        return admin;
    }
}
