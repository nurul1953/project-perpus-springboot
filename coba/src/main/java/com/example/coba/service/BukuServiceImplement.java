package com.example.coba.service;

import com.example.coba.dto.BukuDto;
import com.example.coba.dto.SearchDto;
import com.example.coba.models.Buku;
import com.example.coba.repositories.BukuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BukuServiceImplement implements BukuService {
    @Autowired
    BukuRepository bukuRepository;

    @Override
    public Buku insertBuku(BukuDto bukuDto) {
        Buku model = new Buku();
        Buku result = new Buku();
        try{
            model.setJudul(bukuDto.getJudul());
            model.setPengarang(bukuDto.getPengarang());
            model.setJenis(bukuDto.getJenis());
            model.setPenerbit(bukuDto.getPenerbit());
            result = bukuRepository.save(model);
        }catch (Exception e){
            e.printStackTrace();
        }return  result;
    }

    @Override
    public BukuDto getBukuById(int id) {
        Buku model = bukuRepository.getById(id);
        BukuDto dto = new BukuDto();
        dto.setId(model.getId());
        dto.setJudul(model.getJudul());
        dto.setPengarang(model.getPengarang());
        dto.setJenis(model.getJenis());
        dto.setPenerbit(model.getPenerbit());
        return dto;
    }

    @Override
    public Buku updateBuku(BukuDto bukuDto) {
        Buku model = new Buku();
        Buku result = new Buku();
        try{
            model.setId(bukuDto.getId());
            model.setJudul(bukuDto.getJudul());
            model.setPengarang(bukuDto.getPengarang());
            model.setJenis(bukuDto.getJenis());
            model.setPenerbit(bukuDto.getPenerbit());
            result = bukuRepository.save(model);
        }catch (Exception e){
            e.printStackTrace();
        }return result;
    }

    @Override
    public boolean deleteBuku(int id) {
        Buku model = bukuRepository.getById(id);
        bukuRepository.delete(model);
        return true;
    }

    @Override
    public List<Buku> searchBuku(SearchDto searchDto) {
        List<Buku> list = bukuRepository.getBuku(searchDto.getCari());
        return list;
    }
}
