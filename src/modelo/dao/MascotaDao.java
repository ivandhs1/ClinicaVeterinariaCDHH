package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controlador.Coordinador;
import modelo.conexion.Conexion;
import modelo.vo.MascotaVo;
import modelo.vo.NacimientoVo;
import modelo.vo.PersonaVo;

public class MascotaDao {
	
	private Coordinador miCoordinador;

	public void setCoordinador(Coordinador miCoordinador) {
		// TODO Auto-generated method stub
		this.miCoordinador = miCoordinador;
	}

	
	public String registrarMascota(MascotaVo miMascota) {
		// TODO Auto-generated method stub
		String resultado = "";
		
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;
		
		connection = conexion.getConnection();
		String consulta = "INSERT INTO mascotas (id_mascotas, color , nombre, raza, sexo, persona_id)" + "VALUES (?,?,?,?,?,?)";
		
		try {
			
			preStatement = connection.prepareStatement(consulta);
			preStatement.setLong(1, miMascota.getIdMascota());
			preStatement.setString(2, miMascota.getColorMascota());
			preStatement.setString(3, miMascota.getNombre());
			preStatement.setString(4, miMascota.getRaza());
			preStatement.setString(5, miMascota.getSexo());
			preStatement.setLong(6, miMascota.getIdDueno());
			preStatement.execute();
			
			resultado="ok";
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("No se pudo registrar la mascota verifique datos: "+ e.getMessage());
			e.printStackTrace();
			resultado="No se pudo registrar la persona";
			
		} catch(Exception e) {
			System.out.println("No se pudo registrar la mascota: "+e.getMessage());
			e.printStackTrace();
			resultado="No se pudo registrar la persona";
		
		} finally {
			conexion.desconectar();
		}
		
		return resultado;
		
	}
	
	public MascotaVo consultarMascota(Long idMascota) {
		
		Connection connection=null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement=null;
		ResultSet result=null;
		
		MascotaVo miMascotaB=null;
		
		connection=miConexion.getConnection();
		
		String consulta="SELECT * FROM mascotas where id_mascotas= ? ";
		
		try {
			
			if(connection!=null) {
				statement=connection.prepareStatement(consulta);
				statement.setLong(1, idMascota);
				result=statement.executeQuery();
				
				while(result.next()==true) {
					
					miMascotaB=new MascotaVo();
					miMascotaB.setIdMascota(result.getLong("id_mascotas"));
					miMascotaB.setNombre(result.getString("nombre"));
					miMascotaB.setColorMascota(result.getString("color"));
					miMascotaB.setRaza(result.getString("raza"));
					miMascotaB.setSexo(result.getString("sexo"));
					miMascotaB.setIdDueno(result.getLong("persona_id"));
				}
				
				miConexion.desconectar();
				
			}else {
				miMascotaB=null;
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error en la consulta de la persona: "+e.getMessage());
		}
		return miMascotaB;
		
		
	}
	
	public void imprimirMascota() {
		
	}
	
	public void actualizarMascota() {
		
	}

	public void eliminarMascota() {
		
	}
	
}
