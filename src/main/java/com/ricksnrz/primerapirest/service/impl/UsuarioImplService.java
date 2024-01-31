package com.ricksnrz.primerapirest.service.impl;

import com.ricksnrz.primerapirest.model.dao.db2.UsuarioDao;
import com.ricksnrz.primerapirest.model.dto.LoginDto;
import com.ricksnrz.primerapirest.model.dto.UsuarioDto;
import com.ricksnrz.primerapirest.model.entity.db2.Usuario;
import com.ricksnrz.primerapirest.model.payload.LoginMessage;
import com.ricksnrz.primerapirest.model.response.LoginResponse;
import com.ricksnrz.primerapirest.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
                usuarioDto.getEmail(),
                usuarioDto.getNombre(),
                this.passwordEncoder.encode(usuarioDto.getPassword())
        );

        usuarioDao.save(usuario);

        return usuario.getNombre();
    }

    @Override
    public LoginResponse login(LoginDto loginDto) {
        String nsg = "";
        Usuario usuario = usuarioDao.findByEmail(loginDto.getEmail());
        if(usuario != null){
            String password = loginDto.getPassword();
            String passwordBD = usuario.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, passwordBD);
            if(isPwdRight){
                Optional<Usuario> usuarioOptional = usuarioDao.findOneByEmailAndPassword(loginDto.getEmail(), passwordBD);
                if(usuarioOptional.isPresent()){
                    return new LoginResponse("Login exitoso", true);
                } else {
                    return new LoginResponse("Login fallido", false);
                }

            } else {
                return new LoginResponse("Password fallido", false);
            }
    } else {
            return new LoginResponse("Usuario no encontrado", false);
        }
}

}

