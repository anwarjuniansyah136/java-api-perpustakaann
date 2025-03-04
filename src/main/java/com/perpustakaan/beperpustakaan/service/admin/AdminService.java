package com.perpustakaan.beperpustakaan.service.admin;

import java.util.List;

import com.perpustakaan.beperpustakaan.dto.admin.AdminRequestDto;
import com.perpustakaan.beperpustakaan.dto.admin.AdminResponseDto;

public interface AdminService {
    public String addSiswa(List<AdminRequestDto> dto);
    public String addPerpustakawan(List<AdminRequestDto> dto);
    public List<AdminResponseDto> getSiswa();
    public List<AdminResponseDto> getPerpustakawan();
    public String delete(String id);
    public String editUsers(String oldId,String name,String newId);
}
