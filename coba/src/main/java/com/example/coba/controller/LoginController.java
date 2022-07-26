package com.example.coba.controller;

import com.example.coba.dto.AdminDto;
import com.example.coba.dto.BukuDto;
import com.example.coba.dto.SearchDto;
import com.example.coba.models.Admin;
import com.example.coba.models.Buku;
import com.example.coba.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;

@Controller
public class LoginController {
    @Autowired
    LoginService loginService;

    @RequestMapping("/login")
    public ModelAndView login(){
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("admin",new Admin());
        return mav;
    }

    @PostMapping("/cekLogin")
    public String login(@ModelAttribute("admin") Admin admin){
        Admin authadmin = loginService.login(admin.getUsername(), admin.getPassword());
        System.out.println(authadmin);
        if(Objects.nonNull(authadmin))
            return "redirect:/dashboard";
        else
            return "redirect:/login";
    }


}
