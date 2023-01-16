package com.pruebaTecnica.pruebaTecnica.controllers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import com.pruebaTecnica.pruebaTecnica.dao.ProveedoresDao;
import com.pruebaTecnica.pruebaTecnica.dao.ProveedoresDaoImp;
import com.pruebaTecnica.pruebaTecnica.models.Proveedores;

public class ProveedoresController {
	public void crearArchivo(Integer idCliente) {
		ProveedoresDao proveedoresDao = new ProveedoresDaoImp();
		List<Proveedores> listaProveedores = proveedoresDao.getProveedores(idCliente);
		if (listaProveedores != null && !listaProveedores.isEmpty() && listaProveedores.size() != 0) {
			FileWriter flwriter = null;
			try {
				//crea el flujo para escribir en el archivo
				flwriter = new FileWriter("C:\\proveedores.txt");
				//crea un buffer o flujo intermedio antes de escribir directamente en el archivo
				BufferedWriter bfwriter = new BufferedWriter(flwriter);
				//escribe en el archivo
				bfwriter.write("id_proveedor, nombre, fecha_alta, id_cliente \n");
				for (Proveedores proveedor : listaProveedores) {
					bfwriter.write(proveedor.getIdProveedor() + "," + proveedor.getNombre() + "," + proveedor.getFechaAlta()
							+ "," + proveedor.getIdCliente() + "," + "\n");
				}
				//cierra el buffer intermedio
				bfwriter.close();
				System.out.println("Archivo creado satisfactoriamente.");

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (flwriter != null) {
					try {//cierra el flujo principal
						flwriter.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}