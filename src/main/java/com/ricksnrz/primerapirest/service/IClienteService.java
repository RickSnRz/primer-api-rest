package com.ricksnrz.primerapirest.service;

import com.ricksnrz.primerapirest.model.dto.ClienteDto;
import com.ricksnrz.primerapirest.model.entity.Cliente;

import java.util.List;

public interface IClienteService {

    List<Cliente> listAll();

    Cliente save(ClienteDto cliente);

    Cliente findById(Integer id);

    void delete(Cliente cliente);

    boolean existsById(Integer id);
}
