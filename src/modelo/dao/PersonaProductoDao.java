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
import modelo.vo.PersonasProductosVo;
import modelo.vo.ProductoVo;

public class PersonaProductoDao {
	
	private Coordinador miCoordinador;

	public void setCoordinador(Coordinador miCoordinador) {
		// TODO Auto-generated method stub
		this.miCoordinador = miCoordinador;
	}
	public String registrarProducto(PersonasProductosVo Ppersona) {
	
		String resultado = "";
		
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;
		
		connection = conexion.getConnection();
		String consulta = "INSERT INTO personas_producto (persona_id, producto_id)" + "VALUES (?,?)";
		
		try {
			
			preStatement = connection.prepareStatement(consulta);
			preStatement.setLong(1, Ppersona.getPersonaId());
			preStatement.setLong(2, Ppersona.getProductoId());
			
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
	}
	
	public String actualizarProductos(PersonasProductosVo Ppersona) {
		
		String resultado="";
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement preStatement = null;
		connection = miConexion.getConnection();
		
		String consulta="UPDATE personas_producto"
				+ " SET nombre_persona= ?"
				+ " WHERE producto_id =?";
		
		try {
			
			preStatement = connection.prepareStatement(consulta);
			
			preStatement.setLong(1, Ppersona.getPersonaId());
			preStatement.setLong(2, Ppersona.getProductoId());
			
			preStatement.executeUpdate();
			
			resultado="ok";
			
			miConexion.desconectar();	
			
		} catch (SQLException e) {
			System.out.println("Error en la inserccion de datos de persona:"+e);
			resultado="No Logrado";
		}
		
		return resultado;
		
	}

	public String eliminarProductos(PersonasProductosVo Ppersona) {

		String resultado="";
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement preStatement = null;
		connection = miConexion.getConnection();
		
		String consulta="DELETE FROM personas_producto WHERE producto_id = ?";
		
		try {
			
			preStatement = connection.prepareStatement(consulta);
			
			preStatement.setLong(1, Ppersona.getProductoId());
			
			preStatement.executeUpdate();
			
			resultado="ok";
			
			miConexion.desconectar();	
			
		} catch (SQLException e) {
			System.out.println("Error en la eliminacion de datos de persona:"+e);
			resultado="No Logrado";
		}
		
		return resultado;
	}
	
	public String eliminarProductosP(long id) {

		String resultado="";
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement preStatement = null;
		connection = miConexion.getConnection();
		
		String consulta="DELETE FROM personas_producto WHERE persona_id = ?";
		
		try {
			
			preStatement = connection.prepareStatement(consulta);
			
			preStatement.setLong(1, id);
			
			preStatement.executeUpdate();
			
			resultado="ok";
			
			miConexion.desconectar();	
			
		} catch (SQLException e) {
			System.out.println("Error en la eliminacion de datos de persona:"+e);
			resultado="No Logrado";
		}
		
		return resultado;
	}
	
	public PersonasProductosVo consultarProducto(Long idProducto) {
		
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		PersonasProductosVo Ppersona = null;

		connection = miConexion.getConnection();

		String consulta = "SELECT * FROM personas_producto where producto_id = ? ";

		try {

			if (connection != null) {
				statement = connection.prepareStatement(consulta);
				statement.setLong(1, idProducto);
				result = statement.executeQuery();

				if(result.next() == true) {

					Ppersona = new PersonasProductosVo();
					Ppersona.setPersonaId(result.getLong("persona_id"));
					Ppersona.setProductoId(result.getLong("producto_id"));
				}

				miConexion.desconectar();

			} else {
				Ppersona = null;
			}

		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error en la consulta de la persona: " + e.getMessage());
		}
		return Ppersona;
		
	}
	
	public ArrayList<Long> selecionarProductos(long idPersona) {
		ArrayList<Long> productos = new ArrayList<Long>();
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		PersonasProductosVo Ppersona = null;

		connection = miConexion.getConnection();

		String consulta = "SELECT producto_id FROM personas_producto where persona_id = ? ";

		try {

			if (connection != null) {
				statement = connection.prepareStatement(consulta);
				statement.setLong(1, idPersona);
				result = statement.executeQuery();

				while(result.next() == true) {

					long producto = result.getLong("producto_id");
					productos.add(producto);
				}

				miConexion.desconectar();

			} else {
				Ppersona = null;
			}

		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error en la consulta de la persona: " + e.getMessage());
		}
		return productos;
		
	}
	
	

}
