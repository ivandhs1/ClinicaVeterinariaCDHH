package controlador;

import modelo.dao.MascotaDao;
import modelo.dao.NacimientoDao;
import modelo.dao.PersonaDao;
import modelo.dao.PersonaProductoDao;
import modelo.dao.ProductoDao;
import vista.gui.ActualizarPersonaGui;
import vista.gui.ConsultarPersonaGui;
import vista.gui.EliminarPersonaGui;
import vista.gui.RegistrarMascotasGui;
import vista.gui.RegistrarPersonasGui;
import vista.gui.RegistrarProductosGui;
import vista.gui.VentanaPrincipal;

public class Relaciones {

	public Relaciones() {

		// se declaran las clases que van a representar instancias unicas

		VentanaPrincipal miVentanaPrincipal;
		RegistrarPersonasGui miRegistrarPersonasGui;
		RegistrarMascotasGui miRegistrarMascotasGui;
		RegistrarProductosGui miRegistrarProductosGui;
		Coordinador miCoordinador;
		PersonaDao miPersonaDao;
		NacimientoDao miNacimientoDao;
		MascotaDao miMascotaDao;
		ProductoDao miProductoDao;
		PersonaProductoDao miPersonaProductoDao;
		ConsultarPersonaGui miConsultarPersonaGui;
		EliminarPersonaGui miEliminarPersonaGui;
		ActualizarPersonaGui miActualizarPersonaGui;

		// se instacian por unica ocasion las clases declaradas

		miVentanaPrincipal = new VentanaPrincipal();
		miRegistrarPersonasGui = new RegistrarPersonasGui(miVentanaPrincipal, true);
		miRegistrarMascotasGui = new RegistrarMascotasGui(miVentanaPrincipal, true, "");
		miRegistrarProductosGui = new RegistrarProductosGui(miVentanaPrincipal, true);
		miConsultarPersonaGui = new ConsultarPersonaGui(miVentanaPrincipal, true);
		miEliminarPersonaGui = new EliminarPersonaGui(miVentanaPrincipal, true);

		miActualizarPersonaGui = new ActualizarPersonaGui(miVentanaPrincipal, true);
		miCoordinador = new Coordinador();
		miPersonaDao = new PersonaDao();
		miMascotaDao = new MascotaDao();
		miNacimientoDao = new NacimientoDao();
		miProductoDao = new ProductoDao();
		miPersonaProductoDao = new PersonaProductoDao();

		// Se establece la relacion entre el coordinador y cada instancia unica

		// al coordinador se le asigna el control de cada clase unica

		miCoordinador.setVentanaPrincipal(miVentanaPrincipal);
		miCoordinador.setEliminarPersonaGui(miEliminarPersonaGui);
		miCoordinador.setRegistrarPersonasGui(miRegistrarPersonasGui);
		miCoordinador.setRegistrarMascotasGui(miRegistrarMascotasGui);
		miCoordinador.setRegistrarProductosGui(miRegistrarProductosGui);
		miCoordinador.setConsultarPersonaGui(miConsultarPersonaGui);
		miCoordinador.setActualizarPersonaGui(miActualizarPersonaGui);
		miCoordinador.setPersonaDao(miPersonaDao);
		miCoordinador.setMascotaDao(miMascotaDao);
		miCoordinador.setNacimientoDao(miNacimientoDao);
		miCoordinador.setProductoDao(miProductoDao);
		miCoordinador.setPersonaProductoDao(miPersonaProductoDao);

		// a cada clase unica se le asigna la unica instancia del coordinador

		miVentanaPrincipal.setCoordinador(miCoordinador);
		miRegistrarPersonasGui.setCoordinador(miCoordinador);
		miEliminarPersonaGui.setCoordinador(miCoordinador);
		miRegistrarMascotasGui.setCoordinador(miCoordinador);
		miRegistrarProductosGui.setCoordinador(miCoordinador);
		miConsultarPersonaGui.setCoordinador(miCoordinador);
		miActualizarPersonaGui.setCoordinador(miCoordinador);
		miPersonaDao.setCoordinador(miCoordinador);
		miNacimientoDao.setCoordinador(miCoordinador);
		miMascotaDao.setCoordinador(miCoordinador);
		miProductoDao.setCoordinador(miCoordinador);
		miPersonaProductoDao.setCoordinador(miCoordinador);

		miVentanaPrincipal.setVisible(true);
	}

}
