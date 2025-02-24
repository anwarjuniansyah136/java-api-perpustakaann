package com.perpustakaan.beperpustakaan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perpustakaan.beperpustakaan.entity.Roles;

public interface RolesRepository extends JpaRepository<Roles,String>{
    Roles findByRolesName(String rolesName);
}
