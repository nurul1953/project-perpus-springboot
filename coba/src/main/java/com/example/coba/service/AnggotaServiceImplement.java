package com.example.coba.service;

import com.example.coba.dto.AnggotaDto;
import com.example.coba.dto.SearchDto;
import com.example.coba.models.Anggota;
import com.example.coba.repositories.AnggotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnggotaServiceImplement implements AnggotaService{
    @Autowired
    AnggotaRepository anggotaRepository;

    @Override
    public Anggota insertAnggota(AnggotaDto anggotaDto) {
        Anggota model = new Anggota();
        Anggota result = new Anggota();
        try{
            model.setNama(anggotaDto.getNama());
            model.setAlamat(anggotaDto.getAlamat());
            model.setTempat(anggotaDto.getTempat());
            model.setTgl_lahir(anggotaDto.getTgl_lahir());
            model.setStatus(anggotaDto.getStatus());
            result = anggotaRepository.save(model);
        }catch (Exception e){
            e.printStackTrace();
        }return  result;
    }

    @Override
    public AnggotaDto getAnggotaById(int id) {
        Anggota model = anggotaRepository.getById(id);
        AnggotaDto dto = new AnggotaDto();
        dto.setId(model.getId());
        dto.setNama(model.getNama());
        dto.setAlamat(model.getAlamat());
        dto.setTempat(model.getTempat());
        dto.setTgl_lahir(model.getTgl_lahir());
        dto.setStatus(model.getStatus());
        return dto;
    }

    @Override
    public Anggota updateAnggota(AnggotaDto anggotaDto) {
        Anggota model = new Anggota();
        Anggota result = new Anggota();
        try{
            model.setId(anggotaDto.getId());
            model.setNama(anggotaDto.getNama());
            model.setAlamat(anggotaDto.getAlamat());
            model.setTempat(anggotaDto.getTempat());
            model.setTgl_lahir(anggotaDto.getTgl_lahir());
            model.setStatus(anggotaDto.getStatus());
            result = anggotaRepository.save(model);
        }catch (Exception e){
            e.printStackTrace();
        }return  result;
    }

    @Override
    public boolean deleteAnggota(int id) {
        Anggota model = anggotaRepository.getById(id);
        anggotaRepository.delete(model);
        return true;
    }

    @Override
    public List<Anggota> searchAnggota(SearchDto searchDto) {
        List<Anggota> list = anggotaRepository.getAnggota(searchDto.getCari());
        return list;
    }
}
