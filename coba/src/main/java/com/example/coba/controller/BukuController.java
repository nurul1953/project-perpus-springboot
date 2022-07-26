package com.example.coba.controller;

import com.example.coba.dto.BukuDto;
import com.example.coba.dto.SearchDto;
import com.example.coba.models.Buku;
import com.example.coba.repositories.BukuRepository;
import com.example.coba.service.BukuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class BukuController {
    @Autowired
    private BukuRepository bukuRepository;

    @Autowired
    private BukuService bukuService;

    List<Buku> buku = null;
    BukuDto bukuDto = new BukuDto();
    Buku result = null;
    SearchDto cari = new SearchDto();

    @GetMapping("/getBuku")
    public String getBuku(Model model) throws Exception{
        buku = bukuRepository.getBuku();
        model.addAttribute("Buku",buku);
        model.addAttribute("BukuDto",bukuDto);
        model.addAttribute("cari", cari);
//        return "buku";
        return "tabelBuku";
    }

    @RequestMapping(value = "/insertBuku", method = RequestMethod.GET)
    public String insertData(ModelMap model) throws Exception{
        model.addAttribute("bukuDto", bukuDto);
        return "tambahBuku";
    }
    @RequestMapping(value = "/saveBuku", method = RequestMethod.POST)
    public String insertBuku(BukuDto bukuDto) throws Exception{
        result = bukuService.insertBuku(bukuDto);
        return "redirect:/getBuku";
    }

    @RequestMapping(value = "/updateBuku", method = RequestMethod.GET)
    public String updateBuku(ModelMap modelMap, int id) throws Exception{
        bukuDto = bukuService.getBukuById(id);
        modelMap.addAttribute("bukuDto", bukuDto);
        return "ubahBuku";
    }
    @RequestMapping(value = "/saveUpdateBuku", method = RequestMethod.POST)
    public String updateBuku(BukuDto bukuDto) throws Exception{
        result = bukuService.updateBuku(bukuDto);
        return "redirect:/getBuku";
    }

    @RequestMapping(value = "/deleteBuku")
    public String deleteBuku(int id){
        bukuService.deleteBuku(id);
        return "redirect:/getBuku";
    }

    @RequestMapping(value = "/searchBuku", method = RequestMethod.POST)
    public  String searchBuku(SearchDto search, ModelMap model) throws Exception{
        buku = bukuService.searchBuku(search);
        model.addAttribute("Buku", buku);
        model.addAttribute("cari", cari);
        return "tabelBuku";
    }
}