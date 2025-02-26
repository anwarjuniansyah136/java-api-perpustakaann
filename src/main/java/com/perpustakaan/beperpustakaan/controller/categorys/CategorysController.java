package com.perpustakaan.beperpustakaan.controller.categorys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.perpustakaan.beperpustakaan.dto.GenericResponse;
import com.perpustakaan.beperpustakaan.service.categorys.CategorysService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/categorys")
public class CategorysController {
    @Autowired
    private CategorysService categorysService;

    @GetMapping("/get-all")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<Object> getAll(){
        try {
            return ResponseEntity.ok().body(GenericResponse.success(categorysService.getAllCategory(), "success"));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(GenericResponse.error("internal server error"));
        }
    }

    @PostMapping("/add-category")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<Object> addCategory(@RequestParam String categoryName){
        try {
            return ResponseEntity.ok().body(GenericResponse.success(categorysService.addCategory(categoryName), "success"));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(GenericResponse.error("internal server error"));
        }
    }

    @PutMapping("/edit-category")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<Object> updateCategory(@RequestParam String id,@RequestParam String categoryName){
        try {
            return ResponseEntity.ok().body(GenericResponse.success(categorysService.updateCategory(id, categoryName), "success"));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(GenericResponse.error("internal server error"));
        }
    }

    @DeleteMapping("/delete-category")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<Object> delete(@RequestParam String id){
        try {
            return ResponseEntity.ok().body(GenericResponse.success(categorysService.delete(id), "success"));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(GenericResponse.error("internal server error"));
        }
    }
}
