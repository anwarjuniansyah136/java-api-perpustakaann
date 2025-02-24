package com.perpustakaan.beperpustakaan.service.admin;

import java.util.List;

import com.perpustakaan.beperpustakaan.dto.admin.AdminRequestDto;

public interface AdminService {
    public String addSiswa(List<AdminRequestDto> dto);
}
