package com.perpustakaan.beperpustakaan.service.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.perpustakaan.beperpustakaan.dto.users.UsersLoginResponseDto;
import com.perpustakaan.beperpustakaan.util.JwtUtil;

import com.perpustakaan.beperpustakaan.repository.UsersRespository;
import com.perpustakaan.beperpustakaan.entity.Users;

@Service
public class UsersServiceImpl implements UsersService{

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UsersRespository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

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
}
