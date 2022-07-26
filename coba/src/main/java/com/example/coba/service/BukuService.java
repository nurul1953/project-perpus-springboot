package com.example.coba.service;

import com.example.coba.dto.BukuDto;
import com.example.coba.dto.SearchDto;
import com.example.coba.models.Buku;

import java.util.List;

public interface BukuService {
    public Buku insertBuku(BukuDto bukuDto);
    public BukuDto getBukuById(int id);
    public Buku updateBuku(BukuDto bukuDto);
    public boolean deleteBuku(int id);
    List<Buku> searchBuku(SearchDto searchDto);
}
