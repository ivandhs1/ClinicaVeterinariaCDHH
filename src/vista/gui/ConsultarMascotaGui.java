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

import controlador.Coordinador;
import modelo.vo.MascotaVo;

public class ConsultarMascotaGui extends JDialog implements ActionListener{
	
	private final JPanel contentPanel = new JPanel();
	private JTextField txtIdDueno;
	private JTextField txtNombre;
	private JTextField txtRaza;
	private JButton btnCancelar, btnBuscar;
	private Coordinador miCoordinador;
	private JTextField txtIdMascota;
	private JTextField txtSexo;
	private JTextField txtColor;


	/**
	 * Create the dialog.
	 * @param b 
	 * @param ventanaPrincipal 
	 * @param documento 
	 */
	public ConsultarMascotaGui(VentanaPrincipal ventanaPrincipal, boolean modal) {
		super(ventanaPrincipal,modal);
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
		
		JLabel lblTitulo = new JLabel("GESTIONAR MASCOTAS");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblTitulo.setBounds(10, 10, 372, 28);
		contentPanel.add(lblTitulo);
				
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(10, 49, 370, 232);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblDueno = new JLabel("Id Due\u00F1o:");
		lblDueno.setBounds(24, 58, 71, 21);
		panel.add(lblDueno);
		
		txtIdDueno = new JTextField();
		txtIdDueno.setText("");
		txtIdDueno.setBounds(88, 58, 86, 20);
		panel.add(txtIdDueno);
		txtIdDueno.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(24, 96, 71, 21);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(88, 96, 86, 20);
		panel.add(txtNombre);
		
		JLabel lblRaza = new JLabel("Raza:");
		lblRaza.setBounds(214, 96, 71, 21);
		panel.add(lblRaza);
		
		txtRaza = new JTextField();
		txtRaza.setColumns(10);
		txtRaza.setBounds(269, 96, 86, 20);
		panel.add(txtRaza);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(24, 175, 331, 12);
		panel.add(separator);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(269, 198, 89, 23);
		btnCancelar.setBackground(new Color(255, 192, 203));
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
		btnBuscar.setBackground(SystemColor.activeCaption);
		panel.add(btnBuscar);
		
		JLabel lblIdMascota = new JLabel("Id Mascota:");
		lblIdMascota.setBounds(88, 20, 72, 14);
		panel.add(lblIdMascota);
		
		txtIdMascota = new JTextField();
		txtIdMascota.setBounds(170, 17, 86, 20);
		panel.add(txtIdMascota);
		
		txtSexo = new JTextField();
		txtSexo.setBounds(88, 131, 86, 20);
		panel.add(txtSexo);
		
		txtColor = new JTextField();
		txtColor.setBounds(269, 131, 86, 20);
		panel.add(txtColor);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==btnBuscar) {
			
			Long idMascota = Long.parseLong(txtIdMascota.getText());
			MascotaVo miMascota = miCoordinador.consultarMascota(idMascota);
			
			if(miMascota!=null) {
				
				txtIdDueno.setText(miMascota.getIdDueno()+"");
				txtNombre.setText(miMascota.getNombre());
				txtRaza.setText(miMascota.getRaza());
				txtSexo.setText(miMascota.getSexo());
				txtColor.setText(miMascota.getColorMascota());
				
			}else {
				JOptionPane.showMessageDialog(null, "Mascota no existente");
			}
			
		}else if(e.getSource()==btnCancelar) {
			this.dispose();
		}
		
	}


	public void setCoordinador(Coordinador miCoordinador) {
		// TODO Auto-generated method stub
		this.miCoordinador = miCoordinador;
	}


	public void limpiar() {
		// TODO Auto-generated method stub
		txtIdDueno.setText("");
		txtIdMascota.setText("");
		txtNombre.setText("");
		txtRaza.setText("");
		txtSexo.setText("");
		txtColor.setText("");
	}


}
