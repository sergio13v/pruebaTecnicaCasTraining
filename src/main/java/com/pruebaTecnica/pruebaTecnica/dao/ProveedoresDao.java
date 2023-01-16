package com.pruebaTecnica.pruebaTecnica.dao;

import java.util.List;

import com.pruebaTecnica.pruebaTecnica.models.Proveedores;

public interface ProveedoresDao {

	List<Proveedores> getProveedores(Integer idCliente);
}
