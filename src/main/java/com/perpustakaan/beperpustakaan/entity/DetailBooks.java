package com.perpustakaan.beperpustakaan.entity;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "detail_books")
@Entity
public class DetailBooks {
    @Id
    @UuidGenerator
    @Column(name = "id",length = 36,nullable = false)
    private String id;
    
    @ManyToOne
    @JoinColumn(name = "books_id",referencedColumnName = "id")
    private Books books;

    @Column(name = "peminjaman")
    private String peminjaman;

    @Column(name = "pengembalian")
    private String pengembalian;

    @Column(name = "batas_pengembalian")
    private String batasPengembalian;
}