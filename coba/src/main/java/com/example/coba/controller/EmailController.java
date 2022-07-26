package com.example.coba.controller;

import com.example.coba.dto.AdminDto;
import com.example.coba.dto.MailRequest;
import com.example.coba.service.AdminService;
import com.example.coba.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmailController {
    @Autowired
    private EmailService emailService;
    @Autowired
    private AdminService adminService;
    AdminDto adminDto = new AdminDto();

    @RequestMapping(value = "/insertAdmin", method = RequestMethod.GET)
    public String insertData(ModelMap model) throws Exception{
        model.addAttribute("adminDto", adminDto);
        return "tambahAdmin";
    }

    @RequestMapping(value = "/saveAdmin", method = RequestMethod.POST)
    public String InsertAdmin(AdminDto adminDto, ModelMap model) throws Exception{
        adminService.insertAdmin(adminDto);
        emailService.sendEmail(adminDto);
        return "redirect:/login";
    }
}
