package com.example.coba.repositories;

import com.example.coba.models.Anggota;
import com.example.coba.models.Buku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnggotaRepository extends JpaRepository<Anggota, Integer> {
    @Query("from Anggota ")
    public List<Anggota> getAnggota();

    @Query(value = "select * from Anggota where id like %:cariParam% or nama like %:cariParam% or alamat like %:cariParam% or tempat like %:cariParam% or tgl_lahir like %:cariParam% or status like %:cariParam%", nativeQuery = true)
    public List<Anggota> getAnggota(@Param("cariParam") String cari);
}
