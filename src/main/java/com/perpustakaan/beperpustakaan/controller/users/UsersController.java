package com.perpustakaan.beperpustakaan.controller.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.perpustakaan.beperpustakaan.dto.GenericResponse;
import com.perpustakaan.beperpustakaan.service.users.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestParam String id,@RequestParam String password){
        try {
            return ResponseEntity.ok().body(GenericResponse.success(usersService.login(id, password), "success"));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(GenericResponse.error("internal server error"));
        }
    }

    @PostMapping("/registrasi-siswa")
    public ResponseEntity<Object> registrasiSiswa(@RequestParam String id,String password){
        try{
            return ResponseEntity.ok().body(GenericResponse.success(usersService.registrasiSiswa(id,password),"success"));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(GenericResponse.error("internal server error"));
        }
    }

    @PostMapping("/registrasi-perpustakawan")
    public ResponseEntity<Object> registrasiPerpustakawan(@RequestParam String id,String password){
        try {
            return ResponseEntity.ok().body(GenericResponse.success(usersService.registrasiPerpustakawan(id,password),"success"));
        } catch (Exception e){
            return ResponseEntity.internalServerError().body(GenericResponse.error("internal server error"));
        }
    }
}
