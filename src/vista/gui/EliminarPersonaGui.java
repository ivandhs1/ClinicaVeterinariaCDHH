package vista.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controlador.Coordinador;
import modelo.vo.PersonaVo;

import javax.swing.JSeparator;
import java.awt.Color;

public class EliminarPersonaGui extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField txtDocumento;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtProfesion;
	private JTextField txtTipo;
	private JTextField txtDia;
	private JTextField txtMes;
	private JTextField txtAnnio;
	private JTextField txtCiudad;
	private JTextField txtDepartamento;
	private JTextField txtPais;
	private JButton btnCancelar, btnBuscar, btnNo, btnSi, btnEliminar;
	private JLabel lblseguro;
	private Coordinador miCoordinador;
	PersonaVo p;

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
		
		txtDocumento = new JTextField();
		txtDocumento.setColumns(10);
		txtDocumento.setBounds(325, 22, 112, 20);
		panel.add(txtDocumento);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(24, 67, 71, 21);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setEnabled(false);
		txtNombre.setColumns(10);
		txtNombre.setBounds(99, 66, 460, 21);
		panel.add(txtNombre);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(24, 107, 71, 21);
		panel.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setEnabled(false);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(99, 107, 86, 20);
		panel.add(txtTelefono);
		
		JLabel lblProfesion = new JLabel("Profesion:");
		lblProfesion.setBounds(195, 106, 71, 21);
		panel.add(lblProfesion);
		
		txtProfesion = new JTextField();
		txtProfesion.setEnabled(false);
		txtProfesion.setColumns(10);
		txtProfesion.setBounds(259, 107, 167, 20);
		panel.add(txtProfesion);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setEnabled(false);
		lblTipo.setBounds(442, 107, 71, 21);
		panel.add(lblTipo);
		
		txtTipo = new JTextField();
		txtTipo.setEnabled(false);
		txtTipo.setColumns(10);
		txtTipo.setBounds(473, 107, 86, 20);
		panel.add(txtTipo);
		
		JPanel panelNacimiento = new JPanel();
		panelNacimiento.setLayout(null);
		panelNacimiento.setBorder(new TitledBorder(null, "Datos de Nacimiento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelNacimiento.setBounds(24, 139, 538, 109);
		panel.add(panelNacimiento);
		
		JLabel lblFecha = new JLabel("Fecha (dd/mm/aaaa):");
		lblFecha.setBounds(10, 29, 122, 14);
		panelNacimiento.add(lblFecha);
		
		txtDia = new JTextField();
		txtDia.setEnabled(false);
		txtDia.setColumns(10);
		txtDia.setBounds(142, 28, 25, 20);
		panelNacimiento.add(txtDia);
		
		txtMes = new JTextField();
		txtMes.setEnabled(false);
		txtMes.setColumns(10);
		txtMes.setBounds(190, 28, 25, 20);
		panelNacimiento.add(txtMes);
		
		txtAnnio = new JTextField();
		txtAnnio.setEnabled(false);
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
		txtCiudad.setEnabled(false);
		txtCiudad.setColumns(10);
		txtCiudad.setBounds(74, 59, 86, 20);
		panelNacimiento.add(txtCiudad);
		
		JLabel lblDepartamento = new JLabel("Departamento:");
		lblDepartamento.setBounds(185, 59, 92, 21);
		panelNacimiento.add(lblDepartamento);
		
		txtDepartamento = new JTextField();
		txtDepartamento.setEnabled(false);
		txtDepartamento.setColumns(10);
		txtDepartamento.setBounds(281, 59, 86, 20);
		panelNacimiento.add(txtDepartamento);
		
		JLabel lblPais = new JLabel("Pais:");
		lblPais.setBounds(385, 59, 54, 21);
		panelNacimiento.add(lblPais);
		
		txtPais = new JTextField();
		txtPais.setEnabled(false);
		txtPais.setColumns(10);
		txtPais.setBounds(424, 59, 86, 20);
		panelNacimiento.add(txtPais);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(24, 281, 538, 12);
		panel.add(separator);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(473, 297, 89, 23);
		btnCancelar.addActionListener(this);
		panel.add(btnCancelar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(447, 22, 112, 21);
		btnBuscar.addActionListener(this);
		panel.add(btnBuscar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(new Color(255, 192, 203));
		btnEliminar.setBounds(374, 298, 89, 23);
		btnEliminar.addActionListener(this);
		panel.add(btnEliminar);
		
		lblseguro = new JLabel("\u00BFSeguro?");
		lblseguro.setBounds(93, 282, 57, 21);
		panel.add(lblseguro);
		
		btnNo = new JButton("No");
		btnNo.setBackground(new Color(152, 251, 152));
		btnNo.setBounds(45, 303, 50, 23);
		btnNo.addActionListener(this);
		panel.add(btnNo);
		
		btnSi = new JButton("Si");
		btnSi.setBackground(new Color(255, 192, 203));
		btnSi.setBounds(128, 303, 50, 23);
		btnSi.addActionListener(this);
		panel.add(btnSi);
		lblseguro.setVisible(false);
		btnNo.setVisible(false);
		btnSi.setVisible(false);
		btnEliminar.setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnCancelar) {
			
			limpiar();
			btnEliminar.setVisible(false);
			lblseguro.setVisible(false);
			btnNo.setVisible(false);
			btnSi.setVisible(false);
		}if(e.getSource()==btnEliminar) {
			lblseguro.setVisible(true);
			btnNo.setVisible(true);
			btnSi.setVisible(true);
		}if(e.getSource()==btnBuscar) {
			if(txtDocumento.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "El campo documento esta vacio.","ADVERTENCIA!!",JOptionPane.WARNING_MESSAGE);
			}else {
				Long idDocumento=Long.parseLong(txtDocumento.getText());
				p=miCoordinador.setConsultarPersonaGui(idDocumento);
				
				if(p!=null) {
					p.setNacimiento(miCoordinador.consultarNacimiento(p.getNacimiento().getIdNacimiento()));
					System.out.println(p);
					txtDocumento.setText((p.getIdPersona())+"");
					txtNombre.setText(p.getNombre());
					txtProfesion.setText(p.getProfesion());
					txtTelefono.setText(p.getTelefono());
					txtTipo.setText(p.getTipo()+"");
					txtCiudad.setText(p.getNacimiento().getCiudadNacimiento());
					txtDepartamento.setText(p.getNacimiento().getDepartamentoNacimiento());
					txtPais.setText(p.getNacimiento().getPaisNacimiento());
					txtDia.setText(p.getNacimiento().getFechaNacimiento().getDayOfMonth()+"");
					txtMes.setText(p.getNacimiento().getFechaNacimiento().getMonthValue()+"");
					txtAnnio.setText(p.getNacimiento().getFechaNacimiento().getYear()+"");
					System.out.println("persona buscada--"+p);
					btnEliminar.setVisible(true);
					
				}else {
					JOptionPane.showMessageDialog(null, "No se encuentra la persona, verifique el documento","ADVERTENCIA!!",JOptionPane.WARNING_MESSAGE);
					btnEliminar.setVisible(false);
				}
			}
			
		}if(e.getSource()==btnNo) {
			limpiar();
			btnEliminar.setVisible(false);
			lblseguro.setVisible(false);
			btnNo.setVisible(false);
			btnSi.setVisible(false);
		}if(e.getSource()==btnSi) {
			p.setIdPersona(Long.parseLong(txtDocumento.getText()));
			String verificacionEl = miCoordinador.eliminarPersona(p);
			
			if(verificacionEl.equals("ok")) {
				
				JOptionPane.showMessageDialog(null, "Eliminacion Exitosa");
				this.dispose();
				
			}else {
				System.out.println("Ocurrio un error");
			}
			
		}
		
	}
	public void limpiar() {
		txtDocumento.setText("");
		txtNombre.setText("");
		txtProfesion.setText("");
		txtTelefono.setText("");
		txtTipo.setText("");
		txtAnnio.setText("");
		txtMes.setText("");
		txtDia.setText("");
		txtDepartamento.setText("");
		txtPais.setText("");
		txtCiudad.setText("");
		lblseguro.setVisible(false);
		btnNo.setVisible(false);
		btnSi.setVisible(false);
		btnEliminar.setVisible(false);
	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
		
	}
}
