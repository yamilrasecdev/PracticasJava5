package cibertec005;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Empresabonificacion extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtCantidaTardanzas;
	private JTextField txtCantidadObs;
	private JButton btnProcesar;
	private JButton btnNewButton;
	private JTextArea txtArea;

	
	//Declaracion variables entrada
	 int minutosTardanza;
	 int cantidadObservaciones;
	 
	// Declarar variables salida
	 int puntajeTardanza;
	 int puntajeObservaciones;
	 int puntajeTotal;
	 double bonificacion;
	 
	 
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Empresabonificacion frame = new Empresabonificacion();
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
	public Empresabonificacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Tardanzas N°");
		lblNewLabel.setBounds(31, 52, 124, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Observaciones N°");
		lblNewLabel_1.setBounds(31, 98, 106, 14);
		contentPane.add(lblNewLabel_1);
		
		txtCantidaTardanzas = new JTextField();
		txtCantidaTardanzas.setBounds(165, 49, 86, 20);
		contentPane.add(txtCantidaTardanzas);
		txtCantidaTardanzas.setColumns(10);
		
		txtCantidadObs = new JTextField();
		txtCantidadObs.setBounds(135, 95, 86, 20);
		contentPane.add(txtCantidadObs);
		txtCantidadObs.setColumns(10);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(284, 48, 89, 23);
		contentPane.add(btnProcesar);
		
		btnNewButton = new JButton("Limpiar");
		btnNewButton.setBounds(284, 98, 89, 23);
		contentPane.add(btnNewButton);
		
		txtArea = new JTextArea();
		txtArea.setBounds(43, 160, 286, 90);
		contentPane.add(txtArea);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		//declarar-- ok				
		//leer --ok
		LeerDatos();
		//calcular --ok
		calcularPuntajeTardanzas();
		calcularPuntajeObservaciones();
		calcularPuntajeTotal();
		calcularBonificacion();
		//imprimir
		Imprimir();
	}
	
	public void Imprimir() {
		txtArea.setText("puntaje tardanzas :" + puntajeTardanza + "\n");
		
		txtArea.append("puntaje observaciones :" + puntajeObservaciones + "\n");
		txtArea.append("puntaje total :" + puntajeTotal + "\n");
		txtArea.append("bonificacion : S/." + bonificacion + "\n");
		
		
	}
	
	public void LeerDatos() {
		minutosTardanza=Integer.parseInt(txtCantidaTardanzas.getText());
		cantidadObservaciones=Integer.parseInt(txtCantidadObs.getText());
		
	}
	public void calcularPuntajeTardanzas() {		
		if (minutosTardanza==0) 
			puntajeTardanza=10;
		else if(minutosTardanza<=2) 
			puntajeTardanza=8;		
		else if (minutosTardanza<=5)
			puntajeTardanza=6;
		else if (minutosTardanza<=9)
			puntajeTardanza=4;
		else 
			puntajeTardanza=0;
			
	} 
	public void calcularPuntajeObservaciones() {
		if (cantidadObservaciones==0)
			puntajeObservaciones=10;
		else if (cantidadObservaciones==1)
			puntajeObservaciones=8;
		else if (cantidadObservaciones==2)
			puntajeObservaciones=5;
		else if(cantidadObservaciones==3)
			puntajeObservaciones=1;
		else
			puntajeObservaciones=0;
		
	}
	public void calcularPuntajeTotal() {
		puntajeTotal=puntajeTardanza+puntajeObservaciones;
	}
	
	public void calcularBonificacion() {
		if(puntajeTotal<11)
			bonificacion=2.5*puntajeTotal;
		else if (puntajeTotal<=13)
			bonificacion=5*puntajeTotal;
		else if (puntajeTotal<=16)
			bonificacion=7.5*puntajeTotal;
		else if (puntajeTotal<=19)
			bonificacion=10*puntajeTotal;
		else
			bonificacion=12.5*puntajeTotal;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
