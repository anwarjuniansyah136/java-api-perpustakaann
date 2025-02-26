package com.perpustakaan.beperpustakaan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perpustakaan.beperpustakaan.entity.Books;

public interface BooksRepository extends JpaRepository<Books,String>{
    
}
