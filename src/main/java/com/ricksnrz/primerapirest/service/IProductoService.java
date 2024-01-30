package com.ricksnrz.primerapirest.service;

import com.ricksnrz.primerapirest.model.dto.ProductoDto;
import com.ricksnrz.primerapirest.model.entity.db1.Producto;

import java.util.List;

public interface IProductoService {

    List<Producto> listAll();

    Producto save(ProductoDto producto);

    Producto findById(Integer id);

    void delete(Producto producto);

    boolean existsById(Integer id);

}
