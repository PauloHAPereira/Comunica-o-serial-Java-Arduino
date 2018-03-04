package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

import control.ConfigurationController;

import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Configuration {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void launch() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Configuration window = new Configuration();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Configuration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ConfigurationController confControle = new ConfigurationController();
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 227, 328);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnUpdateconfig = new JButton("update Config");
		btnUpdateconfig.setName("update");
		btnUpdateconfig.setBounds(49, 205, 119, 25);
		frame.getContentPane().add(btnUpdateconfig);
		
		JComboBox<String> cBPort = new JComboBox<String>();
		cBPort.setBounds(74, 55, 95, 22);
		frame.getContentPane().add(cBPort);
		
		JLabel lblPort = new JLabel("Port: ");
		lblPort.setBounds(29, 58, 38, 16);
		frame.getContentPane().add(lblPort);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(29, 100, 48, 16);
		frame.getContentPane().add(lblStatus);
		
		JComboBox<String> cBStatus = new JComboBox<String>();
		cBStatus.setBounds(74, 97, 95, 22);
		frame.getContentPane().add(cBStatus);
		
		JRadioButton rdbtnLow = new JRadioButton("LOW");
		rdbtnLow.setBounds(25, 137, 64, 25);
		frame.getContentPane().add(rdbtnLow);
		
		JRadioButton rdbtnHigh = new JRadioButton("HIGH");
		rdbtnHigh.setBounds(117, 137, 64, 25);
		frame.getContentPane().add(rdbtnHigh);
		
		JLabel lblPortConfiguration = new JLabel("Port Configuration");
		lblPortConfiguration.setForeground(new Color(0, 139, 139));
		lblPortConfiguration.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPortConfiguration.setHorizontalAlignment(SwingConstants.CENTER);
		lblPortConfiguration.setBounds(25, 13, 156, 29);
		frame.getContentPane().add(lblPortConfiguration);
		
		JButton btnReturn = new JButton("Exit");
		btnReturn.setName("exit");
		btnReturn.setBounds(59, 243, 97, 25);
		frame.getContentPane().add(btnReturn);
		
		confControle.initializedFields(cBPort, cBStatus, rdbtnLow, rdbtnHigh);
		
		JLabel lblValue = new JLabel("Value");
		lblValue.setHorizontalAlignment(SwingConstants.CENTER);
		lblValue.setBounds(82, 176, 56, 16);
		frame.getContentPane().add(lblValue);
		
		cBPort.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				confControle.selectName(cBPort, cBStatus, rdbtnLow, rdbtnHigh);
			}
		});
		
		cBStatus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				confControle.selectPinStatus(cBStatus, rdbtnLow, rdbtnHigh);
			}
		});
		
		btnUpdateconfig.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				confControle.hendleButtonUpdate(cBPort, cBStatus, rdbtnLow);
			}
		});
		
		btnReturn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				confControle.hendleButtonExit(frame);
				
			}
		});
		
	}
}
