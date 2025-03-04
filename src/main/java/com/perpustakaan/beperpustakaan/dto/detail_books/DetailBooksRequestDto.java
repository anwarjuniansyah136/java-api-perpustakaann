package com.perpustakaan.beperpustakaan.dto.detail_books;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailBooksRequestDto {
    private String idBooks;
    private Date peminjaman;
    private Date batasPengembalian;
}
