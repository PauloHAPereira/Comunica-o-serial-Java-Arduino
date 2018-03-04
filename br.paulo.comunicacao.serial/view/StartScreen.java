package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import control.StartScreenController;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
/**
 * 
 * @author Paulo Pereira
 *
 */
public class StartScreen {
	
	private static JFrame frame;
	
	/**
	 * Launch the application.
	 */
	public void launch() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartScreen.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void dispose(){
		frame.setVisible(false);
	}

	/**
	 * Create the application.
	 */
	public StartScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 312, 234);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Arduino Monitor");
		lblTitle.setForeground(new Color(0, 139, 139));
		lblTitle.setBounds(67, 13, 155, 22);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblBaudRate = new JLabel("Baud Rate:");
		lblBaudRate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBaudRate.setBounds(24, 62, 90, 16);
		frame.getContentPane().add(lblBaudRate);
		
		JLabel lblCom = new JLabel("COM:");
		lblCom.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCom.setBounds(24, 97, 56, 16);
		frame.getContentPane().add(lblCom);
		
		//============================ Baud rate combo box =================================================
		JComboBox<String> comboBoxBaudRate = new JComboBox<String>();
		comboBoxBaudRate.setBounds(115, 60, 119, 22);
		frame.getContentPane().add(comboBoxBaudRate);
		StartScreenController.populateBaudRate(comboBoxBaudRate); 	//call the method to populate the combo box baud rate
		
		
		//============================ Serial port combo box ================================================
		JComboBox<String> comboBoxSerialPort = new JComboBox<String>();
		comboBoxSerialPort.setBounds(116, 95, 118, 22);
		frame.getContentPane().add(comboBoxSerialPort);
		StartScreenController.populateSerialPorts(comboBoxSerialPort); //call the method to populate the combo box serial port
		
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(98, 151, 97, 25);
		frame.getContentPane().add(btnOk);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StartScreenController.handleOkButton(btnOk, comboBoxSerialPort, comboBoxBaudRate, frame);
			}
		});
	}
}
