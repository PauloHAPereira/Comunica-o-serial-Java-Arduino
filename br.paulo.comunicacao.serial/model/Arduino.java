package model;

import java.util.ArrayList;
/**
 * 
 * @author Paulo Pereira
 *
 */
public class Arduino {
	
	private ArrayList<String> 	digPinName 	 = new ArrayList<>();	// pins names 
	private ArrayList<String> 	digPinStatus = new ArrayList<>();	// digital pin status: Read/write
	private ArrayList<String> 	valueDigPin	 = new ArrayList<>();	// value of the digital pin: higt/low
	
	public Arduino(){
		//initialize the arduino
		for(int i = 0 ; i < 13 ; i++){
			digPinName	.add("Pino " + (i+1));
			digPinStatus.add("READ");
			valueDigPin	.add("NULL");
		}
	}
	
	//getters and setters
	public ArrayList<String> getDigPinName() {
		return digPinName;
	}
	public void setDigPinName(ArrayList<String> digPinName) {
		this.digPinName = digPinName;
	}
	public ArrayList<String> getDigPinStatus() {
		return digPinStatus;
	}
	public void setDigPinStatus(ArrayList<String> digPinStatus) {
		this.digPinStatus = digPinStatus;
	}
	public ArrayList<String> getValueDigPin() {
		return valueDigPin;
	}
	public void setValueDigPin(ArrayList<String> valueDigPin) {
		this.valueDigPin = valueDigPin;
	}
	
	
	
}
