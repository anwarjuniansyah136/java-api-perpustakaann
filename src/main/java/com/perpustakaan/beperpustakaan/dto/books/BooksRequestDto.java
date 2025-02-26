package com.perpustakaan.beperpustakaan.dto.books;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BooksRequestDto {
    private String title;
    private String author;
    private long stock;
}
