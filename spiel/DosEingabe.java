package spiel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.Timer;

public class DosEingabe extends CafeRoot{
	private static final long serialVersionUID = -4405571455280382266L;

	public DosEingabe() throws IOException{
		super(spielname);
	}
	
	public static void doseingabeverarbeitung() throws IOException, InterruptedException {
		doseingabe = jTextFieldDosEingabe.getText();
		doseingabepart.clear();
		doseingabepart.addAll(Arrays.asList(doseingabe.split(":")));
		if (doseingabepart.size() > 3) {
			eingabeinkorrekt(5000); return;
		}
		doseingabefenster();
	}
	
	public static void doseingabefenster() throws IOException, InterruptedException {
		doseingabeerfolgt = true;
		switch(doseingabepart.get(0).toLowerCase()) {
		case "neustart":
			Spielstart.neustart();
			break;
		case "beenden":
			Spielstart.beenden();
			break;
		case "gastkartebar":
			information = doseingabepart.get(1);
			try{
				barkartennummer = Integer.parseInt(information);
			}
			catch(NumberFormatException e){
				e.printStackTrace();
				eingabeinkorrekt(5000); return;
			}
			catch(IndexOutOfBoundsException f){
				f.printStackTrace();
				eingabeinkorrekt(5000); return;
			}
			Punkte.barkarten();
			break;
			//Wichtige Anmerkung: Er fügt lediglich die Elementnummer von 0 bis 99 hinzu.
			//In Zukunft müssten dies jedoch die Karten 0 bis 4 des Spielers sein!
		default: doseingabeerfolgt = false;
		}
		if(doseingabeerfolgt == true) {
			jTextFieldDosEingabe.setText("");
			doseingabeerfolgt = false;
			jLabelMeldung.setText("");
		} else {
		eingabeinkorrekt(5000); return;
		}
	}
	
	public static void eingabeinkorrekt(int timerzeit) {
		jLabelMeldung.setText("Deine Eingabe war inkorrekt!");
		new Timer(timerzeit, new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		jLabelMeldung.setText("");
		} } ).start();
	}

}
