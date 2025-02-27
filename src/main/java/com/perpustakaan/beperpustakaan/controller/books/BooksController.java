package com.perpustakaan.beperpustakaan.controller.books;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.perpustakaan.beperpustakaan.dto.GenericResponse;
import com.perpustakaan.beperpustakaan.dto.books.BooksRequestDto;
import com.perpustakaan.beperpustakaan.service.books.BooksService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/books")
public class BooksController {
    @Autowired
    private BooksService booksService;

    @PostMapping("/add-books")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<Object> addBooks(@RequestBody BooksRequestDto dto,@RequestParam List<String> idCategorys){
        try {
            return ResponseEntity.ok().body(GenericResponse.success(booksService.addBook(dto, idCategorys), "success"));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(GenericResponse.error("internal server error"));
        }
    }

    @PutMapping("/update-books")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<Object> updateBooks(@RequestParam String id,@RequestBody BooksRequestDto dto,@RequestParam List<String> idCategorys){
        try {
            return ResponseEntity.ok().body(GenericResponse.success(booksService.updateBook(id, dto, idCategorys), "success"));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(GenericResponse.error("internal server error"));
        }
    }

    @DeleteMapping("/delete-books")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<Object> deleteBooks(@RequestParam String id){
        try {
            return ResponseEntity.ok().body(GenericResponse.success(booksService.delete(id), "seccess"));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(GenericResponse.error("internal server error"));
        }
    }
}
