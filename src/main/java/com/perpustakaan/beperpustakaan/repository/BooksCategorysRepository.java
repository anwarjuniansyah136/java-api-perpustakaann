package com.perpustakaan.beperpustakaan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perpustakaan.beperpustakaan.entity.Books;
import com.perpustakaan.beperpustakaan.entity.BooksCategorys;

public interface BooksCategorysRepository extends JpaRepository<BooksCategorys,String>{

    List<BooksCategorys> findByBooks(Books books);
    
}
