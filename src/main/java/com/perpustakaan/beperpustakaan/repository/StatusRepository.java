package com.perpustakaan.beperpustakaan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perpustakaan.beperpustakaan.entity.Status;

public interface StatusRepository extends JpaRepository<Status,String> {

    Status findByDescription(String string);
    
}
