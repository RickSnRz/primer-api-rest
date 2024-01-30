package com.ricksnrz.primerapirest.service.impl;

import com.ricksnrz.primerapirest.model.dao.ProductoDao;
import com.ricksnrz.primerapirest.model.dto.ProductoDto;
import com.ricksnrz.primerapirest.model.entity.Producto;
import com.ricksnrz.primerapirest.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoImplService implements IProductoService {

    @Autowired
    private ProductoDao productoDao;

    @Override
    public List<Producto> listAll() {
        return (List) productoDao.findAll();
    }

    @Transactional
    @Override
    public Producto save(ProductoDto productoDto) {
        Producto producto = Producto.builder()
                .idProducto(productoDto.getIdProducto())
                .nombre(productoDto.getNombre())
                .descripcion(productoDto.getDescripcion())
                .categoria(productoDto.getCategoria())
                .precio(productoDto.getPrecio())
                .stock(productoDto.getStock())
                .fecha_creacion(productoDto.getFecha_creacion())
                .build();
        return productoDao.save(producto);
    }

    @Transactional(readOnly = true)
    @Override
    public Producto findById(Integer id) {
        return productoDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Producto producto) {
          productoDao.delete(producto);
    }

    @Override
    public boolean existsById(Integer id) {
        return productoDao.existsById(id);
    }

}
