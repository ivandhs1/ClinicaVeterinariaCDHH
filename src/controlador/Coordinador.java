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
import modelo.vo.PersonasProductosVo;
import modelo.vo.ProductoVo;
import vista.gui.ActualizarMascotaGui;
import vista.gui.ActualizarPersonaGui;
import vista.gui.ActualizarProducto;
import vista.gui.ConsultarMascotaGui;
import vista.gui.ConsultarPersonaGui;
import vista.gui.ConsultarProductoGui;
import vista.gui.EliminarMascotaGui;
import vista.gui.ListarPersonas;
import vista.gui.ListarProductos;
import vista.gui.EliminarPersonaGui;
import vista.gui.EliminarProducto;
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
	ActualizarProducto miActualizarProducto;
	EliminarProducto miEliminarProducto;
	ListarProductos miListarProductos;
	ConsultarMascotaGui miConsultarMascotaGui;
	private EliminarPersonaGui miEliminarPersonaGui;
	private ListarMascotasGui miListarMascotas;
	private EliminarMascotaGui miEliminarMascotaGui;
	private ActualizarMascotaGui miActualizarMascotaGui;
	private ConsultarProductoGui miConsultarProductoGui;

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
		miRegistrarPersonasGui.limpiar();
	}

	public void mostrarVentanaRegistroMascotas() {
		// TODO Auto-generated method stub
		miRegistrarMascotasGui.setVisible(true);
		miRegistrarMascotasGui.limpiar();
	}

	public void mostrarVentanaRegistroMascotas(long id) {
		miRegistrarMascotasGui.atraparid(id);
		miRegistrarMascotasGui.setVisible(true);
	}

	public void mostrarVentanaConsultaPersonas() {
		// TODO Auto-generated method stub
		miConsultarPersonasGui.setVisible(true);
		miConsultarPersonasGui.limpiar();
	}

	public void mostrarVentanaEliminarPersonas() {
		miEliminarPersonaGui.setVisible(true);
		miEliminarPersonaGui.limpiar();

	}
	public void mostrarVentanaEliminarMascota() {
		miEliminarMascotaGui.setVisible(true);
		miEliminarMascotaGui.limpiar();
	}

	public void mostrarActualizarPersonas() {
		miActualizarPersonaGui.setVisible(true);
		miActualizarPersonaGui.limpiar();
	}
	public void mostrarActualizarMascotas() {
		miActualizarMascotaGui.setVisible(true);
		miActualizarMascotaGui.limpiar();
		
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
	public String actualizarMascota(MascotaVo p) {
		return miMascotaDao.actualizarMascota(p);
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
	
	public void setMiActualizarProducto(ActualizarProducto miActualizarProducto) {
		this.miActualizarProducto = miActualizarProducto;
	}
	
	public void setMiEliminarProducto(EliminarProducto miEliminarProdcutos) {
		this.miEliminarProducto = miEliminarProdcutos;
	}
	
	public void setMiListarProductos(ListarProductos miListarProductos) {
		this.miListarProductos = miListarProductos;
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
	
	public void mostrarActualizarProductos() {
		miActualizarProducto.setVisible(true);
		miActualizarProducto.vaciar();
		miActualizarProducto.escirbir();
	}
	
	public void mostrarEliminarProductos() {
		miEliminarProducto.setVisible(true);
		miEliminarProducto.vaciar();
	}
	
	public void mostrarListarProductos() {
		miListarProductos.setVisible(true);
		miListarProductos.llenar(listarProductos());
	}

	public String eliminarMascota(MascotaVo p) {
		return miMascotaDao.eliminarMascota(p);
	}
	public String eliminarMascotaPorDuenno(PersonaVo p) {
		// TODO Auto-generated method stub
		return miMascotaDao.eliminarMascotaPorDuenno(p);
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
		miConsultarMascotaGui.limpiar();
	}

	public MascotaVo consultarMascota(Long idMascota) {
		// TODO Auto-generated method stub
		return miMascotaDao.consultarMascota(idMascota);
	}

	public void setMiEliminarMascotaGui(EliminarMascotaGui miEliminarMascotaGui) {
		this.miEliminarMascotaGui=miEliminarMascotaGui;
		
	}

	public void setMiActualizarMascotaGui(ActualizarMascotaGui miActualizarMascotaGui) {
		this.miActualizarMascotaGui=miActualizarMascotaGui;
		
	}

	public void mostrarVentanRegistroProducto() {
		// TODO Auto-generated method stub
		this.miRegistrarProductosGui.setVisible(true);
		miRegistrarProductosGui.limpiar();
	}

	public String registrarProducto(ProductoVo miProducto) {
		// TODO Auto-generated method stub
		return miProductoDao.registrarProducto(miProducto);
	}

	public void setMiConsultarProductoGui(ConsultarProductoGui miConsultarProductoGui) {
		// TODO Auto-generated method stub
		this.miConsultarProductoGui=miConsultarProductoGui;
	}

	public void mostrarVentanaConsultarProducto() {
		// TODO Auto-generated method stub
		miConsultarProductoGui.setVisible(true);
		miConsultarProductoGui.limpiar();
	}

	public ProductoVo consultarProducto(Long idProducto) {
		// TODO Auto-generated method stub
		return miProductoDao.consultarProducto(idProducto);
	}
	
	public String actualizarProducto(ProductoVo producto) {
		return miProductoDao.actualizarProducto(producto);
	}
	

	public String eliminarProducto(ProductoVo producto) {
		return miProductoDao.eliminarProducto(producto);
	}
	
	public ArrayList<ProductoVo> listarProductos(){
		return miProductoDao.imprimirProductos();
	}
	
	public PersonasProductosVo buscarPproducto(long codigo) {
		return miPersonaProductoDao.consultarProducto(codigo);
	}
	
	public String crearPproducto(PersonasProductosVo produc) {
	 return	miPersonaProductoDao.registrarProducto(produc);
	}
	
	public String actualizarPproducto(PersonasProductosVo produc) {
		return miPersonaProductoDao.actualizarProductos(produc);
	}
	
	public String eliminarPprodcuto(PersonasProductosVo produc) {
		return miPersonaProductoDao.eliminarProductos(produc);
	}
	
	public String eliminarProductosPerso(long id) {
		return miPersonaProductoDao.eliminarProductosP(id);
	}
	
	public String eliminarProporid(long id) {
	
		return	 miProductoDao.eliminarProductop(id);
	
	}
	
	public ArrayList<Long> consultarproductos(long id){
		return miPersonaProductoDao.selecionarProductos(id);
	}

}