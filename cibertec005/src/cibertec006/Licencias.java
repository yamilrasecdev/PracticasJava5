package cibertec006;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Licencias extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel Tipo;
	private JLabel lblNewLabel;
	private JComboBox comboBoxTipo;
	private JTextField txtCantidad;
	private JTextArea textArea;
	private JButton btnProcesar;

	 //declarar variables globales
	 double importeCobre,importeBronce,importeSilver,importeGold;
	 int cantidadLicenciaCobre,cantidadLicenciasBronce,cantidadLicenciasSilver,cantidadLicenciasGold;
	 int cantidadVentaCobre,cantidadVentaBronce,cantidadVentaSilver,cantidadVentaGold;
	 private JScrollPane scrollPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Licencias frame = new Licencias();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Licencias() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 675, 588);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Tipo = new JLabel("Tipo");
		Tipo.setBounds(44, 45, 46, 14);
		contentPane.add(Tipo);
		
		lblNewLabel = new JLabel("Cantidad");
		lblNewLabel.setBounds(44, 93, 46, 14);
		contentPane.add(lblNewLabel);
		
		comboBoxTipo = new JComboBox();
		comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] {"Cobre", "Bronce", "Silver", "Gold"}));
		comboBoxTipo.setBounds(132, 41, 144, 22);
		contentPane.add(comboBoxTipo);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(132, 90, 86, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 118, 564, 396);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(352, 41, 89, 23);
		contentPane.add(btnProcesar);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		int tipo, cantidad;
		double importePagar;
		tipo=getTipoLicencia();
		cantidad=getCantidad();
		importePagar=calcularImportePagar(tipo, cantidad);
		//actualizo los contadores
		efectuarIncrementos(tipo, cantidad, importePagar);
		MostrarResultados(importePagar);
	}
	//Leer variables entrada
	int getTipoLicencia() {
		return comboBoxTipo.getSelectedIndex();
	}
	
	int getCantidad() {
		return Integer.parseInt(txtCantidad.getText());
	}
	double calcularImportePagar(int tipo,int cantidad) {
		switch(tipo) {
		case 0:
			return 510*cantidad;
		case 1:
			return 1500*cantidad;
		case 2:
			return 3100*cantidad;
		default:
			return 4500*cantidad;
		}		
	}
	
	//llevar el control de contadores 
	void efectuarIncrementos (int tipo,int cantidad,double importe) {
		switch(tipo) {
		case 0:
			cantidadVentaCobre=cantidadVentaCobre+1;
			importeCobre=importeCobre+importe;// importe compra
			cantidadLicenciaCobre=cantidadLicenciaCobre+cantidad;//cantidad de licencias
			break;
		case 1:
			cantidadVentaBronce=cantidadVentaBronce+1;
			importeBronce=importeBronce+importe;
			cantidadLicenciasBronce=cantidadLicenciasBronce+cantidad;
			break;
		case 2:
			cantidadVentaSilver=cantidadVentaSilver+1;
			importeSilver=importeSilver+importe;
			cantidadLicenciasSilver=cantidadLicenciasSilver+cantidad;
			break;
		default:
			cantidadVentaGold=cantidadVentaGold+1;
			importeGold=importeGold+importe;
			cantidadLicenciasGold=cantidadLicenciasGold+cantidad;
			break;
		}
	}
	 
	void MostrarResultados(double importePagar) {
		textArea.setText("");
		textArea.append("Importe a pagar..........: " +importePagar+"\n");
		textArea.append("");
		textArea.append("");

		textArea.append("Importes Totales recaudados........................"+"\n");
		textArea.append(" - 1. Importes Totales Cobre : "+ importeCobre+"\n");
		textArea.append(" - 2. Importes Totales Bronce : "+ importeBronce+"\n");
		textArea.append(" - 3. Importes Totales Silver : "+ importeSilver+"\n");
		textArea.append(" - 4. Importes Totales Gold : "+ importeGold+"\n");
		textArea.append(""+"\n");
		textArea.append(""+"\n");

		textArea.append("Cantidad de licencias vendidas................"+"\n");
		textArea.append(" - 1. Cantidad Lic.  Cobre : "+ cantidadLicenciaCobre+"\n");
		textArea.append(" - 2. Cantidad Lic.  Bronce : "+ cantidadLicenciasBronce+"\n");
		textArea.append(" - 3. Cantidad Lic.  Silver : "+ cantidadLicenciasSilver+"\n");
		textArea.append(" - 4. Cantidad Lic.  Gold : "+ cantidadLicenciasGold+"\n");
		textArea.append(""+"\n");
		textArea.append(""+"\n");
		
		textArea.append("Cantidad de Ventas por tipo................"+"\n");
		textArea.append(" - 1. Cantidad ventas de  Cobre : "+ cantidadVentaCobre+"\n");
		textArea.append(" - 2. Cantidad ventas de  Bronce : "+ cantidadVentaBronce+"\n");
		textArea.append(" - 3. Cantidad ventas de Silver : "+ cantidadVentaSilver+"\n");
		textArea.append(" - 4. Cantidad ventas de  Gold : "+ cantidadVentaGold+"\n");
		textArea.append(""+"\n");
		textArea.append(""+"\n");

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
