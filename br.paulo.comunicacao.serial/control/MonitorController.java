package control;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import model.ArduinoDAO;
import model.Constants;
import view.Configuration;
/**
 * 
 * @author Paulo Pereira
 *
 */
public class MonitorController {




	public static void handleConfiguration(JButton configuration){
		Configuration config = new Configuration();
		if("Port configuration".equals(configuration.getActionCommand())){
			config.launch();
			
		}
	}


	public JTable populateJTable(){
		//declaration
		JTable table = new JTable();
		ArduinoDAO arduinoDAO = new ArduinoDAO();
		Object row [] = new Object[3];

		//arrays 
		ArrayList<String> digPinName   = new ArrayList<>();
		ArrayList<String> digPinStatus = new ArrayList<>();
		ArrayList<String> valueDigPin  = new ArrayList<>();

		
		//update the ARDUINO constaint with the new read datas  
		arduinoDAO.readData();

		
		DefaultTableModel dfTM = new DefaultTableModel(
				new Object[][]{
				},
				new String []{
						//header
						"Pin","Status","Value"
				}
		);


		//gets Arduino object arrays
		digPinName   = 	Constants.ARDUINO.getDigPinName();
		digPinStatus = 	Constants.ARDUINO.getDigPinStatus();
		valueDigPin  = 	Constants.ARDUINO.getValueDigPin();
		
		//put arrays values in collumns
		for(int i=0 ; i < 11 ; i++){
			row[0] = digPinName.get(i);
			row[1] = digPinStatus.get(i);
			row[2] = valueDigPin.get(i);
			dfTM.addRow(row);

		}
		//set default table model in table
		table.setModel(dfTM);

		return table;
	} 
}