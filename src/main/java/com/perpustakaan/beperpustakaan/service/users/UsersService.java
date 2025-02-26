package com.perpustakaan.beperpustakaan.service.users;

import com.perpustakaan.beperpustakaan.dto.users.UsersLoginResponseDto;

public interface UsersService {
    public UsersLoginResponseDto login(String id,String pass);
    public String registrasiSiswa(String id,String password);
    public String registrasiPerpustakawan(String id,String password);
}
