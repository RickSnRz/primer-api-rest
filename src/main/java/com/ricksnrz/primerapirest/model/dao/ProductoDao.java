package com.ricksnrz.primerapirest.model.dao;

import com.ricksnrz.primerapirest.model.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoDao extends CrudRepository<Producto, Integer> {
}
