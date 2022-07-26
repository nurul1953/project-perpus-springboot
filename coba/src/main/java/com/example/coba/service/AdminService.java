package com.example.coba.service;

import com.example.coba.dto.AdminDto;
import com.example.coba.dto.SearchDto;
import com.example.coba.models.Admin;

import java.util.List;

public interface AdminService {
    public Admin insertAdmin(AdminDto adminDto);
    public AdminDto getAdminById(int id);
    public boolean deleteAdmin(int id);
    List<Admin> searchAdmin(SearchDto searchDto);
}
