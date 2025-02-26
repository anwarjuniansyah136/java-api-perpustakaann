package com.perpustakaan.beperpustakaan.service.books_categorys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perpustakaan.beperpustakaan.entity.Books;
import com.perpustakaan.beperpustakaan.entity.BooksCategorys;
import com.perpustakaan.beperpustakaan.entity.Categorys;
import com.perpustakaan.beperpustakaan.repository.BooksCategorysRepository;
import com.perpustakaan.beperpustakaan.repository.BooksRepository;
import com.perpustakaan.beperpustakaan.repository.CategorysRepository;

@Service
public class BooksCategorysServiceImpl implements BooksCategorysService{

    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    private CategorysRepository categorysRepository;

    @Autowired
    private BooksCategorysRepository booksCategorysRepository;

    @Override
    public String add(String idBooks, List<String> idCategorys) {
        Books books = booksRepository.getReferenceById(idBooks);
        if(idCategorys.size() > 1){
            for (String id : idCategorys) {
                Categorys categorys = categorysRepository.getReferenceById(id);
                BooksCategorys booksCategorys = new BooksCategorys();
                booksCategorys.setBooks(books);
                booksCategorys.setCategorys(categorys);
                booksCategorysRepository.save(booksCategorys);
            }
            return "success";
        }
        Categorys categorys = categorysRepository.getReferenceById(idCategorys.get(0));
        BooksCategorys booksCategorys = new BooksCategorys();
        booksCategorys.setBooks(books);
        booksCategorys.setCategorys(categorys);
        booksCategorysRepository.save(booksCategorys);
        return "success";
    }
    
}
