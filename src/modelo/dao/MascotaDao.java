package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

	
	public void registrarMascota() {
		// TODO Auto-generated method stub
		
	}
	
	public void consultarMascota() {
		
	}
	
	public void imprimirMascota() {
		
	}
	
	public void actualizarMascota() {
		
	}

	public void eliminarMascota() {
		
	}


	public ArrayList<MascotaVo> imprimirMascotas() {
		ArrayList<MascotaVo> mascotas = new ArrayList<MascotaVo>();
		Connection connection=null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement=null;
		ResultSet result=null;
		
		MascotaVo miMascota=null;
		
		connection=miConexion.getConnection();
		
		String consulta="SELECT * FROM mascotas";
		
		try {
			
			if(connection!=null) {
				statement=connection.prepareStatement(consulta);

				result=statement.executeQuery();
				
				while(result.next()==true) {
					miMascota=new MascotaVo();
					
					miMascota.setIdMascota(result.getLong("id_mascotas"));
					miMascota.setColorMascota(result.getString("color"));
					miMascota.setNombre(result.getString("nombre"));
					miMascota.setRaza(result.getString("raza"));
					miMascota.setSexo(result.getString("sexo"));
					miMascota.setPersonaId(result.getString("persona_id"));
					
					mascotas.add(miMascota);
				}
				
				miConexion.desconectar();
				
			}else {
				miMascota=null;
			}
			
			
		} catch (SQLException e) {
			System.out.println("Error en la consulta de la mascota: "+e.getMessage());
		}
		return mascotas;
	}
	
}
