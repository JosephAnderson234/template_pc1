package com.example.tempalte_pc1.auth.domain;

import com.example.tempalte_pc1.exceptions.UnauthorizedException;
import com.example.tempalte_pc1.jwt.domain.JwtService;
import com.example.tempalte_pc1.jwt.dto.JwtAuthLoginDto;
import com.example.tempalte_pc1.jwt.dto.JwtAuthResponseDto;
import com.example.tempalte_pc1.user.domain.User;
import com.example.tempalte_pc1.user.domain.UserService;
import com.example.tempalte_pc1.user.dto.CreateUserDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthService {

    private final UserService userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public JwtAuthResponseDto jwtLogin(JwtAuthLoginDto loginDto) {
        User user = userService.getUserByUsername(loginDto.getUsername());

        if (!passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
            throw new UnauthorizedException("Invalid username or password");
        }

        JwtAuthResponseDto response = new JwtAuthResponseDto();
        response.setToken(jwtService.generateToken(user));
        return response;
    }

    public JwtAuthResponseDto jwtRegisterAdmin(CreateUserDto userDto) {
        User user = userService.createAdminUser(userDto);

        JwtAuthResponseDto response = new JwtAuthResponseDto();
        response.setToken(jwtService.generateToken(user));
        return response;
    }

    public JwtAuthResponseDto jwtRegister(CreateUserDto userDto) {
        User user = userService.createUser(userDto);

        JwtAuthResponseDto response = new JwtAuthResponseDto();
        response.setToken(jwtService.generateToken(user));
        return response;
    }

}
