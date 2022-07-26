package com.example.coba.service;

import com.example.coba.dto.PeminjamanDto;
import com.example.coba.dto.SearchDto;
import com.example.coba.models.Peminjaman;

import java.util.List;

public interface PeminjamanService {
    public Peminjaman insertPeminjaman(PeminjamanDto peminjamanDto);
    public PeminjamanDto getPeminjamanById(int id);
    public Peminjaman updatePeminjaman(PeminjamanDto peminjamanDto);
    public boolean deletePeminjaman(int id);
    List<Peminjaman> searchPeminjaman(SearchDto searchDto);
}
