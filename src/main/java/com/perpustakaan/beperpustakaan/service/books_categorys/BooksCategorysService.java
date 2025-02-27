package com.perpustakaan.beperpustakaan.service.books_categorys;

import java.util.List;

public interface BooksCategorysService {
    public String add(String idBooks,List<String> idCategorys);
    public String update(String idBooks,List<String> idCategorys);
    public String delete(String idBooks);
}
