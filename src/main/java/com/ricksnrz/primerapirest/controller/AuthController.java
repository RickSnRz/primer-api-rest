package com.ricksnrz.primerapirest.controller;


import com.ricksnrz.primerapirest.model.dto.LoginDto;
import com.ricksnrz.primerapirest.model.dto.UsuarioDto;
import com.ricksnrz.primerapirest.model.response.LoginResponse;
import com.ricksnrz.primerapirest.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private IUsuarioService usuarioService;

    @PostMapping("/register")
    public String save(@RequestBody UsuarioDto usuarioDto){
        String id = usuarioService.addUsuario(usuarioDto);
        return "Usuario guardado con el id: " + id;
    }

    @PutMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto){
        LoginResponse loginresponse = usuarioService.login(loginDto);
        return ResponseEntity.ok(loginresponse);
    }

}
