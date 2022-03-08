package controlador;

import modelo.dao.MascotaDao;
import modelo.dao.NacimientoDao;
import modelo.dao.PersonaDao;
import modelo.dao.PersonaProductoDao;
import modelo.dao.ProductoDao;
import modelo.vo.NacimientoVo;
import modelo.vo.PersonaVo;
import vista.gui.ConsultarPersonaGui;
import vista.gui.RegistrarMascotasGui;
import vista.gui.RegistrarPersonasGui;
import vista.gui.RegistrarProductosGui;
import vista.gui.VentanaPrincipal;

public class Coordinador {
	
	VentanaPrincipal miVentanaPrincipal;
	RegistrarPersonasGui miRegistrarPersonasGui;
	RegistrarMascotasGui miRegistrarMascotasGui;
	RegistrarProductosGui miRegistrarProductosGui;
	ConsultarPersonaGui miConsultarPersonasGui;
	PersonaDao miPersonaDao;
	NacimientoDao miNacimiento;
	MascotaDao miMascotaDao;
	ProductoDao miProductoDao;
	PersonaProductoDao miPersonaProductoDao;
	

	public void setVentanaPrincipal(VentanaPrincipal miVentanaPrincipal) {
		// TODO Auto-generated method stub
		this.miVentanaPrincipal = miVentanaPrincipal;
		
	}

	public void setRegistrarPersonasGui(RegistrarPersonasGui miRegistrarPersonasGui) {
		// TODO Auto-generated method stub
		this.miRegistrarPersonasGui = miRegistrarPersonasGui;
	}

	public void setRegistrarMascotasGui(RegistrarMascotasGui miRegistrarMascotasGui) {
		// TODO Auto-generated method stub
		this.miRegistrarMascotasGui = miRegistrarMascotasGui;
	}

	public void setRegistrarProductosGui(RegistrarProductosGui miRegistrarProductosGui) {
		// TODO Auto-generated method stub
		this.miRegistrarProductosGui = miRegistrarProductosGui;
	}
	
	public void setConsultarPersonaGui(ConsultarPersonaGui miConsultarPersonaGui) {
		// TODO Auto-generated method stub
		this.miConsultarPersonasGui = miConsultarPersonaGui;
	}

	public void setPersonaDao(PersonaDao miPersonaDao) {
		// TODO Auto-generated method stub
		this.miPersonaDao = miPersonaDao;
	}

	public void setMascotaDao(MascotaDao miMascotaDao) {
		// TODO Auto-generated method stub
		this.miMascotaDao = miMascotaDao;
	}

	public void setNacimientoDao(NacimientoDao miNacimientoDao) {
		// TODO Auto-generated method stub
		this.miNacimiento = miNacimientoDao;
	}

	public void setProductoDao(ProductoDao miProductoDao) {
		// TODO Auto-generated method stub
		this.miProductoDao = miProductoDao;
	}

	public void setPersonaProductoDao(PersonaProductoDao miPersonaProductoDao) {
		// TODO Auto-generated method stub
		this.miPersonaProductoDao = miPersonaProductoDao;
	}

	public void mostrarVentanaRegistroPersonas() {
		// TODO Auto-generated method stub
		miRegistrarPersonasGui.setVisible(true);
	}

	public void mostrarVentanaRegistroMascotas() {
		// TODO Auto-generated method stub
		miRegistrarMascotasGui.setVisible(true);
	}

	
	public void mostrarVentanaConsultaPersonas() {
		// TODO Auto-generated method stub
		miConsultarPersonasGui.setVisible(true);
	}

	public String registrarPersona(PersonaVo miPersona) {
		// TODO Auto-generated method stub
		return miPersonaDao.registrarPersona(miPersona);
	}

	public Long registrarNacimiento(PersonaVo miPersona) {
		// TODO Auto-generated method stub
		return miNacimiento.registrarNacimiento(miPersona.getNacimiento());
	}

	public PersonaVo setConsultarPersonaGui(Long idDocumento) {
		// TODO Auto-generated method stub
		return miPersonaDao.consultarPersona(idDocumento);
	}

	public NacimientoVo consultarNacimiento(Long idNacimiento) {
		// TODO Auto-generated method stub
		return miNacimiento.consultarNacimiento(idNacimiento);
		
	}

	

	
}
