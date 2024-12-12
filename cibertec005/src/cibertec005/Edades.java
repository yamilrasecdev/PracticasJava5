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

public class Edades extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField txtedad1;
	private JTextField txtedad2;
	private JTextField txtedad3;
	private JButton btnProcesar;
	private JTextArea txtarea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Edades frame = new Edades();
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
	public Edades() {
		setTitle("Edades");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Edad 1");
		lblNewLabel.setBounds(80, 51, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Edad 2");
		lblNewLabel_1.setBounds(80, 92, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Edad 3");
		lblNewLabel_2.setBounds(80, 142, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		txtedad1 = new JTextField();
		txtedad1.setBounds(159, 48, 86, 20);
		contentPane.add(txtedad1);
		txtedad1.setColumns(10);
		
		txtedad2 = new JTextField();
		txtedad2.setBounds(159, 89, 86, 20);
		contentPane.add(txtedad2);
		txtedad2.setColumns(10);
		
		txtedad3 = new JTextField();
		txtedad3.setBounds(159, 139, 86, 20);
		contentPane.add(txtedad3);
		txtedad3.setColumns(10);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(298, 47, 89, 23);
		contentPane.add(btnProcesar);
		
		txtarea = new JTextArea();
		txtarea.setBounds(72, 193, 357, 135);
		contentPane.add(txtarea);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		// Declaración de variables
		int edad1, edad2, edad3, edadMayor;

		// Entrada de datos

		edad1 = Integer.parseInt(txtedad1.getText()); 
		edad2 = Integer.parseInt(txtedad2.getText()); 
		edad3 = Integer.parseInt(txtedad3.getText());


	//Determina la edad mayor
		edadMayor = edad1;

		if (edad2 > edadMayor)

		edadMayor = edad2;


		if (edad3 > edadMayor)

		edadMayor = edad3;


		// Salida de resultados
		txtarea.setText("Edad mayor : " + edadMayor);

	}
}
