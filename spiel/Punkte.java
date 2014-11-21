package spiel;

import java.io.IOException;

public class Punkte extends CafeRoot{
	private static final long serialVersionUID = -1118201319860805839L;
	
	private static int punkteaddition = 0;
	
	public Punkte() throws IOException{
		super(spielname);
	}
	
	public static void barkarten() {
		restbarplaetze -= 1;
		jLabelRestbarplaetze.setText("Barplätze übrig: "+restbarplaetze);
		jListBarkartenModel.addElement(gastkarten.get(barkartennummer));
		if(spieler == 1) {
			System.out.println(spielername1+" hat eine Karte in die Bar gelegt.");
		} else {
			System.out.println(spielername2+" hat eine Karte in die Bar gelegt.");
		}
		System.out.println("Es handelt sich um die Karte: "+gastkarten.get(barkartennummer));
		punktebarkarten();
	}
	
	public static void punktebarkarten() {
		switch(restbarplaetze) {
		case 20:
			punkteaddition = 1;
			break;
		case 19:
			punkteaddition = 2;
			break;
		case 18:
			punkteaddition = 3;
			break;
		case 17:
			punkteaddition = 4;
			break;
		case 16:
			punkteaddition = 5;
			break;
		case 15:
			punkteaddition = -2;
			break;
		case 14:
			punkteaddition = -4;
			break;
		case 13:
			punkteaddition = -6;
			break;
		case 12:
			punkteaddition = -8;
			break;
		case 11:
			punkteaddition = -10;
			break;
		case 10:
			punkteaddition = -4;
			break;
		case 9:
			punkteaddition = -6;
			break;
		case 8:
			punkteaddition = -8;
			break;
		case 7:
			punkteaddition = -10;
			break;
		case 6:
			punkteaddition = -12;
			break;
		case 5:
			punkteaddition = -6;
			break;
		case 4:
			punkteaddition = -8;
			break;
		case 3:
			punkteaddition = -10;
			break;
		case 2:
			punkteaddition = -12;
			break;
		case 1:
			punkteaddition = -14;
			break;
		case 0:
			punkteaddition = -16;
			break;
		default: System.out.println("Irgendwas muss da falsch gelaufen sein...");
		}
		if(spieler == 1) {
			punktespieler1 += punkteaddition;
			spieler = 2;
			jLabelSpieler.setText("Am Zug: "+spielername2);
			System.out.println("Damit ist nun "+spielername2+" am Zug.");
		} else {
			punktespieler2 += punkteaddition;
			spieler = 1;
			jLabelSpieler.setText("Am Zug: "+spielername1);
			System.out.println("Damit ist nun "+spielername1+" am Zug.");
		}
		jLabelPunkteSpieler1.setText("Punkte "+spielername1+": "+punktespieler1);
		jLabelPunkteSpieler2.setText("Punkte "+spielername2+": "+punktespieler2);
		if(restbarplaetze == 0) {
			System.out.println("Alle Barplätze sind belegt. Damit ist das Spiel beendet.");
			Spielende.spielendeabrechnung();
		}
	}


}
