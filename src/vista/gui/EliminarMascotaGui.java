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
import modelo.vo.MascotaVo;

public class EliminarMascotaGui extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField txtIdDueno;
	private JTextField txtNombre;
	private JTextField txtRaza;
	private JButton btnCancelar, btnBuscar;
	private Coordinador miCoordinador;
	private JTextField txtIdMascota;
	private JTextField txtSexo;
	private JTextField txtColor;
	private JButton btnEliminar;
	private JLabel lblseguro;
	private JButton btnNo;
	private JButton btnSi;
	private MascotaVo p;

	

	public EliminarMascotaGui(VentanaPrincipal miVentanaPrincipal, boolean modal) {
		setSize( 408, 331);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		setTitle("Gestion de Mascotas");
		iniciarComponentes();
		
	}
	

	private void iniciarComponentes() {
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblEliminarMascotas = new JLabel("ELIMINAR MASCOTAS");
		lblEliminarMascotas.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminarMascotas.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblEliminarMascotas.setBounds(10, 13, 372, 28);
		contentPanel.add(lblEliminarMascotas);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(10, 52, 370, 232);
		contentPanel.add(panel);
		
		JLabel lblDueno = new JLabel("Id Due\u00F1o:");
		lblDueno.setBounds(24, 58, 71, 21);
		panel.add(lblDueno);
		
		txtIdDueno = new JTextField();
		txtIdDueno.setEnabled(false);
		txtIdDueno.setText("");
		txtIdDueno.setColumns(10);
		txtIdDueno.setBounds(88, 58, 86, 20);
		panel.add(txtIdDueno);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(24, 96, 71, 21);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setEnabled(false);
		txtNombre.setColumns(10);
		txtNombre.setBounds(88, 96, 86, 20);
		panel.add(txtNombre);
		
		JLabel lblRaza = new JLabel("Raza:");
		lblRaza.setBounds(214, 96, 71, 21);
		panel.add(lblRaza);
		
		txtRaza = new JTextField();
		txtRaza.setEnabled(false);
		txtRaza.setColumns(10);
		txtRaza.setBounds(269, 96, 86, 20);
		panel.add(txtRaza);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(24, 175, 331, 12);
		panel.add(separator);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(269, 198, 89, 23);
		btnCancelar.addActionListener(this);
		panel.add(btnCancelar);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(24, 131, 71, 21);
		panel.add(lblSexo);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setBounds(214, 131, 71, 21);
		panel.add(lblColor);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(266, 16, 89, 23);
		btnBuscar.addActionListener(this);
		panel.add(btnBuscar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(new Color(255, 192, 203));
		btnEliminar.setBounds(170, 198, 89, 23);
		btnEliminar.addActionListener(this);
		panel.add(btnEliminar);
		
		JLabel lblIdMascota = new JLabel("Id Mascota:");
		lblIdMascota.setBounds(88, 20, 72, 14);
		panel.add(lblIdMascota);
		
		txtIdMascota = new JTextField();
		txtIdMascota.setBounds(170, 17, 86, 20);
		panel.add(txtIdMascota);
		
		txtSexo = new JTextField();
		txtSexo.setEnabled(false);
		txtSexo.setBounds(88, 131, 86, 20);
		panel.add(txtSexo);
		
		txtColor = new JTextField();
		txtColor.setEnabled(false);
		txtColor.setBounds(269, 131, 86, 20);
		panel.add(txtColor);
		
		lblseguro = new JLabel("\u00BFSeguro?");
		lblseguro.setBounds(58, 175, 57, 21);
		panel.add(lblseguro);
		
		btnNo = new JButton("No");
		btnNo.setBackground(new Color(152, 251, 152));
		btnNo.setBounds(10, 196, 50, 23);
		btnNo.addActionListener(this);
		panel.add(btnNo);
		
		btnSi = new JButton("Si");
		btnSi.setBackground(new Color(255, 192, 203));
		btnSi.setBounds(93, 196, 50, 23);
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
			this.dispose();
		}if(e.getSource()==btnEliminar) {
			lblseguro.setVisible(true);
			btnNo.setVisible(true);
			btnSi.setVisible(true);
		}if(e.getSource()==btnBuscar) {
			if(txtIdMascota.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "El campo documento esta vacio.","ADVERTENCIA!!",JOptionPane.WARNING_MESSAGE);
			}else {
				Long idMascota = Long.parseLong(txtIdMascota.getText());
				MascotaVo miMascota = miCoordinador.consultarMascota(idMascota);
				
				if(miMascota!=null) {
					
					txtIdDueno.setText(miMascota.getIdDueno()+"");
					txtNombre.setText(miMascota.getNombre());
					txtRaza.setText(miMascota.getRaza());
					txtSexo.setText(miMascota.getSexo());
					txtColor.setText(miMascota.getColorMascota());
					btnEliminar.setVisible(true);
					
				}else {
					JOptionPane.showMessageDialog(null, "Mascota no existente");
				}
			}
			
			
		}if(e.getSource()==btnNo) {
			limpiar();
			btnEliminar.setVisible(false);
			lblseguro.setVisible(false);
			btnNo.setVisible(false);
			btnSi.setVisible(false);
		}if(e.getSource()==btnSi) {
			p = new MascotaVo();
			p.setIdMascota(Long.parseLong(txtIdMascota.getText()));
			String verificacionElM = miCoordinador.eliminarMascota(p);
			
			if(verificacionElM.equals("ok")) {
				
				JOptionPane.showMessageDialog(null, "Eliminacion Exitosa");
				this.dispose();
				
			}else {
				System.out.println("Ocurrio un error");
			}
			
		}
	}


	public void limpiar() {
		txtColor.setText("");
		txtIdDueno.setText("");
		txtIdMascota.setText("");
		txtNombre.setText("");
		txtRaza.setText("");
		txtSexo.setText("");
		lblseguro.setVisible(false);
		btnNo.setVisible(false);
		btnSi.setVisible(false);
		btnEliminar.setVisible(false);
		
	}


	public void setMiCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}
}
