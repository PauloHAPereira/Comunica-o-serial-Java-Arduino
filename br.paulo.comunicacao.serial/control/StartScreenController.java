package control;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import model.Constants;
import view.Monitor;
/**
 * 
 * @author Paulo Pereira
 *
 */
public class StartScreenController {
	public static void handleOkButton(JButton okButton, JComboBox<String> comboBoxSerialPort,
			JComboBox<String> comboBoxBaudRate, JFrame frame){
		
		if("OK".equals(okButton.getActionCommand())){
			//get the values in the comboboxs
			String serialPort = (String) comboBoxSerialPort.getSelectedItem();
			String baudR = (String) comboBoxBaudRate.getSelectedItem();
			//convert the string to int, this is necessary because the baud rate need to be int type.
			int baudRate = Integer.parseInt(baudR);
			//save the state in the constants class
			Constants.BAUD_RATE=baudRate;				
			Constants.SERIAL_PORT=serialPort;

			//launch the new screen
			Monitor monitor = new Monitor();
			monitor.launch();
			//dispose the actual screen
			frame.dispose();
		}
	}

	//populate the Combobox contains all possible baud rate 300,600,1200,2400,4800,9600,14400,19200,28800,38400,57600, or 115200.
	public static void populateBaudRate(JComboBox<String> comboBoxBaudRate){

		comboBoxBaudRate.addItem("300");
		comboBoxBaudRate.addItem("600");
		comboBoxBaudRate.addItem("1200");
		comboBoxBaudRate.addItem("2400");
		comboBoxBaudRate.addItem("4800");
		comboBoxBaudRate.addItem("9600");
		comboBoxBaudRate.addItem("14400");
		comboBoxBaudRate.addItem("19200");
		comboBoxBaudRate.addItem("28800");
		comboBoxBaudRate.addItem("38400");
		comboBoxBaudRate.addItem("57600");
		comboBoxBaudRate.addItem("115200");

	}

	//populate the combobox with all possibles serial ports
	public static void populateSerialPorts(JComboBox<String> comboBoxSerialPort){

		comboBoxSerialPort.addItem("COM1");
		comboBoxSerialPort.addItem("COM2");
		comboBoxSerialPort.addItem("COM3");
		comboBoxSerialPort.addItem("COM4");
		comboBoxSerialPort.addItem("COM5");
		comboBoxSerialPort.addItem("COM6");
		comboBoxSerialPort.addItem("COM7");
		comboBoxSerialPort.addItem("COM8");
		comboBoxSerialPort.addItem("COM9");
		comboBoxSerialPort.addItem("COM10");
	}
}
