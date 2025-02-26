package com.perpustakaan.beperpustakaan.service.categorys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perpustakaan.beperpustakaan.dto.category.CategoryResponseDto;
import com.perpustakaan.beperpustakaan.entity.Categorys;
import com.perpustakaan.beperpustakaan.repository.CategorysRepository;

@Service
public class CategorysServiceImpl implements CategorysService{

    @Autowired
    private CategorysRepository categorysRepository;

    @Override
    public String addCategory(String categoryName) {
        Categorys categorys = new Categorys();
        categorys.setCategoryName(categoryName);
        categorysRepository.save(categorys);
        return "success";
    }

    @Override
    public String delete(String id) {
        Categorys categorys = categorysRepository.getReferenceById(id);
        categorysRepository.delete(categorys);
        return "success";
    }

    @Override
    public String updateCategory(String id, String categoryName) {
        Categorys categorys = categorysRepository.getReferenceById(id);
        categorys.setCategoryName(categoryName);
        categorysRepository.save(categorys);
        return "success";
    }

    @Override
    public List<CategoryResponseDto> getAllCategory() {
        return categorysRepository.findAll().stream().map(this::toCategoryResponseDto).toList();
    }

    private CategoryResponseDto toCategoryResponseDto(Categorys categorys){
        return CategoryResponseDto
                .builder()
                .id(categorys.getId())
                .name(categorys.getCategoryName())
                .build();
    }
    
}
