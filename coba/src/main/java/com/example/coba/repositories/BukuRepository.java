package com.example.coba.repositories;

import com.example.coba.models.Buku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BukuRepository extends JpaRepository<Buku, Integer> {
    @Query("from Buku")
    public List<Buku> getBuku();

    @Query(value = "select * from Buku where id like %:cariParam% or judul like %:cariParam% or pengarang like %:cariParam% or jenis like %:cariParam% or penerbit like %:cariParam%", nativeQuery = true)
    public List<Buku> getBuku(@Param("cariParam") String cari);
}
