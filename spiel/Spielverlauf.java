package spiel;

import java.io.IOException;

public class Spielverlauf extends CafeRoot{
	private static final long serialVersionUID = 7888790160235600024L;

	public Spielverlauf() throws IOException{
		super(spielname);
	}
	
	public static void doseingabefenster() throws IOException {
		doseingabe = jTextFieldDosEingabe.getText();
		switch(doseingabe.toLowerCase()) {
		case "neustart":
			Spielstart.neustart();
			break;
		case "beenden":
			Spielstart.beenden();
		default:
		}
	}

}
