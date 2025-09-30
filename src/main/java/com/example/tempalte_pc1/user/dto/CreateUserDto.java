package com.example.tempalte_pc1.user.dto;

import com.example.tempalte_pc1.user.domain.Role;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateUserDto {

    @NotNull
    private String username;

    @NotNull
    private String password;

    private Role role;

}
