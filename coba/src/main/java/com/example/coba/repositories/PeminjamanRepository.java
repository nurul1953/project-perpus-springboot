package com.example.coba.repositories;

import com.example.coba.models.Buku;
import com.example.coba.models.Peminjaman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeminjamanRepository extends JpaRepository<Peminjaman, Integer> {
    @Query("from Peminjaman ")
    public List<Peminjaman> getPeminjaman();

    @Query(value = "select * from Peminjaman where id like %:cariParam% or tgl_pinjam like %:cariParam% or jumlah like %:cariParam% or tgl_kembali like %:cariParam% or id_anggota like %:cariParam% or id_buku like %:cariParam%", nativeQuery = true)
    public List<Peminjaman> getPeminjaman(@Param("cariParam") String cari);
}
