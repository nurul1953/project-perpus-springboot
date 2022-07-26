package com.example.coba.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "peminjaman")
public class Peminjaman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
    private Integer id;

    @Column(name = "tgl_pinjam")
    private String tgl_pinjam;

    @Column(name = "jumlah")
    private Integer jumlah;

    @Column(name = "tgl_kembali")
    private String tgl_kembali;

    @Column(name = "id_anggota")
    private Integer id_anggota;

    @Column(name = "id_buku")
    private Integer id_buku;

    public Integer getId() {
        return id;
    }
}
