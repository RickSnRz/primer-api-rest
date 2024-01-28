package com.ricksnrz.primerapirest.model.dao;

import com.ricksnrz.primerapirest.model.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDao extends CrudRepository<Cliente, Integer> {
}
