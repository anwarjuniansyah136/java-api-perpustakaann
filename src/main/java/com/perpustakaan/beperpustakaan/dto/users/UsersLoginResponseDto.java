package com.perpustakaan.beperpustakaan.dto.users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsersLoginResponseDto {
    private String id;
    private String name;
    private String role;
    private String token;
}
