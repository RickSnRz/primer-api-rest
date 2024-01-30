package com.ricksnrz.primerapirest.service.impl;

import com.ricksnrz.primerapirest.model.dao.db2.UsuarioDao;
import com.ricksnrz.primerapirest.model.dto.UsuarioDto;
import com.ricksnrz.primerapirest.model.entity.db2.Usuario;
import com.ricksnrz.primerapirest.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioImplService implements IUsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addUsuario(UsuarioDto usuarioDto) {

        Usuario usuario = new Usuario(
                usuarioDto.getId(),
                usuarioDto.getNombre(),
                usuarioDto.getEmail(),
                this.passwordEncoder.encode(usuarioDto.getPassword())
        );

        usuarioDao.save(usuario);

        return usuario.getNombre();
    }
}
