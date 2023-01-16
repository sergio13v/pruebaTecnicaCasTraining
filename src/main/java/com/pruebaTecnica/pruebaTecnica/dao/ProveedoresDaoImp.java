package com.pruebaTecnica.pruebaTecnica.dao;

import java.util.List;

import com.pruebaTecnica.pruebaTecnica.models.Proveedores;

import utils.DbConexionUtil;

public class ProveedoresDaoImp implements ProveedoresDao {

	DbConexionUtil dbConexionUtil = new DbConexionUtil();

	@Override
	public List<Proveedores> getProveedores(Integer idCliente) {
		List<Proveedores> listaProveedores = dbConexionUtil.conectar(idCliente);

		return listaProveedores;
	}
}
