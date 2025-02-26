package com.perpustakaan.beperpustakaan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perpustakaan.beperpustakaan.entity.Users;
import com.perpustakaan.beperpustakaan.entity.Roles;

public interface UsersRespository extends JpaRepository<Users,String>{
    List<Users> findByRoles(Roles roles);
}
