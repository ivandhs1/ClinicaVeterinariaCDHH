package vista.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;
import modelo.vo.MascotaVo;
import modelo.vo.PersonaVo;

public class ListarMascotasGui extends JDialog {

	private JPanel miPanel;
	private Coordinador miCoordinador;
	private ArrayList<MascotaVo> mascotas;
	private JTable miTabla;
	private JLabel titulo;
	private JScrollPane miScrol;
	
	public ListarMascotasGui() {
		setSize( 672, 449);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		setTitle("lista de Mascotas");
		iniciarComponentes();
	}

	private void iniciarComponentes() {
		
		miPanel = new JPanel();
		miPanel.setLayout(null);
		
		titulo = new JLabel("Lista de Mascotas");
		titulo.setBounds(220,20,180,30);
		titulo.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		miPanel.add(titulo);
		
		miScrol = new JScrollPane();
		miScrol.setBounds(10,80,630,247);
		miPanel.add(miScrol);
		
		add(miPanel);
	}
	public void setMiCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

	public void setPersonas(ArrayList<MascotaVo> mascotas) {
		this.mascotas = mascotas;
	}
	public void llenar(ArrayList<MascotaVo> mascotas) {
		String titulos [] = {"IdMascota","Color","Nombre","Raza","Sexo","Documento Dueño"};
		
		System.out.println(mascotas.size());
		int celdas;
		if(mascotas.size()<15) {
			celdas=14;
		}else {
			celdas=mascotas.size();
		}
		String cuadro [][]= new String [celdas][9];
		if(mascotas.size()>0) {
			for (int i=0;i<mascotas.size();i++) {
				cuadro[i][0]=mascotas.get(i).getIdMascota()+"";
				cuadro[i][1]=mascotas.get(i).getColorMascota();
				cuadro[i][2]=mascotas.get(i).getNombre();
				cuadro[i][3]=mascotas.get(i).getRaza();
				cuadro[i][4]=mascotas.get(i).getSexo()+"";
				cuadro[i][5]=mascotas.get(i).getIdDueno()+"";
			}
		}else {
			 cuadro = new String [14][9];
		}
		
		miTabla = new JTable(cuadro,titulos);
		miScrol.setViewportView(miTabla);
	}
	

}
