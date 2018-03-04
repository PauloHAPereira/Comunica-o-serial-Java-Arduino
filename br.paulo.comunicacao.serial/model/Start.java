package model;

import view.StartScreen;
/**
 * 
 * @author Paulo Pereira
 *
 */
public class Start {
	public static void main(String[] args) {
		Arduino arduino = new Arduino();
		Constants.ARDUINO = arduino;
		StartScreen telaInicial = new StartScreen();
		telaInicial.launch();
	}
}
