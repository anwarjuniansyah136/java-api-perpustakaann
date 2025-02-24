package com.perpustakaan.beperpustakaan.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perpustakaan.beperpustakaan.dto.admin.AdminRequestDto;
import com.perpustakaan.beperpustakaan.entity.Users;
import com.perpustakaan.beperpustakaan.repository.UsersRespository;
import com.perpustakaan.beperpustakaan.repository.RolesRepository;
import com.perpustakaan.beperpustakaan.entity.Roles;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private UsersRespository usersRepository;

    @Autowired
    private RolesRepository rolesRepository;
    
    @Override
    public String addSiswa(List<AdminRequestDto> dto){
        Roles roles = rolesRepository.findByRolesName("SISWA");
        for(AdminRequestDto st : dto){
            Users user = new Users();
            user.setId(st.getId());
            user.setName(st.getName());
            user.setRoles(roles);
            usersRepository.save(user);
        }
        return "success";
    }
}
