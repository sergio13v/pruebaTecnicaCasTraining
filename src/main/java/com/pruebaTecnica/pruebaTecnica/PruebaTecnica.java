package com.pruebaTecnica.pruebaTecnica;

import com.pruebaTecnica.pruebaTecnica.controllers.ProveedoresController;

public class PruebaTecnica {

	public static void main(String[] args) {		
		if (isNumeric(args[0]) && args[0] != null) {
			ProveedoresController proveedoresController = new ProveedoresController();
			proveedoresController.crearArchivo(Integer.parseInt(args[0]));
		} else {
			System.out.println("Debes introducir un número entero.");
		}
	}
	
	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        Integer i = Integer.parseInt(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
}