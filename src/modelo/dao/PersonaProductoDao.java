package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controlador.Coordinador;
import modelo.conexion.Conexion;
import modelo.vo.NacimientoVo;
import modelo.vo.PersonaVo;

public class PersonaProductoDao {
	
	private Coordinador miCoordinador;

	public void setCoordinador(Coordinador miCoordinador) {
		// TODO Auto-generated method stub
		this.miCoordinador = miCoordinador;
	}
	
	String resultado = "";
	
	Connection connection = null;
	Conexion conexion = new Conexion();
	PreparedStatement preStatement = null;
	
	connection = conexion.getConnection();
	String consulta = "INSERT INTO personas_producto (id_producto, nombre_producto, precio_producto)" + "VALUES (?,?,?)";
	
	try {
		
		preStatement = connection.prepareStatement(consulta);
		preStatement.setLong(1, miProducto.getIdProducto());
		preStatement.setString(2, miProducto.getNombreProducto());
		preStatement.setDouble(3, miProducto.getPrecioProducto());
		
		preStatement.execute();
		
		resultado="ok";
		
	} catch (SQLException e) {
		// TODO: handle exception
		System.out.println("No se pudo registrar la persona, verifique que el documento no exista: "+ e.getMessage());
		e.printStackTrace();
		resultado="No se pudo registrar la persona";
		
	} catch(Exception e) {
		System.out.println("No se pudo registrar la persona: "+e.getMessage());
		e.printStackTrace();
		resultado="No se pudo registrar la persona";
	
	} finally {
		conexion.desconectar();
	}
	
	return resultado;
	
	
	public String actualizarProductos(PersonaVo p) {
		
		String resultado="";
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement preStatement = null;
		connection = miConexion.getConnection();
		
		String consulta="UPDATE persona "
				+ " SET nombre_persona= ?, profesion_persona = ?, telefono_persona = ?, tipo_persona = ?, nacimiento_id = ?"
				+ " WHERE id_persona =?";
		
		try {
			
			preStatement = connection.prepareStatement(consulta);
			
			preStatement.setString(1, p.getNombre());
			preStatement.setString(2, p.getProfesion());
			preStatement.setString(3, p.getTelefono());
			preStatement.setInt(4, p.getTipo());
			preStatement.setLong(5, p.getNacimiento().getIdNacimiento());
			preStatement.setLong(6, p.getIdPersona());
			
			preStatement.executeUpdate();
			
			resultado="ok";
			
			miConexion.desconectar();	
			
		} catch (SQLException e) {
			System.out.println("Error en la inserccion de datos de persona:"+e);
			resultado="No Logrado";
		}
		
		return resultado;
		
	}

	public String eliminarProductos(PersonaVo p) {

		String resultado="";
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement preStatement = null;
		connection = miConexion.getConnection();
		
		String consulta="DELETE FROM persona WHERE id_persona = ?";
		
		try {
			
			preStatement = connection.prepareStatement(consulta);
			
			preStatement.setLong(1, p.getIdPersona());
			
			preStatement.executeUpdate();
			
			resultado="ok";
			
			miConexion.desconectar();	
			
		} catch (SQLException e) {
			System.out.println("Error en la eliminacion de datos de persona:"+e);
			resultado="No Logrado";
		}
		
		return resultado;
	}

}
