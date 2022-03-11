package vista.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
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

import controlador.Coordinador;

public class EliminarMascotaGui extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField txtIdDueno;
	private JTextField txtNombre;
	private JTextField txtRaza;
	private JButton btnCancelar;
	private JButton btnEliminar;
	private Coordinador miCoordinador;
	private JLabel lblseguro;
	private JButton btnNo;
	private JButton btnSi;
	private JComboBox txtColor;
	private JComboBox txtSexo;
	private JTextField txtIdMascota;

	

	public EliminarMascotaGui(VentanaPrincipal miVentanaPrincipal, boolean modal) {
		super(miVentanaPrincipal,modal);
		setSize( 408, 288);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		setTitle("Eliminacion de Mascotas");
		iniciarComponentes();
		
	}
	

	private void iniciarComponentes() {
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblTitulo = new JLabel("GESTIONAR MASCOTAS");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblTitulo.setBounds(10, 10, 372, 28);
		contentPanel.add(lblTitulo);
				
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(10, 49, 370, 192);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblDueno = new JLabel("Id Due\u00F1o:");
		lblDueno.setBounds(199, 17, 71, 21);
		panel.add(lblDueno);
		
		txtIdDueno = new JTextField();
		txtIdDueno.setText("");
		txtIdDueno.setBounds(269, 17, 86, 20);
		panel.add(txtIdDueno);
		txtIdDueno.setColumns(10);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(new Color(255, 192, 203));
		btnEliminar.setBounds(172, 150, 89, 23);
		btnEliminar.addActionListener(this);
		panel.add(btnEliminar);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(24, 49, 71, 21);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(88, 49, 86, 20);
		panel.add(txtNombre);
		
		JLabel lblRaza = new JLabel("Raza:");
		lblRaza.setBounds(214, 49, 71, 21);
		panel.add(lblRaza);
		
		txtRaza = new JTextField();
		txtRaza.setColumns(10);
		txtRaza.setBounds(269, 49, 86, 20);
		panel.add(txtRaza);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(24, 127, 331, 12);
		panel.add(separator);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(24, 81, 71, 21);
		panel.add(lblSexo);
		
		txtSexo = new JComboBox();
		txtSexo.setModel(new DefaultComboBoxModel(new String[] {"Macho", "Hembra"}));
		txtSexo.setBounds(88, 81, 86, 22);
		panel.add(txtSexo);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setBounds(214, 82, 71, 21);
		panel.add(lblColor);
		
		txtColor = new JComboBox();
		txtColor.setModel(new DefaultComboBoxModel(new String[] {"Blanco", "Negro", "Caf\u00E9", "Gris", "Manchas"}));
		txtColor.setBounds(269, 81, 86, 22);
		panel.add(txtColor);
		
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
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(271, 150, 89, 23);
		panel.add(btnCancelar);
		
		txtIdMascota = new JTextField();
		txtIdMascota.setColumns(10);
		txtIdMascota.setBounds(88, 17, 86, 20);
		panel.add(txtIdMascota);
		
		JLabel lblIdMascota = new JLabel("Id Mascota:");
		lblIdMascota.setBounds(24, 17, 71, 21);
		panel.add(lblIdMascota);
		
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


	private void limpiar() {
		txtColor.setSelectedIndex(0);
		txtIdDueno.setText("");
		txtIdMascota.setText("");
		txtNombre.setText("");
		txtRaza.setText("");
		txtSexo.setSelectedIndex(0);
		
	}
}
