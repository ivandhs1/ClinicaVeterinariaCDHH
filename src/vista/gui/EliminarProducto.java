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

public class EliminarProducto extends JDialog implements ActionListener{
	private Coordinador miCoordinador;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private JButton btnCancelar;
	private JButton btnBuscar;
	private JButton btnEliminar,btnNo, btnSi;
	private JTextField txtIdProducto;
	private JTextField txtIdPersona;
	private JLabel lblseguro;
	private ProductoVo miProducto;
	private PersonasProductosVo produc;


	/**
	 * Create the dialog.
	 * @param b 
	 * @param ventanaPrincipal 
	 * @param documento 
	 */
	public EliminarProducto(VentanaPrincipal ventanaPrincipal, boolean modal) {
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
		
		JLabel lblTitulo = new JLabel("ELIMINAR PRODUCTO");
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
	
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(146, 144, 100, 23);
		panel.add(btnEliminar);
		
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
		
		lblseguro = new JLabel("\u00BFSeguro?");
		lblseguro.setBounds(40, 130, 57, 21);
		panel.add(lblseguro);
		
		btnNo = new JButton("No");
		btnNo.setBackground(new Color(152, 251, 152));
		btnNo.setBounds(70, 150, 50, 23);
		btnNo.addActionListener(this);
		panel.add(btnNo);
		
		btnSi = new JButton("Si");
		btnSi.setBackground(new Color(255, 192, 203));
		btnSi.setBounds(5, 150, 50, 23);
		btnSi.addActionListener(this);
		panel.add(btnSi);
		lblseguro.setVisible(false);
		btnNo.setVisible(false);
		btnSi.setVisible(false);
		btnEliminar.setVisible(false);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnBuscar) {
			
			Long idProducto = Long.parseLong(txtIdProducto.getText());
			miProducto = miCoordinador.consultarProducto(idProducto);
			
			if(miProducto!=null) {
				produc = miCoordinador.buscarPproducto(Long.parseLong(txtIdProducto.getText()));
				txtIdPersona.setText(produc.getPersonaId()+"");
				txtNombre.setText(miProducto.getNombreProducto());
				txtPrecio.setText(miProducto.getPrecioProducto()+"");
				
				btnEliminar.setVisible(true);
				
			}else {
				JOptionPane.showMessageDialog(null, "Producto no existente");
			}
			
		}else if(e.getSource()==btnCancelar) {
			this.dispose();
		}else if(e.getSource()==btnEliminar) {
			lblseguro.setVisible(true);
			btnNo.setVisible(true);
			btnSi.setVisible(true);
		}else if(e.getSource()==btnNo) {
			btnEliminar.setVisible(false);
			lblseguro.setVisible(false);
			btnNo.setVisible(false);
			btnSi.setVisible(false);
		}else if(e.getSource()==btnSi) {
			
			produc.setProductoId(Long.parseLong(txtIdProducto.getText()));
			String eli = miCoordinador.eliminarPprodcuto(produc);
			
			miProducto.setIdProducto(Long.parseLong(txtIdProducto.getText()));
			String verificacionEl = miCoordinador.eliminarProducto(miProducto);
			
			
			
			if(verificacionEl.equals("ok") && eli.equals("ok")) {
				
				JOptionPane.showMessageDialog(null, "Eliminacion Exitosa");
				this.dispose();
				
			}else {
				System.out.println("Ocurrio un error");
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
