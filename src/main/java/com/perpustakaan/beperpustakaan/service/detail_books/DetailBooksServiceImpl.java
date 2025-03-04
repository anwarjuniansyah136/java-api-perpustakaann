package com.perpustakaan.beperpustakaan.service.detail_books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perpustakaan.beperpustakaan.dto.detail_books.DetailBooksRequestDto;
import com.perpustakaan.beperpustakaan.entity.Books;
import com.perpustakaan.beperpustakaan.entity.DetailBooks;
import com.perpustakaan.beperpustakaan.repository.BooksRepository;

@Service
public class DetailBooksServiceImpl implements DetailBooksService{

    @Autowired
    private BooksRepository booksRepository;

    @Override
    public String addDetail(DetailBooksRequestDto dto) {
        Books books = booksRepository.getReferenceById(dto.getIdBooks());
        DetailBooks detailBooks = new DetailBooks();
        detailBooks.setBooks(books);
        return "success";
    }
    
}
