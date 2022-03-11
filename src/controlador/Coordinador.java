package controlador;

import java.util.ArrayList;

import modelo.dao.MascotaDao;
import modelo.dao.NacimientoDao;
import modelo.dao.PersonaDao;
import modelo.dao.PersonaProductoDao;
import modelo.dao.ProductoDao;
import modelo.vo.MascotaVo;
import modelo.vo.NacimientoVo;
import modelo.vo.PersonaVo;
import vista.gui.ActualizarPersonaGui;
import vista.gui.ConsultarMascotaGui;
import vista.gui.ConsultarPersonaGui;
import vista.gui.ListarPersonas;
import vista.gui.EliminarPersonaGui;
import vista.gui.ListarMascotasGui;
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
	ActualizarPersonaGui miActualizarPersonaGui;
	PersonaDao miPersonaDao;
	NacimientoDao miNacimientoDao;
	MascotaDao miMascotaDao;
	ProductoDao miProductoDao;
	PersonaProductoDao miPersonaProductoDao;
	ListarPersonas miListarPersonas;
	ConsultarMascotaGui miConsultarMascotaGui;
	private EliminarPersonaGui miEliminarPersonaGui;
	private ListarMascotasGui miListarMascotas;

	public void setVentanaPrincipal(VentanaPrincipal miVentanaPrincipal) {
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

	public void setActualizarPersonaGui(ActualizarPersonaGui miActualizarPersonaGui) {
		// TODO Auto-generated method stub
		this.miActualizarPersonaGui = miActualizarPersonaGui;
	}

	public void setConsultarMascotaGui(ConsultarMascotaGui miConsultarMascotaGui) {
		// TODO Auto-generated method stub
		this.miConsultarMascotaGui = miConsultarMascotaGui;
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
		this.miNacimientoDao = miNacimientoDao;
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

	public void mostrarVentanaRegistroMascotas(long id) {
		miRegistrarMascotasGui.atraparid(id);
		miRegistrarMascotasGui.setVisible(true);
	}

	public void mostrarVentanaConsultaPersonas() {
		// TODO Auto-generated method stub
		miConsultarPersonasGui.setVisible(true);
	}

	public void mostrarVentanaEliminarPersonas() {
		miEliminarPersonaGui.setVisible(true);
		miEliminarPersonaGui.limpiar();

	}

	public void mostrarActualizarPersonas() {
		miActualizarPersonaGui.setVisible(true);
		miActualizarPersonaGui.limpiar();
	}

	public String registrarPersona(PersonaVo miPersona) {
		// TODO Auto-generated method stub
		return miPersonaDao.registrarPersona(miPersona);
	}

	public Long registrarNacimiento(PersonaVo miPersona) {
		// TODO Auto-generated method stub
		return miNacimientoDao.registrarNacimiento(miPersona.getNacimiento());
	}

	public PersonaVo setConsultarPersonaGui(Long idDocumento) {
		// TODO Auto-generated method stub
		return miPersonaDao.consultarPersona(idDocumento);
	}

	public NacimientoVo consultarNacimiento(Long idNacimiento) {
		// TODO Auto-generated method stub
		return miNacimientoDao.consultarNacimiento(idNacimiento);

	}

	public String actualizarNacimiento(NacimientoVo miNacimiento) {
		return miNacimientoDao.actualizarNacimiento(miNacimiento);
	}

	public String actualizarPersona(PersonaVo p) {
		// TODO Auto-generated method stub
		return miPersonaDao.actualizarPersona(p);
	}

	public void mostrarListarPersonas() {
		ArrayList<PersonaVo> personas = miPersonaDao.imprimirPersonas();
		miListarPersonas.setVisible(true);
		miListarPersonas.llenar(personas);
	}

	public void mostrarListarMascotas() {
		ArrayList<MascotaVo> mascotas = miMascotaDao.imprimirMascotas();
		miListarMascotas.setVisible(true);
		miListarMascotas.llenar(mascotas);
	}

	public void setMiListarPersonas(ListarPersonas miListarPersonas) {
		this.miListarPersonas = miListarPersonas;
	}

	public void setMiConsultarPersonasGui(ConsultarPersonaGui miConsultarPersonasGui) {
		this.miConsultarPersonasGui = miConsultarPersonasGui;
	}

	public void setMiActualizarPersonaGui(ActualizarPersonaGui miActualizarPersonaGui) {
		this.miActualizarPersonaGui = miActualizarPersonaGui;
	}

	public void setEliminarPersonaGui(EliminarPersonaGui miEliminarPersonaGui) {
		this.miEliminarPersonaGui = miEliminarPersonaGui;

	}

	public String eliminarPersona(PersonaVo p) {
		return miPersonaDao.eliminarPersona(p);
	}

	public void setMiListarMascotas(ListarMascotasGui miListarMascotas) {
		this.miListarMascotas = miListarMascotas;

	}

	public String RegistrarMascotasGui(MascotaVo miMascota) {
		// TODO Auto-generated method stub
		return miMascotaDao.registrarMascota(miMascota);
	}

	public void mostrarVentanaConsultarMascota() {
		// TODO Auto-generated method stub
		miConsultarMascotaGui.setVisible(true);
	}

	public MascotaVo consultarMascota(Long idMascota) {
		// TODO Auto-generated method stub
		return miMascotaDao.consultarMascota(idMascota);
	}

}