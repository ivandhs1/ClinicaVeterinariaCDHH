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

public class ListarProductos extends JDialog implements ActionListener{
	
	private JPanel miPanel;
	private Coordinador miCoordinador;
	private ArrayList<PersonaVo> personas;
	private JTable miTabla;
	private JLabel titulo;
	private JScrollPane miScrol;
	
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

	public void setPersonas(ArrayList<PersonaVo> personas) {
		this.personas = personas;
	}
	
	public void llenar(ArrayList<PersonaVo> personas) {
		String titulos [] = {"documento","nombre","profesion","telefono","tipo","ciudadN","departamentoN","paisN","fechaN"};
		
		System.out.println(personas.size());
		int celdas;
		if(personas.size()<15) {
			celdas=14;
		}else {
			celdas=personas.size();
		}
		String cuadro [][]= new String [celdas][9];
		if(personas.size()>0) {
			
			
			for (int i=0;i<personas.size();i++) {
				cuadro[i][0]=personas.get(i).getIdPersona()+"";
				cuadro[i][1]=personas.get(i).getNombre();
				cuadro[i][2]=personas.get(i).getProfesion();
				cuadro[i][3]=personas.get(i).getTelefono();
				cuadro[i][4]=personas.get(i).getTipo()+"";
				cuadro[i][5]=personas.get(i).getNacimiento().getCiudadNacimiento();
				cuadro[i][6]=personas.get(i).getNacimiento().getDepartamentoNacimiento();
				cuadro[i][7]=personas.get(i).getNacimiento().getPaisNacimiento();
				cuadro[i][8]=personas.get(i).getNacimiento().getFechaNacimiento()+"";
			}
		}else {
			 cuadro = new String [14][9];
		}
		
		miTabla = new JTable(cuadro,titulos);
		miScrol.setViewportView(miTabla);
	}

}
