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
@Table(name = "anggota")
public class Anggota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
    private Integer id;

    @Column(name = "nama")
    private String nama;

    @Column(name = "alamat")
    private String alamat;

    @Column(name = "tempat")
    private String tempat;

    @Column(name = "tgl_lahir")
    private String tgl_lahir;

    @Column(name = "status")
    private String status;

    public Integer getId() {
        return id;
    }
}
