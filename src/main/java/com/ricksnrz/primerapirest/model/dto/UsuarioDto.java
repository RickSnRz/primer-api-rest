package com.ricksnrz.primerapirest.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;


@Data
@ToString
@Builder
public class UsuarioDto implements Serializable {

    private Integer id;
    private String email;
    private String nombre;
    private String password;

}
