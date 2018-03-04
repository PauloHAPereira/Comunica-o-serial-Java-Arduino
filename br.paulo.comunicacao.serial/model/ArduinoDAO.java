package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import javax.swing.JOptionPane;

/**
 * 
 * @author Paulo Pereira
 *
 */
public class ArduinoDAO {
	private OutputStream outStream;
	private InputStream inStream;
	private ConexaoAR conexaoAR;

	//every time when this class has instantiate, it instantiate a connection
	public ArduinoDAO() {
		conexaoAR = new ConexaoAR();
	}

	public synchronized void readData(){
		//declaration
		SplitString splitString = new SplitString();
		String data = "";
		InputStreamReader inSRead = null;
		BufferedReader bReader = null;


		conexaoAR.startCommunication();			//start the communication
		inStream = conexaoAR.getInputStream();	//get the inputStream from the communication

		try {
			inSRead = new InputStreamReader(inStream);
			bReader = new BufferedReader(inSRead);
			//write("update",false);
			write("RD",false);				//tells arduino to send the data
			while(!bReader.ready()){
				//System.out.println("OI");
				//wait until the buffer is ready
			}
			data = bReader.readLine();	
			//write("SR",false);			//tells arduino to stop sand the data
			
			//When we call this method, it will partition the data and sav it in the Arduino constant
			splitString.split(data);

			//close streaming
			if(inSRead != null){
				inSRead.close();
			}
			if(bReader != null){
				bReader.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "An error has occurred. cause: " + e);
		}finally{
			//close the communication
			conexaoAR.closeCommunication(inStream, outStream);
		}
	}

	public synchronized void write (String job ,boolean closeComunication){
		try {	
			if(conexaoAR.getOutputStream() == null){
				conexaoAR.startCommunication();
			}
			outStream = conexaoAR.getOutputStream(); //get outputStream from the communication
			byte[] contentInBytes = job.getBytes();
			outStream.write(contentInBytes);		 //write the string in the buffer
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(closeComunication){
				/*
				 * if we comes from read method, we need to send a message to arduino and wait for your reply,
				 * so we can't close the communication.
				 */
				conexaoAR.closeCommunication(inStream, outStream);
			}
		}

	}
}
