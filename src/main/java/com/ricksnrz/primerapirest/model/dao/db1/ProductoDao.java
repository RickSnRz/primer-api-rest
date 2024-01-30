package com.ricksnrz.primerapirest.model.dao.db1;

import com.ricksnrz.primerapirest.model.entity.db1.Producto;
import org.springframework.data.repository.CrudRepository;


public interface ProductoDao extends CrudRepository<Producto, Integer> {
}
