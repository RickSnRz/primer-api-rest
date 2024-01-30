package com.ricksnrz.primerapirest.controller;


import com.ricksnrz.primerapirest.model.dto.UsuarioDto;
import com.ricksnrz.primerapirest.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/security")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @PostMapping("/save")
    public String save(@RequestBody UsuarioDto usuarioDto){
        String id = usuarioService.addUsuario(usuarioDto);
        return "Usuario guardado con el id: " + id;
    }

}
