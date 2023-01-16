package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pruebaTecnica.pruebaTecnica.models.Proveedores;

public class DbConexionUtil {

	public List<Proveedores> conectar(Integer idCliente){
		String url = "jdbc:mysql://localhost:8889/prueba_tecnica";
	    String user = "root";
	    String password = "root";

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection connection = DriverManager.getConnection(url, user, password);
	        System.out.println("Conectado correctamente a " + url);
	        String query = "Select * from Proveedores where id_cliente = " + idCliente;
	        PreparedStatement pstm = connection.prepareStatement(query);
	        ResultSet rs = pstm.executeQuery();

	        Proveedores proveedores = new Proveedores();
	        List<Proveedores> listaProveedores = new ArrayList<>();

	        while (rs.next()){
	        	proveedores.setIdProveedor(rs.getInt("id_proveedor"));
	        	proveedores.setNombre(rs.getString("nombre"));
	        	proveedores.setFechaAlta(rs.getDate("fecha_alta"));
	        	proveedores.setIdCliente(rs.getInt("id_cliente"));
	        	listaProveedores.add(proveedores);
	        }

		    rs.close();
		    pstm.close();

		    if (listaProveedores != null && !listaProveedores.isEmpty() && listaProveedores.size() != 0) {
		    	return listaProveedores;
			}

		    System.out.println("El cliente no tiene proveedores asignados.");

	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException throwables) {
	        throwables.printStackTrace();
	        System.out.println("No se pudo conectar a " + url);
	    }

	    return null;
	}
}