package cibertec005;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Rectangulometodos extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtBase;
	private JTextField txtAltura;
	private JButton btnProcesar;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextArea txtArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rectangulometodos frame = new Rectangulometodos();
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
	public Rectangulometodos() {
		setTitle("Rectangulo con Metodos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtBase = new JTextField();
		txtBase.setBounds(121, 40, 86, 20);
		contentPane.add(txtBase);
		txtBase.setColumns(10);
		
		txtAltura = new JTextField();
		txtAltura.setBounds(121, 87, 86, 20);
		contentPane.add(txtAltura);
		txtAltura.setColumns(10);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(281, 39, 89, 23);
		contentPane.add(btnProcesar);
		
		lblNewLabel = new JLabel("Base");
		lblNewLabel.setBounds(33, 43, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Altura");
		lblNewLabel_1.setBounds(33, 90, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtArea = new JTextArea();
		txtArea.setBounds(49, 147, 269, 88);
		contentPane.add(txtArea);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		
		//Declaracion variables entrada
		double base;
		double altura;		
		// Declaracion variables salida
		double area;
		
		//lectura datos
		base=getBase();
		altura=getAltura();
		//calculos
		area=calcularArea(base,altura);
		//imprimir
		MostrarArea(area);
		
	}
	
	//Leer y retorna base
	double getBase() {
		return Double.parseDouble(txtBase.getText());
	}
	
	//Leer y retorna altura
	double getAltura() {
		return Double.parseDouble(txtAltura.getText());
	}
	
	double calcularArea(double mibase,double mialtura){
		return (mibase*mialtura);
	}
	
	void MostrarArea(double miarea) {
		txtArea.setText("El resultado del area es :" + miarea);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
