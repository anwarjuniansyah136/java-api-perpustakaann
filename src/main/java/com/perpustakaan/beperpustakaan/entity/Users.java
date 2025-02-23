package com.perpustakaan.beperpustakaan.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    @Id
    @Column(name = "id",length = 36,nullable = false)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "roles_id",referencedColumnName = "id")
    private Roles roles;
}