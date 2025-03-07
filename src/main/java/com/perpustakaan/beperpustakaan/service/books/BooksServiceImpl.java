package com.perpustakaan.beperpustakaan.service.books;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perpustakaan.beperpustakaan.dto.books.BooksRequestDto;
import com.perpustakaan.beperpustakaan.entity.Books;
import com.perpustakaan.beperpustakaan.entity.Status;
import com.perpustakaan.beperpustakaan.repository.BooksRepository;
import com.perpustakaan.beperpustakaan.repository.StatusRepository;
import com.perpustakaan.beperpustakaan.service.books_categorys.BooksCategorysService;

@Service
public class BooksServiceImpl implements BooksService{

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    private BooksCategorysService booksCategorysService;

    @Override
    public String addBook(BooksRequestDto dto,List<String> idCategorys) {
        Books books = new Books();
        books.setTitle(dto.getTitle());
        books.setAutor(books.getAutor());
        books.setStock(books.getStock());
        Status status = statusRepository.findByDescription("Tersedia");
        books.setStatus(status);
        booksRepository.save(books);
        booksCategorysService.add(books.getId(), idCategorys);
        return "success";
    }

    @Override
    public String updateBook(String id,BooksRequestDto dto, List<String> idCategory) {
        Books books = booksRepository.getReferenceById(id);
        books.setTitle(dto.getTitle());
        books.setAutor(dto.getAuthor());
        books.setStock(dto.getStock());
        booksRepository.save(books);
        booksCategorysService.update(id, idCategory);
        return "success";
    }

    @Override
    public String delete(String id) {
        booksCategorysService.delete(id);
        Books books = booksRepository.getReferenceById(id);
        booksRepository.delete(books);
        return "success";
    }
    
}
