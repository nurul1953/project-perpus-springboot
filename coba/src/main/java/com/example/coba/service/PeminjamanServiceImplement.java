package com.example.coba.service;

import com.example.coba.dto.PeminjamanDto;
import com.example.coba.dto.SearchDto;
import com.example.coba.models.Peminjaman;
import com.example.coba.repositories.PeminjamanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeminjamanServiceImplement implements PeminjamanService{
    @Autowired
    PeminjamanRepository peminjamanRepository;

    @Override
    public Peminjaman insertPeminjaman(PeminjamanDto peminjamanDto) {
        Peminjaman model = new Peminjaman();
        Peminjaman result = new Peminjaman();
        try{
            model.setTgl_pinjam(peminjamanDto.getTgl_pinjam());
            model.setJumlah(peminjamanDto.getJumlah());
            model.setTgl_kembali(peminjamanDto.getTgl_kembali());
            model.setId_anggota(peminjamanDto.getId_anggota());
            model.setId_buku(peminjamanDto.getId_buku());
            result = peminjamanRepository.save(model);
        }catch (Exception e){
            e.printStackTrace();
        }return  result;
    }

    @Override
    public PeminjamanDto getPeminjamanById(int id) {
        Peminjaman model = peminjamanRepository.getById(id);
        PeminjamanDto dto = new PeminjamanDto();
        dto.setId(model.getId());
        dto.setTgl_pinjam(model.getTgl_pinjam());
        dto.setJumlah(model.getJumlah());
        dto.setTgl_kembali(model.getTgl_kembali());
        dto.setId_anggota(model.getId_anggota());
        dto.setId_buku(model.getId_buku());
        return dto;
    }

    @Override
    public Peminjaman updatePeminjaman(PeminjamanDto peminjamanDto) {
        Peminjaman model = new Peminjaman();
        Peminjaman result = new Peminjaman();
        try{
            model.setId(peminjamanDto.getId());
            model.setTgl_pinjam(peminjamanDto.getTgl_pinjam());
            model.setJumlah(peminjamanDto.getJumlah());
            model.setTgl_kembali(peminjamanDto.getTgl_kembali());
            model.setId_anggota(peminjamanDto.getId_anggota());
            model.setId_buku(peminjamanDto.getId_buku());
            result = peminjamanRepository.save(model);
        }catch (Exception e){
            e.printStackTrace();
        }return  result;
    }

    @Override
    public boolean deletePeminjaman(int id) {
        Peminjaman model = peminjamanRepository.getById(id);
        peminjamanRepository.delete(model);
        return true;
    }

    @Override
    public List<Peminjaman> searchPeminjaman(SearchDto searchDto) {
        List<Peminjaman> list = peminjamanRepository.getPeminjaman(searchDto.getCari());
        return list;
    }
}
