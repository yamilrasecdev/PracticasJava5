package cibertec006;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class Peaje extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JComboBox comboBoxTipo;
	private JTextField txtCantidad;
	private JButton btnProcesar;

	//declararmos variables globales
	int cantidadVehAutomovil,cantidadVehCamion,cantidadVehCamioneta,cantidadVehOmnibus,cantidadVehOtros;
	int cantidadPasjAutomvil,cantidadPsjCamion,cantidadPsjCamioneta,cantidadPsjOmnibus,cantidadPsjOtros;
	private JTextArea txtArea;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Peaje frame = new Peaje();
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
	public Peaje() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 681, 574);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Tipo de vehiculo");
		lblNewLabel.setBounds(85, 60, 140, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Cantidad Pasajeros");
		lblNewLabel_1.setBounds(85, 107, 106, 14);
		contentPane.add(lblNewLabel_1);
		
		comboBoxTipo = new JComboBox();
		comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] {"automovil", "camion", "camioneta", "omnibus", "otros"}));
		comboBoxTipo.setBounds(243, 56, 180, 22);
		contentPane.add(comboBoxTipo);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(243, 104, 127, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(499, 56, 89, 23);
		contentPane.add(btnProcesar);
		
		txtArea = new JTextArea();
		txtArea.setBounds(52, 166, 566, 302);
		contentPane.add(txtArea);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		int tipoVehiculo,cantidadPasajeros;
		tipoVehiculo=getTipoVehiculo();
		cantidadPasajeros=getCantidadPasajeros();
		
		actualizarContadoresAcumuladores(tipoVehiculo,cantidadPasajeros);
		mostrarReporte();
	}
	
	int getTipoVehiculo() {
		return comboBoxTipo.getSelectedIndex();
	}
	
	int getCantidadPasajeros() {
		return Integer.parseInt(txtCantidad.getText());
	}
	
	void actualizarContadoresAcumuladores(int tipoVehiculo,int cantidadPsj) {
		switch(tipoVehiculo) {
		case 0:
			cantidadVehAutomovil=cantidadVehAutomovil+1;
			cantidadPasjAutomvil=cantidadPasjAutomvil+cantidadPsj;
			break;
		case 1:
			cantidadVehCamion=cantidadVehCamion+1;
			cantidadPsjCamion=cantidadPsjCamion+cantidadPsj;
			break;
		case 2:
			cantidadVehCamioneta=cantidadVehCamioneta+1;
			cantidadPsjCamioneta=cantidadPsjCamioneta+cantidadPsj;
			break;
		case 3:
			cantidadVehOmnibus=cantidadVehOmnibus+1;
			cantidadPsjOmnibus=cantidadPsjOmnibus+cantidadPsj;
			break;
		default:
			cantidadVehOtros=cantidadVehOtros+1;
			cantidadPsjOtros=cantidadPsjOtros+cantidadPsj;
			break;
		}
	}
	
	void mostrarReporte() {
		txtArea.setText(""+"\n");
		txtArea.append("Cantidad total de vehiculos x tipo"+"\n");
		txtArea.append("Cantidad total automoviles:"+cantidadVehAutomovil+"\n");
		txtArea.append("Cantidad total Camion:"+cantidadVehCamion+"\n");
		txtArea.append("Cantidad total Camioneta:"+cantidadVehCamioneta+"\n");
		txtArea.append("Cantidad total omnibus:"+cantidadVehOmnibus+"\n");
		txtArea.append("Cantidad total otros:"+cantidadVehOtros+"\n");
		txtArea.append("");
		
		txtArea.append("Cantidad total de pasajeros x tipo"+"\n");
		txtArea.append("Cantidad pasajeros automoviles:"+cantidadPasjAutomvil+"\n");
		txtArea.append("Cantidad pasajeros Camion:"+cantidadPsjCamion+"\n");
		txtArea.append("Cantidad pasajeros Camioneta:"+cantidadPsjCamioneta+"\n");
		txtArea.append("Cantidad pasajeros omnibus:"+cantidadPsjOmnibus+"\n");
		txtArea.append("Cantidad pasajeros otros:"+cantidadPsjOtros+"\n");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
