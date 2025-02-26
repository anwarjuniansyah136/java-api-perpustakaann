package com.perpustakaan.beperpustakaan.entity;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "categorys")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categorys {
    @Id
    @UuidGenerator
    @Column(name = "id",length = 36,nullable = false)
    private String id;

    @Column(name = "category_name")
    private String categoryName;
}