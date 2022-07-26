package com.example.coba.service;

import com.example.coba.models.Admin;

public interface LoginService {
    public Admin login(String username, String password);
}
