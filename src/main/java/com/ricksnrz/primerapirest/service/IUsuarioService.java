package com.ricksnrz.primerapirest.service;

import com.ricksnrz.primerapirest.model.dto.LoginDto;
import com.ricksnrz.primerapirest.model.dto.UsuarioDto;
import com.ricksnrz.primerapirest.model.payload.LoginMessage;
import com.ricksnrz.primerapirest.model.response.LoginResponse;

public interface IUsuarioService {

    String addUsuario(UsuarioDto usuarioDto);

    LoginResponse login(LoginDto loginDto);
}
