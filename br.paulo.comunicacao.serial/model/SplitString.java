package model;

import java.util.ArrayList;

/**
 * 
 * @author Paulo Pereira
 * 
 *	This class will used to separete the string based in the regex "," and ";"
 *	The regex "," will be used to separete the name of the pin and its value
 *	The regex ";" will be used to separete the pins
 *	Exemple:					  
 *		   		_Pin 1 data 
 *			   |
 *		    |-----|
 *	info = "1,high;2,low;3,low"
 *	        ^   ^
 *			|   |_value read from pin
 *			|_pin name
 *
 *	When we divide the string using the ";" regex, we receive an array of strings, containing the pin data, so this data go to
 *the second divide, in this time we using the "," regex. Now we have an array of strings containg in the position 1 the pin name
 *and in the position 2 we have the value of the pin
 */
public class SplitString {
	
	public void split(String data){
		String[] pinData = data.split(";");
		splitData(pinData);
		
	}
	
	private void splitData(String[] pinData){
		
		ArrayList<String> digPinName  = new ArrayList<>();
		ArrayList<String> valueDigPin = new ArrayList<>();
		ArrayList<String> digPinStatus= new ArrayList<>();
		
		for (String splitString : pinData) {
			//split all strings in pinData
			String pinvalues[] = splitString.split(",");
			digPinName .add	(pinvalues[0]);			//in position 0 we have the pin naem
			digPinStatus.add(pinvalues[1]);			//in position 1 we have the value of the pin
			valueDigPin.add	(pinvalues[2]);		 	//in position 2 we have the value of the pin 	
		}
		
		// puts the data read in the Arduino constant
		Constants.ARDUINO.setDigPinName(digPinName);
		Constants.ARDUINO.setDigPinStatus(digPinStatus);
		Constants.ARDUINO.setValueDigPin(valueDigPin);
	}
}
