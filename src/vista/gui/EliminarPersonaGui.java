package vista.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JSeparator;

public class EliminarPersonaGui extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;

	public EliminarPersonaGui(VentanaPrincipal miVentanaPrincipal, boolean modal) {
		super(miVentanaPrincipal,modal);
		setSize( 622, 449);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		iniciarComponentes();
		setTitle("Eliminacion de Personas");
		
	}

	/**
	 * Create the dialog.
	 */
	public void iniciarComponentes() {
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblEditarPersonas = new JLabel("ELIMINAR PERSONAS");
		lblEditarPersonas.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditarPersonas.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblEditarPersonas.setBounds(10, 19, 599, 28);
		contentPanel.add(lblEditarPersonas);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(10, 58, 588, 344);
		contentPanel.add(panel);
		
		JLabel lblDocumento = new JLabel("Documento:");
		lblDocumento.setBounds(240, 22, 71, 21);
		panel.add(lblDocumento);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(325, 22, 112, 20);
		panel.add(textField);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(24, 67, 71, 21);
		panel.add(lblNombre);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		textField_1.setBounds(99, 66, 460, 21);
		panel.add(textField_1);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(24, 107, 71, 21);
		panel.add(lblTelefono);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setColumns(10);
		textField_2.setBounds(99, 107, 86, 20);
		panel.add(textField_2);
		
		JLabel lblProfesion = new JLabel("Profesion:");
		lblProfesion.setBounds(195, 106, 71, 21);
		panel.add(lblProfesion);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setColumns(10);
		textField_3.setBounds(259, 107, 167, 20);
		panel.add(textField_3);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setEnabled(false);
		lblTipo.setBounds(442, 107, 71, 21);
		panel.add(lblTipo);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(473, 107, 86, 20);
		panel.add(textField_4);
		
		JPanel panelNacimiento = new JPanel();
		panelNacimiento.setLayout(null);
		panelNacimiento.setBorder(new TitledBorder(null, "Datos de Nacimiento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelNacimiento.setBounds(24, 139, 538, 109);
		panel.add(panelNacimiento);
		
		JLabel lblFecha = new JLabel("Fecha (dd/mm/aaaa):");
		lblFecha.setBounds(10, 29, 122, 14);
		panelNacimiento.add(lblFecha);
		
		textField_5 = new JTextField();
		textField_5.setEnabled(false);
		textField_5.setColumns(10);
		textField_5.setBounds(142, 28, 25, 20);
		panelNacimiento.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setEnabled(false);
		textField_6.setColumns(10);
		textField_6.setBounds(190, 28, 25, 20);
		panelNacimiento.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setEnabled(false);
		textField_7.setColumns(10);
		textField_7.setBounds(238, 28, 54, 20);
		panelNacimiento.add(textField_7);
		
		JLabel lblNewLabel_1 = new JLabel("/");
		lblNewLabel_1.setBounds(177, 31, 38, 14);
		panelNacimiento.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("/");
		lblNewLabel_1_1.setBounds(224, 31, 38, 14);
		panelNacimiento.add(lblNewLabel_1_1);
		
		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setBounds(10, 59, 71, 21);
		panelNacimiento.add(lblCiudad);
		
		textField_8 = new JTextField();
		textField_8.setEnabled(false);
		textField_8.setColumns(10);
		textField_8.setBounds(74, 59, 86, 20);
		panelNacimiento.add(textField_8);
		
		JLabel lblDepartamento = new JLabel("Departamento:");
		lblDepartamento.setBounds(185, 59, 92, 21);
		panelNacimiento.add(lblDepartamento);
		
		textField_9 = new JTextField();
		textField_9.setEnabled(false);
		textField_9.setColumns(10);
		textField_9.setBounds(281, 59, 86, 20);
		panelNacimiento.add(textField_9);
		
		JLabel lblPais = new JLabel("Pais:");
		lblPais.setBounds(385, 59, 54, 21);
		panelNacimiento.add(lblPais);
		
		textField_10 = new JTextField();
		textField_10.setEnabled(false);
		textField_10.setColumns(10);
		textField_10.setBounds(424, 59, 86, 20);
		panelNacimiento.add(textField_10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(24, 281, 538, 12);
		panel.add(separator);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(473, 297, 89, 23);
		panel.add(btnCancelar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(447, 22, 112, 21);
		panel.add(btnBuscar);
	}
}
