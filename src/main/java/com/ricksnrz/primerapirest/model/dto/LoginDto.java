package com.ricksnrz.primerapirest.model.dto;


import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class LoginDto {

    private String email;
    private String password;

}
