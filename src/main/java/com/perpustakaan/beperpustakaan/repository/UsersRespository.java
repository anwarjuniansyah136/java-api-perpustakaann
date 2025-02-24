package com.perpustakaan.beperpustakaan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perpustakaan.beperpustakaan.entity.Users;

public interface UsersRespository extends JpaRepository<Users,String>{
    
}
