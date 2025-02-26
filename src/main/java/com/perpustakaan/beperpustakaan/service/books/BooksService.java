package com.perpustakaan.beperpustakaan.service.books;

import java.util.List;

import com.perpustakaan.beperpustakaan.dto.books.BooksRequestDto;

public interface BooksService {
    public String addBook(BooksRequestDto dto,List<String> idCategorys);
}
