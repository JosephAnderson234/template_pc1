package com.example.tempalte_pc1.user.application;

import com.example.tempalte_pc1.user.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/me")
    public ResponseEntity<User> getCurrentUser(@AuthenticationPrincipal User usuario){
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/only_admin")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> filterAdmin(){
        return ResponseEntity.ok("Hola admin");
    }

    @GetMapping("/only_user")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> filterUser(){
        return ResponseEntity.ok("Hola user");
    }
}
