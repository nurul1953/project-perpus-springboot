package com.example.coba.controller;

import com.example.coba.dto.PeminjamanDto;
import com.example.coba.dto.SearchDto;
import com.example.coba.models.Anggota;
import com.example.coba.models.Buku;
import com.example.coba.models.Peminjaman;
import com.example.coba.repositories.AnggotaRepository;
import com.example.coba.repositories.BukuRepository;
import com.example.coba.repositories.PeminjamanRepository;
import com.example.coba.service.PeminjamanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class PeminjamanController {
    @Autowired
    private PeminjamanRepository peminjamanRepository;

    @Autowired
    private PeminjamanService peminjamanService;

    @Autowired
    private AnggotaRepository anggotaRepository;

    @Autowired
    private BukuRepository bukuRepository;

    List<Peminjaman> peminjaman = null;
    List<Anggota> anggota = null;
    List<Buku> buku = null;
    PeminjamanDto peminjamanDto = new PeminjamanDto();
    Peminjaman result = null;
    SearchDto cari = new SearchDto();

    @GetMapping("/getPeminjaman")
    public String getPeminjaman(Model model) throws Exception{
        peminjaman = peminjamanRepository.getPeminjaman();
        model.addAttribute("Peminjaman",peminjaman);
        model.addAttribute("PeminjamanDto",peminjamanDto);
        model.addAttribute("cari", cari);
        return "tabelPeminjaman";
    }

    @RequestMapping(value = "/insertPeminjaman", method = RequestMethod.GET)
    public String insertData(ModelMap model) throws Exception{
        anggota = anggotaRepository.getAnggota();
        buku = bukuRepository.getBuku();
        model.addAttribute("peminjamanDto", peminjamanDto);
        model.addAttribute("anggota", anggota);
        model.addAttribute("buku", buku);
        return "tambahPeminjaman";
    }
    @RequestMapping(value = "/savePeminjaman", method = RequestMethod.POST)
    public String insertPeminjaman(PeminjamanDto peminjamanDto) throws Exception{
        result = peminjamanService.insertPeminjaman(peminjamanDto);
        return "redirect:/getPeminjaman";
    }

    @RequestMapping(value = "/updatePeminjaman", method = RequestMethod.GET)
    public String updatePeminjaman(ModelMap modelMap, int id) throws Exception{
        peminjamanDto = peminjamanService.getPeminjamanById(id);
        anggota = anggotaRepository.getAnggota();
        buku = bukuRepository.getBuku();
        modelMap.addAttribute("peminjamanDto", peminjamanDto);
        modelMap.addAttribute("anggota", anggota);
        modelMap.addAttribute("buku", buku);
        return "ubahPeminjaman";
    }
    @RequestMapping(value = "/saveUpdatePeminjaman", method = RequestMethod.POST)
    public String updatePeminjaman(PeminjamanDto peminjamanDto) throws Exception{
        result = peminjamanService.updatePeminjaman(peminjamanDto);
        return "redirect:/getPeminjaman";
    }

    @RequestMapping(value = "/deletePeminjaman")
    public String deleteBuku(int id){
        peminjamanService.deletePeminjaman(id);
        return "redirect:/getPeminjaman";
    }

    @RequestMapping(value = "/searchPeminjaman", method = RequestMethod.POST)
    public  String searchPeminjaman(SearchDto search, ModelMap model) throws Exception{
        peminjaman = peminjamanService.searchPeminjaman(search);
        model.addAttribute("Peminjaman", peminjaman);
        model.addAttribute("cari", cari);
        return "tabelPeminjaman";
    }
}