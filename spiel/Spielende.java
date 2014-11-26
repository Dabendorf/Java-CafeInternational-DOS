package spiel;

import java.io.IOException;

import javax.swing.JOptionPane;

public class Spielende extends CafeRoot{
	private static final long serialVersionUID = -3134860966645114291L;

	public Spielende() throws IOException{
		super(spielname);
	}
	
	public static void spielendeabrechnung() throws IOException {
		if(punktespieler1 > punktespieler2 + 20) {
			System.out.println("("+ausgabenummer+") "+spielername1+" gewinnt die Partie hochverdient!"); ausgabenummer += 1;
			System.out.println("("+ausgabenummer+") "+"Er gewinnt mit "+punktespieler1+" zu "+punktespieler2+ " Punkten."); ausgabenummer += 1;
			JOptionPane.showMessageDialog(null, "Das Spiel ist beendet!\n"+spielername1+" gewinnt deutlich mit "+punktespieler1+" zu "+punktespieler2+"\nHerzlichen Glückwunsch!", spielername1+" gewinnt", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(punktespieler1 > punktespieler2) {
			System.out.println("("+ausgabenummer+") "+spielername1+" gewinnt die Partie mit knappem Vorsprung!"); ausgabenummer += 1;
			System.out.println("("+ausgabenummer+") "+"Er gewinnt mit "+punktespieler1+" zu "+punktespieler2+ " Punkten."); ausgabenummer += 1;
			JOptionPane.showMessageDialog(null, "Das Spiel ist beendet!\n"+spielername1+" gewinnt knapp mit "+punktespieler1+" zu "+punktespieler2+"\nHerzlichen Glückwunsch!", spielername1+" gewinnt", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(punktespieler1 == punktespieler2) {
			System.out.println("("+ausgabenummer+") "+"Die Partie endet mit einem Remis."); ausgabenummer += 1;
			System.out.println("("+ausgabenummer+") "+"Beide Spieler erreichten eine Punktzahl von "+punktespieler1+" Punkten."); ausgabenummer += 1;
		}
		else if(punktespieler1 + 20 < punktespieler2) {
			System.out.println("("+ausgabenummer+") "+spielername2+" gewinnt die Partie hochverdient!"); ausgabenummer += 1;
			System.out.println("("+ausgabenummer+") "+"Er gewinnt mit "+punktespieler2+" zu "+punktespieler1+ " Punkten."); ausgabenummer += 1;
			JOptionPane.showMessageDialog(null, "Das Spiel ist beendet!\n"+spielername2+" gewinnt deutlich mit "+punktespieler2+" zu "+punktespieler1+"\nHerzlichen Glückwunsch!", spielername2+" gewinnt", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(punktespieler1 < punktespieler2) {
			System.out.println("("+ausgabenummer+") "+spielername2+" gewinnt die Partie mit knappem Vorsprung!"); ausgabenummer += 1;
			System.out.println("("+ausgabenummer+") "+"Er gewinnt mit "+punktespieler2+" zu "+punktespieler1+ " Punkten."); ausgabenummer += 1;
			JOptionPane.showMessageDialog(null, "Das Spiel ist beendet!\n"+spielername2+" gewinnt knapp mit "+punktespieler2+" zu "+punktespieler1+"\nHerzlichen Glückwunsch!", spielername2+" gewinnt", JOptionPane.INFORMATION_MESSAGE);
		}
		else{
			System.out.println("("+ausgabenummer+") "+"Es ist etwas schiefgelaufen. Bitte starte das Spiel neu."); ausgabenummer += 1;
			System.exit(0);
		}
	}
	
	public static void vorbei(String klinger) throws IOException {
		Spielstart.neuesspiel();
		/*Object[] options = {"Neues Spiel", "Beenden"};
		int schluss = JOptionPane.showOptionDialog(null,
			      klinger,
			      "Neues Spiel?",
			      JOptionPane.DEFAULT_OPTION, 
			      JOptionPane.QUESTION_MESSAGE, 
			      null, options, options[0]);
		if(schluss == 0) {
			Spielstart.neustart();
		} else {
			System.exit(0);
		}*/
	}
}
