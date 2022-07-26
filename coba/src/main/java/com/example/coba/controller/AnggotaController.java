package com.example.coba.controller;

import com.example.coba.dto.AnggotaDto;
import com.example.coba.dto.SearchDto;
import com.example.coba.models.Anggota;
import com.example.coba.repositories.AnggotaRepository;
import com.example.coba.service.AnggotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AnggotaController {
    @Autowired
    private AnggotaRepository anggotaRepository;

    @Autowired
    private AnggotaService anggotaService;

    List<Anggota> anggota = null;
    AnggotaDto anggotaDto = new AnggotaDto();
    Anggota result = null;
    SearchDto cari = new SearchDto();

    @GetMapping("/getAnggota")
    public String getAnggota(Model model) throws Exception{
        anggota = anggotaRepository.getAnggota();
        model.addAttribute("Anggota",anggota);
        model.addAttribute("AnggotaDto",anggotaDto);
        model.addAttribute("cari", cari);
        return "tabelAnggota";
    }

    @RequestMapping(value = "/insertAnggota", method = RequestMethod.GET)
    public String insertData(ModelMap model) throws Exception{
        model.addAttribute("anggotaDto", anggotaDto);
        return "tambahAnggota";
    }
    @RequestMapping(value = "/saveAnggota", method = RequestMethod.POST)
    public String insertAnggota(AnggotaDto anggotaDto) throws Exception{
        result = anggotaService.insertAnggota(anggotaDto);
        return "redirect:/getAnggota";
    }

    @RequestMapping(value = "/updateAnggota", method = RequestMethod.GET)
    public String updateAnggota(ModelMap modelMap, int id) throws Exception{
        anggotaDto = anggotaService.getAnggotaById(id);
        modelMap.addAttribute("anggotaDto", anggotaDto);
        return "ubahAnggota";
    }
    @RequestMapping(value = "/saveUpdateAnggota", method = RequestMethod.POST)
    public String updateAnggota(AnggotaDto anggotaDto) throws Exception{
        result = anggotaService.updateAnggota(anggotaDto);
        return "redirect:/getAnggota";
    }

    @RequestMapping(value = "/deleteAnggota")
    public String deleteAnggota(int id){
        anggotaService.deleteAnggota(id);
        return "redirect:/getAnggota";
    }

    @RequestMapping(value = "/searchAnggota", method = RequestMethod.POST)
    public  String searchAnggota(SearchDto search, ModelMap model) throws Exception{
        anggota = anggotaService.searchAnggota(search);
        model.addAttribute("Anggota", anggota);
        model.addAttribute("cari", cari);
        return "tabelAnggota";
    }
}
