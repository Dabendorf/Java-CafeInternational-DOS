package spiel;

import java.io.IOException;

public class Spielende extends CafeRoot{
	private static final long serialVersionUID = -3134860966645114291L;

	public Spielende() throws IOException{
		super(spielname);
	}
	
	public static void spielendeabrechnung() {
		if(punktespieler1 > punktespieler2 + 20) {
			System.out.println(spielername1+" gewinnt die Partie hochverdient!");
			System.out.println("Er gewinnt mit "+punktespieler1+" zu "+punktespieler2+ " Punkten.");
		}
		else if(punktespieler1 > punktespieler2) {
			System.out.println(spielername1+" gewinnt die Partie mit knappem Vorsprung!");
			System.out.println("Er gewinnt mit "+punktespieler1+" zu "+punktespieler2+ " Punkten.");
		}
		else if(punktespieler1 == punktespieler2) {
			System.out.println("Die Partie endet mit einem Remis.");
			System.out.println("Beide Spieler erreichten eine Punktzahl von "+punktespieler1+" Punkten.");
		}
		else if(punktespieler1 + 20 < punktespieler2) {
			System.out.println(spielername2+" gewinnt die Partie hochverdient!");
			System.out.println("Er gewinnt mit "+punktespieler2+" zu "+punktespieler1+ " Punkten.");
		}
		else if(punktespieler1 < punktespieler2) {
			System.out.println(spielername2+" gewinnt die Partie mit knappem Vorsprung!");
			System.out.println("Er gewinnt mit "+punktespieler2+" zu "+punktespieler1+ " Punkten.");
		}
		else{
			System.out.println("Es ist etwas schiefgelaufen. Bitte starte das Spiel neu.");
		}
	}
}
