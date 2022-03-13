package vista.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controlador.Coordinador;
import modelo.vo.PersonaVo;
import modelo.vo.PersonasProductosVo;
import modelo.vo.ProductoVo;

public class ListarProductos extends JDialog implements ActionListener{
	
	private JPanel miPanel;
	private Coordinador miCoordinador;
	private JTable miTabla;
	private JLabel titulo;
	private JScrollPane miScrol;
	private PersonasProductosVo produc;
	public ListarProductos() {
		setSize( 672, 449);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		setTitle("lista de Personas");
		iniciarComponentes();
	}

	private void iniciarComponentes() {
		
		miPanel = new JPanel();
		miPanel.setLayout(null);
		
		titulo = new JLabel("Lista de Personas");
		titulo.setBounds(220,20,180,30);
		titulo.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		miPanel.add(titulo);
		
		miScrol = new JScrollPane();
		miScrol.setBounds(10,80,630,247);
		miPanel.add(miScrol);
		
		add(miPanel);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void setMiCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

	
	public void llenar(ArrayList<ProductoVo> producto)  {
		String titulos [] = {"IDproducto","nombre","precio","IDpersona"};
		System.out.println(producto.size());
		int celdas;
		if(producto.size()<15) {
			celdas=14;
		}else {
			celdas=producto.size();
		}
		String cuadro [][]= new String [celdas][4];
		if(producto.size()>0) {
			
			
			for (int i=0;i<producto.size();i++) {
				produc = miCoordinador.buscarPproducto(producto.get(i).getIdProducto());
				cuadro[i][0]=producto.get(i).getIdProducto()+"";
				cuadro[i][1]=producto.get(i).getNombreProducto();
				cuadro[i][2]=producto.get(i).getPrecioProducto()+"";
				cuadro[i][3]=produc.getPersonaId()+"";
			}
		}else {
			 cuadro = new String [14][4];
		}
		
		miTabla = new JTable(cuadro,titulos);
		miScrol.setViewportView(miTabla);
	}

}
