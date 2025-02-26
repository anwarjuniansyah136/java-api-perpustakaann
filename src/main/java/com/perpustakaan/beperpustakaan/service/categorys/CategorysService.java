package com.perpustakaan.beperpustakaan.service.categorys;

import java.util.List;

import com.perpustakaan.beperpustakaan.dto.category.CategoryResponseDto;

public interface CategorysService {
    public String addCategory(String categoryName);
    public String delete(String id);
    public String updateCategory(String id,String categoryName);
    public List<CategoryResponseDto> getAllCategory();
}
