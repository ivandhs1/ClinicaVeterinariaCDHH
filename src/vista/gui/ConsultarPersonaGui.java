package vista.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import controlador.Coordinador;
import modelo.vo.PersonaVo;

public class ConsultarPersonaGui extends JDialog implements ActionListener {

	Coordinador miCoordinador;
	private final JPanel contentPanel = new JPanel();
	JLabel lblDocumento, lblNombre, lblTelefono, lblProfesion, lblTipo, lblDatosNacimiento, lblFechaNacimiento,
			lblCiudad, lblDepartamento, lblPais;
	JTextField txtDocumento, txtNombre, txtTelefono, txtProfesion, txtTipo, txtDia, txtMes, txtAnnio, txtCiudad,
			txtDepartamento, txtPais;
	JButton btnBuscar, btnCancelar;

	public void setCoordinador(Coordinador miCoordinador) {
		// TODO Auto-generated method stub
		this.miCoordinador = miCoordinador;
	}

	public ConsultarPersonaGui(VentanaPrincipal miVentanaPrincipal, boolean modal) {
		// TODO Auto-generated constructor stub
		super(miVentanaPrincipal, modal);
		setSize(622, 449);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		iniciarComponentes();
		setTitle("Consulta de Personas");

	}

	public void iniciarComponentes() {
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblTitulo = new JLabel("CONSULTAR PERSONAS");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblTitulo.setBounds(10, 10, 599, 28);
		contentPanel.add(lblTitulo);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(10, 49, 588, 344);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblDocumento = new JLabel("Documento:");
		lblDocumento.setBounds(240, 22, 71, 21);
		panel.add(lblDocumento);

		txtDocumento = new JTextField();
		txtDocumento.setBounds(325, 22, 112, 20);
		panel.add(txtDocumento);
		txtDocumento.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(24, 67, 71, 21);
		panel.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(99, 66, 460, 21);
		panel.add(txtNombre);

		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(24, 107, 71, 21);
		panel.add(lblTelefono);

		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(99, 107, 86, 20);
		panel.add(txtTelefono);

		JLabel lblProfesion = new JLabel("Profesion:");
		lblProfesion.setBounds(195, 106, 71, 21);
		panel.add(lblProfesion);

		txtProfesion = new JTextField();
		txtProfesion.setColumns(10);
		txtProfesion.setBounds(259, 107, 167, 20);
		panel.add(txtProfesion);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(442, 107, 71, 21);
		panel.add(lblTipo);

		txtTipo = new JTextField();
		txtTipo.setColumns(10);
		txtTipo.setBounds(473, 107, 86, 20);
		panel.add(txtTipo);

		JPanel panelNacimiento = new JPanel();
		panelNacimiento.setBorder(
				new TitledBorder(null, "Datos de Nacimiento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelNacimiento.setBounds(24, 139, 538, 109);
		panel.add(panelNacimiento);
		panelNacimiento.setLayout(null);

		JLabel lblFecha = new JLabel("Fecha (dd/mm/aaaa):");
		lblFecha.setBounds(10, 29, 122, 14);
		panelNacimiento.add(lblFecha);

		txtDia = new JTextField();
		txtDia.setBounds(142, 28, 25, 20);
		panelNacimiento.add(txtDia);
		txtDia.setColumns(10);

		txtMes = new JTextField();
		txtMes.setColumns(10);
		txtMes.setBounds(190, 28, 25, 20);
		panelNacimiento.add(txtMes);

		txtAnnio = new JTextField();
		txtAnnio.setColumns(10);
		txtAnnio.setBounds(238, 28, 54, 20);
		panelNacimiento.add(txtAnnio);

		JLabel lblNewLabel_1 = new JLabel("/");
		lblNewLabel_1.setBounds(177, 31, 38, 14);
		panelNacimiento.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("/");
		lblNewLabel_1_1.setBounds(224, 31, 38, 14);
		panelNacimiento.add(lblNewLabel_1_1);

		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setBounds(10, 59, 71, 21);
		panelNacimiento.add(lblCiudad);

		txtCiudad = new JTextField();
		txtCiudad.setColumns(10);
		txtCiudad.setBounds(74, 59, 86, 20);
		panelNacimiento.add(txtCiudad);

		JLabel lblDepartamento = new JLabel("Departamento:");
		lblDepartamento.setBounds(185, 59, 92, 21);
		panelNacimiento.add(lblDepartamento);

		txtDepartamento = new JTextField();
		txtDepartamento.setColumns(10);
		txtDepartamento.setBounds(281, 59, 86, 20);
		panelNacimiento.add(txtDepartamento);

		JLabel lblPais = new JLabel("Pais:");
		lblPais.setBounds(385, 59, 54, 21);
		panelNacimiento.add(lblPais);

		txtPais = new JTextField();
		txtPais.setColumns(10);
		txtPais.setBounds(424, 59, 86, 20);
		panelNacimiento.add(txtPais);

		JSeparator separator = new JSeparator();
		separator.setBounds(24, 281, 538, 12);
		panel.add(separator);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(473, 297, 89, 23);
		btnCancelar.addActionListener(this);
		btnCancelar.setBackground(new Color(255, 192, 203));
		panel.add(btnCancelar);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(447, 22, 112, 21);
		btnBuscar.addActionListener(this);
		btnBuscar.setBackground(SystemColor.activeCaption);
		panel.add(btnBuscar);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnBuscar) {

			Long idDocumento = Long.parseLong(txtDocumento.getText());
			PersonaVo p = miCoordinador.setConsultarPersonaGui(idDocumento);

			if (p != null) {
				p.setNacimiento(miCoordinador.consultarNacimiento(p.getNacimiento().getIdNacimiento()));
				System.out.println(p);
				txtNombre.setText(p.getNombre());
				txtProfesion.setText(p.getProfesion());
				txtTelefono.setText(p.getTelefono());
				txtTipo.setText(p.getTipo() + "");
				txtCiudad.setText(p.getNacimiento().getCiudadNacimiento());
				txtDepartamento.setText(p.getNacimiento().getDepartamentoNacimiento());
				txtPais.setText(p.getNacimiento().getPaisNacimiento());
				txtDia.setText(p.getNacimiento().getFechaNacimiento().getDayOfMonth() + "");
				txtMes.setText(p.getNacimiento().getFechaNacimiento().getMonthValue() + "");
				txtAnnio.setText(p.getNacimiento().getFechaNacimiento().getYear() + "");

			} else {
				JOptionPane.showMessageDialog(null, "No se encuentra la persona, verifique el documento",
						"ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);
			}
		} else if (e.getSource() == btnCancelar) {
			this.dispose();
		}
	}

}
