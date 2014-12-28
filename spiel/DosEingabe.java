package spiel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.*;
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
			try{
				dosinfostring1 = doseingabepart.get(1);
				dosinfo1 = Integer.parseInt(dosinfostring1);
			}
			catch(NumberFormatException e){
				eingabeinkorrekt(5000); return;
			}
			catch(IndexOutOfBoundsException f){
				eingabeinkorrekt(5000); return;
			}
			if(!(dosinfo1 > 5 || dosinfo1 < 1)) {
				Punkte.barkarten();
			}else{
				eingabeinkorrekt(5000); return;
			}
			break;
		case "gastkartestuhl":
			try{
				dosinfostring1 = doseingabepart.get(1);
				dosinfo1 = Integer.parseInt(dosinfostring1);
				dosinfostring2 = doseingabepart.get(2);
				dosinfo2 = Integer.parseInt(dosinfostring2);
			}
			catch(NumberFormatException e){
				eingabeinkorrekt(5000); return;
			}
			catch(IndexOutOfBoundsException f){
				eingabeinkorrekt(5000); return;
			}
			if(!(dosinfo1 > 5 || dosinfo1 < 1) && (!(dosinfo2 > 24 || dosinfo2 < 1))) {
				Punkte.gastkartestuhl();
			}else{
				eingabeinkorrekt(5000); return;
			}
			break;
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
