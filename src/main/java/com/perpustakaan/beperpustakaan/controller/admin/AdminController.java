package com.perpustakaan.beperpustakaan.controller.admin;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    
    @PostMapping("/add-data-perpustakawan")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<Object> addPerpustakawan(@RequestBody List<AdminRequestDto> dto){
        try{
            return ResponseEntity.ok().body(GenericResponse.success(adminService.addPerpustakawan(dto),"success"));
        }catch(Exception e){
            return ResponseEntity.internalServerError().body(GenericResponse.error("internal server error"));
        }
    }

    @GetMapping("/get-siswa")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<Object> getSiswa(){
        try{
            return ResponseEntity.ok().body(GenericResponse.success(adminService.getSiswa(),"success"));
        }catch(Exception e){
            return ResponseEntity.internalServerError().body(GenericResponse.error("internal server error"));
        }
    }

    @GetMapping("/get-perpustakawan")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<Object> getPerpustakawan(){
        try{
            return ResponseEntity.ok().body(GenericResponse.success(adminService.getPerpustakawan(),"success"));
        }catch(Exception e){
            return ResponseEntity.internalServerError().body(GenericResponse.error("internal server error"));
        }
    }

    @PutMapping("/edit-users")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<Object> editUsers(@RequestParam String oldId,@RequestParam(required = false) String name,@RequestParam(required = false) String newId){
        try{
            return ResponseEntity.ok().body(GenericResponse.success(adminService.editUsers(oldId, name, newId),"success"));
        }catch(Exception e){
            return ResponseEntity.internalServerError().body(GenericResponse.error("internal server error"));
        }
    }

    @DeleteMapping("/delete-users")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<Object> deleteUsers(@RequestParam String id){
        try{
            return ResponseEntity.ok().body(GenericResponse.success(adminService.delete(id),"success"));
        }catch(Exception e){
            return ResponseEntity.internalServerError().body(GenericResponse.error("internal server error"));
        }
    }
}
