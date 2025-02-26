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

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "booksCategorys")
public class BooksCategorys {
    @Id
    @UuidGenerator
    @Column(name = "id",length = 36,nullable = false)
    private String id;
    
    @ManyToOne
    @JoinColumn(name = "books_id",referencedColumnName = "id")
    private Books books;

    @ManyToOne
    @JoinColumn(name = "categorys_id",referencedColumnName = "id")
    private Categorys categorys;
}
