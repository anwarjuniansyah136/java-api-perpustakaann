package com.perpustakaan.beperpustakaan.controller.admin;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import com.perpustakaan.beperpustakaan.dto.admin.AdminRequestDto;

import org.springframework.web.bind.annotation.RequestBody;
import com.perpustakaan.beperpustakaan.dto.GenericResponse;
import com.perpustakaan.beperpustakaan.service.admin.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    
    @PostMapping("/add-data-siswa")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<Object> addSiswa(@RequestBody List<AdminRequestDto> dto){
        try{
            return ResponseEntity.ok().body(GenericResponse.success(adminService.addSiswa(dto),"success"));
        }catch(Exception e){
            return ResponseEntity.internalServerError().body(GenericResponse.error("internal server error"));
        }
    }
}
