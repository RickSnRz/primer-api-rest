package com.ricksnrz.primerapirest.controller;



import com.ricksnrz.primerapirest.model.dto.ProductoDto;
import com.ricksnrz.primerapirest.model.entity.Producto;
import com.ricksnrz.primerapirest.model.payload.MensajeResponse;
import com.ricksnrz.primerapirest.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @GetMapping("productos")
    public ResponseEntity<?> showAll(){
        List<Producto> getList = productoService.listAll();

        if(getList == null){
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje("No hay registros")
                            .object(null)
                            .build()
                    , HttpStatus.OK);
        }

        return new ResponseEntity<>(
                MensajeResponse.builder()
                        .mensaje("Registro(s) encontrado(s)")
                        .object(getList)
                        .build(), HttpStatus.OK);
    }

    @PostMapping("producto")
    public ResponseEntity<?> create(@RequestBody ProductoDto productoDto){
        Producto productoSave = null;
        try {
            productoSave = productoService.save(productoDto);
            productoDto =  ProductoDto.builder()
                    .idProducto(productoSave.getIdProducto())
                    .nombre(productoSave.getNombre())
                    .descripcion(productoSave.getDescripcion())
                    .categoria(productoSave.getCategoria())
                    .precio(productoSave.getPrecio())
                    .stock(productoSave.getStock())
                    .fecha_creacion(productoSave.getFecha_creacion())
                    .build();

            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("Guardado Exitosamente")
                    .object(productoDto)
                    .build(), HttpStatus.CREATED);
    } catch (DataAccessException exDt) {
        return new ResponseEntity<>(MensajeResponse.builder()
                .mensaje(exDt.getMessage())
                .object(null)
                .build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }

    @PutMapping("producto/{id}")
    public ResponseEntity<?> update(@RequestBody ProductoDto productoDto,
                                    @PathVariable Integer id){
        Producto productoUpdate = null;
        try {
            if(productoService.existsById(id)){
                productoDto.setIdProducto(id);
                productoUpdate = productoService.save(productoDto);
                return new ResponseEntity<>(MensajeResponse.builder()
                        .mensaje("Guardado Exitosamente")
                        .object(ProductoDto.builder()
                                .idProducto(productoUpdate.getIdProducto())
                                .nombre(productoUpdate.getNombre())
                                .descripcion(productoUpdate.getDescripcion())
                                .categoria(productoUpdate.getCategoria())
                                .precio(productoUpdate.getPrecio())
                                .stock(productoUpdate.getStock())
                                .fecha_creacion(productoUpdate.getFecha_creacion())
                                .build())
                        .build(), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(
                        MensajeResponse.builder()
                                .mensaje("No existe el producto")
                                .object(null)
                                .build()
                        , HttpStatus.NOT_FOUND);
            }
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje(exDt.getMessage())
                            .object(null)
                            .build()
                    , HttpStatus.METHOD_NOT_ALLOWED );
        }
    }

    @DeleteMapping("producto/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        try {
            Producto productoDelete = productoService.findById(id);
            productoService.delete(productoDelete);
            return new ResponseEntity<>(productoDelete, HttpStatus.NO_CONTENT);
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje(exDt.getMessage())
                            .object(null)
                            .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @GetMapping("producto/{id}")
    public ResponseEntity<?> showById(@PathVariable Integer id){
        Producto producto = productoService.findById(id);

        if(producto == null){
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje("No existe el producto")
                            .object(null)
                            .build()
                    , HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(
                MensajeResponse.builder()
                        .mensaje("Producto encontrado")
                        .object(ProductoDto.builder()
                                .idProducto(producto.getIdProducto())
                                .nombre(producto.getNombre())
                                .descripcion(producto.getDescripcion())
                                .categoria(producto.getCategoria())
                                .precio(producto.getPrecio())
                                .stock(producto.getStock())
                                .fecha_creacion(producto.getFecha_creacion())
                                .build())
                        .build(), HttpStatus.OK);
    }

}
