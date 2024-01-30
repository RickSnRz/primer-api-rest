package com.ricksnrz.primerapirest.model.dao.db1;

import com.ricksnrz.primerapirest.model.entity.db1.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteDao extends CrudRepository<Cliente, Integer> {
}
