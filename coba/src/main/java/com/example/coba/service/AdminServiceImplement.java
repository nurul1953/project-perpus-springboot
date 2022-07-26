package com.example.coba.service;

import com.example.coba.dto.AdminDto;
import com.example.coba.dto.SearchDto;
import com.example.coba.models.Admin;
import com.example.coba.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImplement implements AdminService{
    @Autowired
    AdminRepository adminRepository;

    @Override
    public Admin insertAdmin(AdminDto adminDto) {
        Admin model = new Admin();
        Admin result = new Admin();
        try{
            model.setEmail(adminDto.getEmail());
            model.setNama(adminDto.getNama());
            model.setPassword(adminDto.getPassword());
            model.setUsername(adminDto.getUsername());
            result = adminRepository.save(model);
        }catch (Exception e){
            e.printStackTrace();
        }return result;
    }

    @Override
    public AdminDto getAdminById(int id) {
        Admin model = adminRepository.getById(id);
        AdminDto dto = new AdminDto();
        dto.setId(model.getId());
        dto.setNama(model.getNama());
        dto.setEmail(model.getEmail());
        dto.setPassword(model.getPassword());
        dto.setUsername(model.getUsername());
        return dto;
    }

    @Override
    public boolean deleteAdmin(int id) {
        Admin model = adminRepository.getById(id);
        adminRepository.delete(model);
        return true;
    }

    @Override
    public List<Admin> searchAdmin(SearchDto searchDto) {
        List<Admin> list = adminRepository.getAdmin(searchDto.getCari());
        return list;
    }
}
