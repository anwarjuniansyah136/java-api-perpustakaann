package com.perpustakaan.beperpustakaan.init;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.perpustakaan.beperpustakaan.constant.RolesConstant;
import com.perpustakaan.beperpustakaan.entity.Roles;
import com.perpustakaan.beperpustakaan.repository.RolesRepository;



@Component 
public class InitialDataLoader implements ApplicationRunner{
    @Autowired
    RolesRepository rolesRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Roles> roles = rolesRepository.findAll();

        if(roles.isEmpty()){
            Roles admin = new Roles(null, RolesConstant.ADMIN_ROLE);
            Roles perpustakawan = new Roles(null, RolesConstant.PERPUSTAKAWAN_ROLE);
            Roles siswa = new Roles(null, RolesConstant.SISWA_ROLE);

            rolesRepository.saveAll(List.of(admin, perpustakawan, siswa));
        }
    }
    
}
