package com.example.coba.service;

import com.example.coba.dto.AnggotaDto;
import com.example.coba.dto.SearchDto;
import com.example.coba.models.Anggota;

import java.util.List;

public interface AnggotaService {
    public Anggota insertAnggota(AnggotaDto anggotaDto);
    public AnggotaDto getAnggotaById(int id);
    public Anggota updateAnggota(AnggotaDto anggotaDto);
    public boolean deleteAnggota(int id);
    List<Anggota> searchAnggota(SearchDto searchDto);
}
