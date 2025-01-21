package org.juanbrenes.apiservlet.webapp.headers.services;

import org.juanbrenes.apiservlet.webapp.headers.models.Producto;

import java.util.List;

public class ProductoServiceImpl implements ProductoService {
    @Override
    public List<Producto> listar() {
        return List.of(new Producto(1L, "notebook", "computacion", 1000),
                new Producto(2L, "mesa escritorio", "oficina", 200),
                new Producto(3L, "silla", "oficina", 100));
    }
}
