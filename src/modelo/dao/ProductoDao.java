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
import modelo.vo.ProductoVo;

public class ProductoDao {
	
	private Coordinador miCoordinador;

	public void setCoordinador(Coordinador miCoordinador) {
		// TODO Auto-generated method stub
		this.miCoordinador = miCoordinador;
	}
	
	public void registrarProducto() {
		// TODO Auto-generated method stub
		
	}
	
	public void consultarProducto() {
		
	}
	
	public ArrayList<ProductoVo> imprimirProducto() {
		ArrayList<ProductoVo> productos = new ArrayList<ProductoVo>();
		Connection connection=null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement=null;
		ResultSet result=null;
		
		ProductoVo miProductoVo=null;
		NacimientoVo miNacimiento=null;
		
		connection=miConexion.getConnection();
		
		String consulta="SELECT * FROM productos";
		
		try {
			
			if(connection!=null) {
				statement=connection.prepareStatement(consulta);

				result=statement.executeQuery();
				
				while(result.next()==true) {
					miProductoVo = new ProductoVo();
					miProductoVo.setIdProducto(result.getLong("id_producto"));
					miProductoVo.setNombreProducto(result.getString("nombre_producto"));
					miProductoVo.setPrecioProducto(result.getDouble("precio_producto"));
					
					productos.add(miProductoVo);
				}
				
				miConexion.desconectar();
				
			}else {
				miProductoVo=null;
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error en la consulta de la persona: "+e.getMessage());
		}
		return productos;
	}
	
	public String actualizarProducto(ProductoVo p) {
		String resultado="";
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement preStatement = null;
		connection = miConexion.getConnection();
		
		String consulta="UPDATE producto "
				+ " SET nombre_producto = ?,precio_producto = ?;"
				+ " WHERE id_producto = ?";
		
		try {
			
			preStatement = connection.prepareStatement(consulta);
			
			preStatement.setString(1, p.getNombreProducto());
			preStatement.setDouble(2, p.getPrecioProducto());
			preStatement.setLong(2, p.getIdProducto());
			
			preStatement.executeUpdate();
			
			resultado="ok";
			
			miConexion.desconectar();	
			
		} catch (SQLException e) {
			System.out.println("Error en la inserccion de datos de persona:"+e);
			resultado="No Logrado";
		}
		
		return resultado;
	}

	public String eliminarProducto(ProductoVo p) {
		String resultado="";
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement preStatement = null;
		connection = miConexion.getConnection();
		
		String consulta="DELETE FROM producto WHERE id_persona = ?";
		
		try {
			
			preStatement = connection.prepareStatement(consulta);
			
			preStatement.setLong(1, p.getIdProducto());
			
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
