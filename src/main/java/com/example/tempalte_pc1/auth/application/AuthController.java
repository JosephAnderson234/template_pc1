package com.example.tempalte_pc1.auth.application;

import com.example.tempalte_pc1.auth.domain.AuthService;
import com.example.tempalte_pc1.jwt.dto.JwtAuthLoginDto;
import com.example.tempalte_pc1.jwt.dto.JwtAuthResponseDto;
import com.example.tempalte_pc1.user.dto.CreateUserDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public JwtAuthResponseDto login(@Valid @RequestBody JwtAuthLoginDto loginDto) {
        return authService.jwtLogin(loginDto);
    }

    @PostMapping("/register-admin")
    @ResponseStatus(HttpStatus.CREATED)
    public JwtAuthResponseDto registerAdmin(@Valid @RequestBody CreateUserDto registerDto) {
        return authService.jwtRegisterAdmin(registerDto);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public JwtAuthResponseDto register(@Valid @RequestBody CreateUserDto registerDto) {
        return authService.jwtRegister(registerDto);
    }

}
