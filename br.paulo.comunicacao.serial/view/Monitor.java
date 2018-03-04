package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import control.MonitorController;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * 
 * @author Paulo Pereira
 *
 */
public class Monitor{

	private JFrame frame;
	private JButton btnConfiguration;
	private JScrollPane scrollPane = new JScrollPane();
	private MonitorController monitorController = new MonitorController();
	
	private JTable table;
	
	
	public void launch() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Monitor window = new Monitor();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void dispose(){
		frame.setVisible(false);
	}

	public Monitor(){
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 360, 414);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		btnConfiguration = new JButton("Port configuration");
		btnConfiguration.setBounds(107, 48, 133, 25);
		btnConfiguration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblMonitor = new JLabel("Monitor");
		lblMonitor.setBounds(136, 13, 70, 22);
		lblMonitor.setForeground(new Color(0, 139, 139));
		lblMonitor.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMonitor.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(255, 333, 41, 16);
		
		JPanel panelStatus = new JPanel();
		panelStatus.setBounds(308, 333, 20, 17);
		panelStatus.setBackground(new Color(255, 0, 0));
		
		
		btnConfiguration.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MonitorController.handleConfiguration(btnConfiguration);
				
			}
		
		});
		
		scrollPane.setBounds(12, 109, 316, 211);
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		//after a few seconds this actionListener is called
		Timer time = new Timer(0, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				table = monitorController.populateJTable();
				scrollPane.setViewportView(table);
			}
		});
		time.setDelay(1000);
		time.start();
		
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnConfiguration);
		frame.getContentPane().add(scrollPane);
		frame.getContentPane().add(lblStatus);
		frame.getContentPane().add(panelStatus);
		frame.getContentPane().add(lblMonitor);

	}
}
