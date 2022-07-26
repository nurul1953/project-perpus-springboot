package com.example.coba.controller;

import com.example.coba.dto.AdminDto;
import com.example.coba.dto.SearchDto;
import com.example.coba.models.Admin;
import com.example.coba.repositories.AdminRepository;
import com.example.coba.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
            private AdminRepository adminRepository;
    @Autowired
            private AdminService adminService;

    List<Admin> admin = null;
    AdminDto adminDto = new AdminDto();
    Admin result = null;
    SearchDto cari = new SearchDto();

    @GetMapping("/getAdmin")
    public String getAdmin(Model model) throws Exception{
        admin = adminRepository.getAdmin();
        model.addAttribute("Admin",admin);
        model.addAttribute("AdminDto",adminDto);
        model.addAttribute("cari", cari);
        return "tabelAdmin";
    }

//    @RequestMapping(value = "/insertAdmin", method = RequestMethod.GET)
//    public String insertData(ModelMap model) throws Exception{
//        model.addAttribute("adminDto", adminDto);
////        return "insertAdm";
//        return "tambahAdmin";
//    }
//
//    @RequestMapping(value = "/saveAdmin", method = RequestMethod.POST)
//    public String InsertAdmin(AdminDto adminDto, ModelMap model) throws Exception{
//        result = adminService.insertAdmin(adminDto);
//        return "redirect:/login";
//    }

    @RequestMapping(value = "/deleteAdmin")
    public String deleteAdmin(int id){
        adminService.deleteAdmin(id);
        return "redirect:/login";
    }

    @RequestMapping(value = "/searchAdmin", method = RequestMethod.POST)
    public  String searchAdmin(SearchDto search, ModelMap model) throws Exception{
        admin = adminService.searchAdmin(search);
        model.addAttribute("Admin", admin);
        model.addAttribute("cari", cari);
        return "tabelAdmin";
    }
}
