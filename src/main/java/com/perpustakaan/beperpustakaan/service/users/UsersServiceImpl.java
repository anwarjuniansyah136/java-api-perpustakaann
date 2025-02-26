package com.perpustakaan.beperpustakaan.service.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.perpustakaan.beperpustakaan.dto.users.UsersLoginResponseDto;
import com.perpustakaan.beperpustakaan.util.JwtUtil;

import com.perpustakaan.beperpustakaan.repository.UsersRespository;
import com.perpustakaan.beperpustakaan.repository.RolesRepository;
import com.perpustakaan.beperpustakaan.entity.Roles;
import com.perpustakaan.beperpustakaan.entity.Users;

@Service
public class UsersServiceImpl implements UsersService{

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UsersRespository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public UsersLoginResponseDto login(String id,String pass){
        Users user = userRepository.getReferenceById(id);
        if(user != null){
            boolean isMatch = passwordEncoder.matches(pass, user.getPassword());
            if(isMatch){
                return UsersLoginResponseDto
                        .builder()
                        .id(user.getId())
                        .name(user.getName())
                        .role(user.getRoles().getRolesName())
                        .token(jwtUtil.generateToken(user))
                        .build();
            }
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid username or password");
    }

    @Override
    public String registrasiSiswa(String id, String password) {
        Users user = userRepository.getReferenceById(id);
        if(user != null){
            user.setPassword(passwordEncoder.encode(password));
            Roles role = rolesRepository.findByRolesName("SISWA");
            user.setRoles(role);
            userRepository.save(user);
            return "success";
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not Listed");
    }
    
    @Override
    public String registrasiPerpustakawan(String id,String password){
        Users user = userRepository.getReferenceById(id);
        if(user != null){
            user.setPassword(passwordEncoder.encode(password));
            Roles role = rolesRepository.findByRolesName("PERPUSTAKAWAN");
            user.setRoles(role);
            userRepository.save(user);
            return "success";
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not Listed");
    }
}
