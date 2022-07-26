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
@Table(name = "buku")
public class Buku {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
    private Integer id;

    @Column(name = "judul")
    private String judul;

    @Column(name = "pengarang")
    private String pengarang;

    @Column(name = "jenis")
    private String jenis;

    @Column(name = "penerbit")
    private String penerbit;

    public Integer getId() {
        return id;
    }
}
