package com.perpustakaan.beperpustakaan.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perpustakaan.beperpustakaan.dto.admin.AdminRequestDto;
import com.perpustakaan.beperpustakaan.entity.Users;
import com.perpustakaan.beperpustakaan.repository.UsersRespository;
import com.perpustakaan.beperpustakaan.repository.RolesRepository;
import com.perpustakaan.beperpustakaan.entity.Roles;
import com.perpustakaan.beperpustakaan.dto.admin.AdminResponseDto;

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

    @Override
    public String addPerpustakawan(List<AdminRequestDto> dto){
        Roles roles = rolesRepository.findByRolesName("PERPUSTAKAWAN");
        for(AdminRequestDto st : dto){
            Users user = new Users();
            user.setId(st.getId());
            user.setName(st.getName());
            user.setRoles(roles);
            usersRepository.save(user);
        }
        return "success";
    }

    @Override
    public List<AdminResponseDto> getSiswa(){
        Roles role = rolesRepository.findByRolesName("SISWA");
        return usersRepository.findByRoles(role).stream().map(this::toAdminResponseDto).toList();
    }

    private AdminResponseDto toAdminResponseDto(Users users){
        return AdminResponseDto
                .builder()
                .id(users.getId())
                .name(users.getName())
                .build();
    }

    @Override
    public List<AdminResponseDto> getPerpustakawan(){
        Roles role = rolesRepository.findByRolesName("PERPUSTAKAWAN");
        return usersRepository.findByRoles(role).stream().map(this::toAdminResponseDto).toList();  
    }

    @Override
    public String delete(String id){
        Users user = usersRepository.getReferenceById(id);
        usersRepository.delete(user);
        return "success";
    }

    @Override
    public String editUsers(String oldId, String name, String newId) {
        Users users = usersRepository.getReferenceById(oldId);
        if(newId != null){
            Users users2 = new Users();
            users2.setId(newId);
            users2.setName(name);
            users2.setRoles(users.getRoles());
            if(users.getPassword() != null){
                users2.setPassword(users.getPassword());
            }
            usersRepository.delete(users);
            usersRepository.save(users);
            return "success";
        }
        users.setName(name);
        usersRepository.save(users);
        return "success";
    }
}
