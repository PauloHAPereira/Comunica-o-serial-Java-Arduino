package control;

import java.awt.Frame;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

import model.ArduinoDAO;
import model.Constants;

public class ConfigurationController {

	private ArrayList<String> pinName 	= new ArrayList<>();
	private ArrayList<String> pinStatus = new ArrayList<>();
	private ArrayList<String> valuePin 	= new ArrayList<>();

	public void initializedFields(JComboBox<String> portCombobox, JComboBox<String> statusCombobox ,
			JRadioButton low,JRadioButton high ){

		getArduinoStatus();
		// populate the status combobox 
		statusCombobox.addItem("INPUT");					
		statusCombobox.addItem("OUTPUT");

		// populate the name combobox 
		for (String name : pinName) {						
			portCombobox.addItem(name);

		}


		portCombobox.setSelectedItem(0);					// set the first port
		if(pinStatus.get(0).equals("INPUT")){
			statusCombobox.setSelectedIndex(0);					// set the pin value
		}else{
			statusCombobox.setSelectedIndex(1);			
		}

		updatePinValue(low, high, (String)statusCombobox.getSelectedItem());

		if(valuePin.get(0).equals("LOW")){					
			low.setSelected(true);
			high.setSelected(false);
		}else{
			low.setSelected(false);
			high.setSelected(true);
		}

	}

	public void selectName(JComboBox<String> portCombobox, JComboBox<String> statusCombobox ,
			JRadioButton low,JRadioButton high){

		getArduinoStatus();

		int portSelected 	= portCombobox.getSelectedIndex();
		String portStatus 	= pinStatus.get(portSelected);
		String value 		= valuePin.get(portSelected);

		if(portStatus.equals("INPUT")){
			statusCombobox.setSelectedIndex(0);
		}else{
			statusCombobox.setSelectedIndex(1);
		}

		updatePinValue(low, high, portStatus);
		if(value.equals("LOW")){					// set the pin value
			low.setSelected(true);
			high.setSelected(false);
		}else{
			low.setSelected(false);
			high.setSelected(true);
		}


	}

	public void selectPinStatus (JComboBox<String> statusCombobox ,
			JRadioButton low,JRadioButton high){

		String selectPinStatus = (String) statusCombobox.getSelectedItem();
		updatePinValue(low, high, selectPinStatus);

	}

	public void hendleButtonUpdate( JComboBox<String> portCombobox, JComboBox<String> statusCombobox ,
			JRadioButton low){
		String data = "";
		String selectedPinName = "";
		String selectedPinStatus = "";
		String selectedValuePin = "";

		ArduinoDAO arduinoDAO = new ArduinoDAO();


		selectedPinName = (String) portCombobox.getSelectedItem();
		selectedPinStatus = (String) statusCombobox.getSelectedItem();
		if(low.isSelected()){
			selectedValuePin = "LOW";
		}else{
			selectedValuePin = "HIGH";
		}

		data += selectedPinName + "," + selectedPinStatus + "," + selectedValuePin;
		arduinoDAO.write(data, true);

	}
	
	public void hendleButtonExit(Frame frame){
		frame.dispose();
	}


	private void updatePinValue(JRadioButton low,JRadioButton high, String selectPinStatus){

		if(selectPinStatus.equals("INPUT")){
			//we can't update the value for the input configuration
			low.setEnabled(false);
			high.setEnabled(false);
		}else{
			low.setEnabled(true);
			high.setEnabled(true);
		}

	}

	private void getArduinoStatus(){
		pinName   = Constants.ARDUINO.getDigPinName();
		pinStatus = Constants.ARDUINO.getDigPinStatus();
		valuePin  = Constants.ARDUINO.getValueDigPin();
	}
}
