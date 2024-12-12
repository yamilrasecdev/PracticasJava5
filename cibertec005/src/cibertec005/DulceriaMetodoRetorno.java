package cibertec005;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DulceriaMetodoRetorno extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox combotipo;
    //private JComboBox<String> combotipo;

	private JTextField txtcantidad;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextArea txtarea;
	private JButton btnProcesar;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DulceriaMetodoRetorno frame = new DulceriaMetodoRetorno();
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
	public DulceriaMetodoRetorno() {
		setTitle("Dulceria");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		combotipo = new JComboBox();
		//JComboBox<String> combotipo = new JComboBox<>();
		//new String[] {"Primor", "Dulzura", "Tentación", "Explosión"}

		combotipo.setModel(new DefaultComboBoxModel(new String[] {"Primor","Dulzura","Tentacion","Explocion"}));
		//combotipo.setModel(new DefaultComboBoxModel<>(new String[] {
	    //        "Primor", "Dulzura", "Tentación", "Explosión"
	     //   }));
		
		combotipo.setBounds(177, 56, 158, 22);
		contentPane.add(combotipo);
		
		txtcantidad = new JTextField();
		txtcantidad.setBounds(177, 113, 158, 20);
		contentPane.add(txtcantidad);
		txtcantidad.setColumns(10);
		
		lblNewLabel = new JLabel("Tipo");
		lblNewLabel.setBounds(64, 60, 72, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Cantidad");
		lblNewLabel_1.setBounds(64, 116, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtarea = new JTextArea();
		txtarea.setBounds(94, 205, 362, 151);
		contentPane.add(txtarea);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(427, 56, 89, 23);
		contentPane.add(btnProcesar);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	
	int getTipo(){
		return combotipo.getSelectedIndex();
	}
	
	
	
	int getCantidad() {
		return Integer.parseInt( txtcantidad.getText());
	}
	
	double calcularImporteCompra(int tipo,int cantidad){
		switch(tipo) {
		case 0:
			return cantidad*8.5;
		case 1:
			return cantidad*10;			
		case 2:
			return cantidad*7;			
		default:
			return cantidad*12.5;			
		}		 
	}
	
	double calcularImporteDescuento(int cantidad,double importeCompra) {
		if (cantidad<5)
			return 0.04*importeCompra;
		else if (cantidad <10)
			return 0.065*importeCompra;
		else if (cantidad <15)
			return 0.09*importeCompra;
		else 
			return 0.115*importeCompra;
	}
	
	double calcularImportePagar(double importeCompra,double importeDescuento) {
		return (importeCompra-importeDescuento);
	}	
	
	int calcularCaramelos(int cantidad,double importePagar) {
		if (importePagar<250)
			return 2*cantidad;
		else 
			return 3*cantidad;
	}	
	
	public void Imprimir(double impcom,double impdes,double imppag, int caramelos) {
		txtarea.setText("Importe compra : S/. " +impcom +"\n");
		txtarea.append("Importe descuento : S/. " +impdes +"\n");
		txtarea.append("Importe pagar : S/. " +imppag +"\n");
		txtarea.append("caramelos obse : " +caramelos +"\n");
	}
	
	
	
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		//Declarar variables
		//Declaración de variables entrada
		int tipo, cantidad;
		//declaro variables salida		
		double impcom = 0, impdes = 0,imppag=0;
		int  caramelos;		
		//Lectura datos
		tipo=getTipo();
		cantidad=getCantidad();	
		//calcular compra
		impcom=	calcularImporteCompra(tipo,cantidad);	
		impdes=calcularImporteDescuento(cantidad,impcom);
		imppag=calcularImportePagar(impcom,impdes);
		caramelos=calcularCaramelos(cantidad,imppag);
		Imprimir(impcom,impdes,imppag,caramelos);				
	}
	
 public void boton() {
	 	   //Declaración de variables entrada
			int tipo, cantidad, caramelos;
			//declaro variables salida
			double impcom = 0, impdes = 0, imppag;

		//Entrada de datos
		//Leo el item seleccionado del combobox
		tipo = combotipo.getSelectedIndex();
		//Leo la cantidad ingresada	
		cantidad = Integer.parseInt( txtcantidad.getText());
		
		//Calcula el importe de la compra 
		if (tipo == 0)
			impcom = 8.5 * cantidad;

		if (tipo == 1)
			impcom = 10.0 * cantidad;

		if (tipo == 2)
			impcom = 7.0 * cantidad;

		if (tipo == 3)
			impcom = 12.5 * cantidad;

		//Calcula el importe del descuento 
		if (cantidad < 5)
			impdes = 0.04 * impcom;

		if (cantidad >= 5 && cantidad < 10)
			impdes = 0.065 * impcom;

		if (cantidad >= 10 && cantidad < 15)
			impdes = 0.09 * impcom;

		if (cantidad >= 15)
			impdes = 0.115 * impcom;
		//Calcula el importe a pagar 
			imppag = impcom - impdes;
		//Calcula la cantidad de caramelos de regalo 
			if (imppag < 250)
				caramelos = 2 * cantidad;
			else
				caramelos = 3 * cantidad;
		//Salida de resultados
		txtarea.setText("Importe de la compra	: S/. " + impcom + "\n");
		txtarea.append("Importe del descuento : S/. " + impdes + "\n");
		txtarea.append("Importe a pagar	: S/. " + imppag + "\n");
		txtarea.append("Caramelos de obsequio : " + caramelos);

 }
}
