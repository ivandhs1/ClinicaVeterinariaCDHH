package vista.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;
import modelo.vo.PersonaVo;
import modelo.vo.PersonasProductosVo;
import modelo.vo.ProductoVo;

public class ActualizarProducto extends JDialog implements ActionListener{
	private Coordinador miCoordinador;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private JButton btnCancelar;
	private JButton btnBuscar;
	private JButton btnActualizar;
	private JTextField txtIdProducto;
	private JTextField txtIdPersona;


	/**
	 * Create the dialog.
	 * @param b 
	 * @param ventanaPrincipal 
	 * @param documento 
	 */
	public ActualizarProducto(VentanaPrincipal ventanaPrincipal, boolean modal) {
		super(ventanaPrincipal,modal);
		setSize( 412, 266);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		setTitle("Consulta de Productos");
		iniciarComponentes();
		
		
	}


	private void iniciarComponentes() {
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblTitulo = new JLabel("ACTUALIZAR PRODUCTO");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblTitulo.setBounds(10, 10, 372, 28);
		contentPanel.add(lblTitulo);
				
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(10, 38, 380, 178);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(24, 96, 71, 21);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(89, 96, 86, 20);
		panel.add(txtNombre);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(209, 96, 71, 21);
		panel.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(269, 96, 86, 20);
		panel.add(txtPrecio);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(24, 128, 331, 12);
		panel.add(separator);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(266, 144, 89, 23);
		panel.add(btnCancelar);
	
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBackground(new Color(152, 251, 152));
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(146, 144, 100, 23);
		panel.add(btnActualizar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(266, 19, 89, 23);
		btnBuscar.addActionListener(this);
		panel.add(btnBuscar);
		
		JLabel lblidProducto = new JLabel("Id Producto: ");
		lblidProducto.setBounds(89, 23, 71, 14);
		panel.add(lblidProducto);
		
		txtIdProducto = new JTextField();
		txtIdProducto.setBounds(170, 20, 86, 20);
		panel.add(txtIdProducto);
		txtIdProducto.setColumns(10);
		
		JLabel lblIdPersona = new JLabel("Id Persona: ");
		lblIdPersona.setBounds(24, 67, 71, 14);
		panel.add(lblIdPersona);
		
		txtIdPersona = new JTextField();
		txtIdPersona.setColumns(10);
		txtIdPersona.setBounds(89, 64, 86, 20);
		panel.add(txtIdPersona);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnBuscar) {
			
			Long idProducto = Long.parseLong(txtIdProducto.getText());
			ProductoVo miProducto = miCoordinador.consultarProducto(idProducto);
			
			if(miProducto!=null) {
				
				PersonasProductosVo produc = miCoordinador.buscarPproducto(Long.parseLong(txtIdProducto.getText())); 
				txtIdPersona.setText(produc.getProductoId()+"");
				txtNombre.setText(miProducto.getNombreProducto());
				txtPrecio.setText(miProducto.getPrecioProducto()+"");
				
			}else {
				JOptionPane.showMessageDialog(null, "Producto no existente");
			}
			
		}else if(e.getSource()==btnCancelar) {
			this.dispose();
		}else if(e.getSource()==btnActualizar) {
			ProductoVo miProducto = new ProductoVo();
			
			miProducto.setIdProducto(Long.parseLong(txtIdProducto.getText()));
			miProducto.setNombreProducto(txtNombre.getText());
			miProducto.setPrecioProducto(Double.parseDouble(txtPrecio.getText()));
			
			PersonasProductosVo produc = miCoordinador.buscarPproducto(Long.parseLong(txtIdProducto.getText())); 
			PersonaVo miPersona = miCoordinador.setConsultarPersonaGui(Long.parseLong(txtIdPersona.getText()));
			
			
			if(miPersona!=null) {
				
				String res = miCoordinador.actualizarProducto(miProducto);
				
				if(res.equals("ok")) {
					JOptionPane.showMessageDialog(null, "Actualizacion exitosa!!");
				}else {
					JOptionPane.showMessageDialog(null, res, "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
			}else {
				JOptionPane.showMessageDialog(null, "Persona no existe");
			}
		}
	}


	public void setCoordinador(Coordinador miCoordinador) {
		// TODO Auto-generated method stub
		this.miCoordinador = miCoordinador;
	}
	
	public void vaciar() {
		txtIdPersona.setText("");
		txtIdProducto.setText("");
		txtNombre.setText("");
		txtPrecio.setText("");
	}
}
