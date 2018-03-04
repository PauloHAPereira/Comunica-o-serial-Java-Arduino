package model;

import java.io.InputStream;
import java.io.OutputStream;
import javax.swing.JOptionPane;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
/**
 * 
 * @author Paulo Pereira
 *
 */
public class ConexaoAR {
	
	private OutputStream outputStream;
	private InputStream inputStream;
	private SerialPort port;

	
	public void startCommunication(){
		
		try{
			CommPortIdentifier portID = null;
			try{
				//set in portId the name of COM we're using 
				portID = CommPortIdentifier.getPortIdentifier(Constants.SERIAL_PORT);
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null,"We can't find de serial port " + Constants.SERIAL_PORT);
			}
			//open the serial port with the baud rate selected
			port 		  = (SerialPort) portID.open("Comunicação serial",Constants.BAUD_RATE);
			port.setSerialPortParams(Constants.BAUD_RATE,	//set parameters
					SerialPort.DATABITS_8,
					SerialPort.STOPBITS_1,
					SerialPort.PARITY_NONE);
			outputStream = port.getOutputStream();
			inputStream = port.getInputStream();
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "We can't start the communication! cause: " + e);
			e.printStackTrace();
		}
	}
	
	public void closeCommunication(InputStream inStream, OutputStream outStream){
		try{
			//close the Serial port and the streams
			if(this.port != null){
				port.close();
			}
			if(inStream != null){
				inStream.close();
			}
			if(outStream != null){
				outStream.close();
			}
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null,"We can't stop the communication! cause: " + e);
		}
	}

	//getters and setters
	public OutputStream getOutputStream() {
		return outputStream;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

}
