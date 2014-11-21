package spiel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Collections;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import spiel.Gastkarte.Geschlecht;
import spiel.Gastkarte.Land;

public class Spielstart extends CafeRoot{
	
	private static final long serialVersionUID = 4759436681262448461L;
	
	public Spielstart() throws IOException{
		
		super(spielname);
	}
	
	 public static Properties neuesspiel() throws IOException{
		 Properties neuesspiel = loadProperties("neuesspiel.txt");
		  if(neuesspielbutton == true) {
			  Properties spielstand = loadProperties("spielstand.txt");
			  spielername1 = spielstand.getProperty("spielername1", "Nicht vorhanden");
		      spielername2 = spielstand.getProperty("spielername2", "Nicht vorhanden");
		  }
		  String string_restkartentisch = neuesspiel.getProperty("restkartentisch", "24");
	      restkartentisch = Integer.parseInt(string_restkartentisch);
	      jLabelRestkartenTisch.setText("Resttische: "+restkartentisch);
	      String string_restkartengast = neuesspiel.getProperty("restkartengast", "0");
	      restkartengast = Integer.parseInt(string_restkartengast);
	      jLabelRestkartenGast.setText("Restgäste: "+restkartengast);
	      String string_restbarplaetze = neuesspiel.getProperty("restbarplaetze", "21");
	      restbarplaetze = Integer.parseInt(string_restbarplaetze);
	      jLabelRestbarplaetze.setText("Barplätze übrig: "+restbarplaetze); 
	      String string_handkartenspieler1 = neuesspiel.getProperty("handkartenspieler1", "0");
	      handkartenspieler1 = Integer.parseInt(string_handkartenspieler1);
	      jLabelHandkartenSpieler1.setText("Karten "+spielername1+": "+handkartenspieler1);
	      String string_handkartenspieler2 = neuesspiel.getProperty("handkartenspieler2", "0");
	      handkartenspieler2 = Integer.parseInt(string_handkartenspieler2);
	      jLabelHandkartenSpieler2.setText("Karten "+spielername2+": "+handkartenspieler2);
	      String string_punktespieler1 = neuesspiel.getProperty("punktespieler1", "0");
	      punktespieler1 = Integer.parseInt(string_punktespieler1);
	      jLabelPunkteSpieler1.setText("Punkte "+spielername1+": "+punktespieler1);
	      String string_punktespieler2 = neuesspiel.getProperty("punktespieler2", "0");
	      punktespieler2 = Integer.parseInt(string_punktespieler2);
	      jLabelPunkteSpieler2.setText("Punkte "+spielername2+": "+punktespieler2);
	      String string_spieler = neuesspiel.getProperty("spieler", "1");
	      spieler = Integer.parseInt(string_spieler);
	      if(spieler == 1){
	      	jLabelSpieler.setText("Am Zug: "+spielername1);
	      }
	      else{
	      	jLabelSpieler.setText("Am Zug: "+spielername2);
	      }
	      System.out.println("Neues Spiel gestartet");
		return neuesspiel;
	  }
	 public static void spielstand() throws IOException{
		  Properties spielstand = loadProperties("spielstand.txt");
		  JOptionPane.showMessageDialog(null, "Ein Zwischengespeichertes Spiel wird wiederhergestellt!", "Weiterspielen", JOptionPane.INFORMATION_MESSAGE);
	      String spielername1 = spielstand.getProperty("spielername1", "Nicht vorhanden");
	      String spielername2 = spielstand.getProperty("spielername2", "Nicht vorhanden");
	  	  String string_restkartentisch = spielstand.getProperty("restkartentisch", "0");
	      restkartentisch = Integer.parseInt(string_restkartentisch);
	      jLabelRestkartenTisch.setText("Resttische: "+restkartentisch);
	      String string_restkartengast = spielstand.getProperty("restkartengast", "0");
	      restkartengast = Integer.parseInt(string_restkartengast);
	      jLabelRestkartenGast.setText("Restgäste: "+restkartengast);
	      String string_restbarplaetze = spielstand.getProperty("restbarplaetze", "21");
	      restbarplaetze = Integer.parseInt(string_restbarplaetze);
	      jLabelRestbarplaetze.setText("Barplätze übrig: "+restbarplaetze); 
	      String string_handkartenspieler1 = spielstand.getProperty("handkartenspieler1", "0");
	      handkartenspieler1 = Integer.parseInt(string_handkartenspieler1);
	      jLabelHandkartenSpieler1.setText("Karten "+spielername1+": "+handkartenspieler1);
	      String string_handkartenspieler2 = spielstand.getProperty("handkartenspieler2", "0");
	      handkartenspieler2 = Integer.parseInt(string_handkartenspieler2);
	      jLabelHandkartenSpieler2.setText("Karten "+spielername2+": "+handkartenspieler2);
	      String string_punktespieler1 = spielstand.getProperty("punktespieler1", "0");
	      punktespieler1 = Integer.parseInt(string_punktespieler1);
	      jLabelPunkteSpieler1.setText("Punkte "+spielername1+": "+punktespieler1);
	      String string_punktespieler2 = spielstand.getProperty("punktespieler2", "0");
	      punktespieler2 = Integer.parseInt(string_punktespieler2);
	      jLabelPunkteSpieler2.setText("Punkte "+spielername2+": "+punktespieler2);
	      String string_spieler = spielstand.getProperty("spieler", "1");
	      spieler = Integer.parseInt(string_spieler);
	      if(spieler == 1){
	      	jLabelSpieler.setText("Am Zug: "+spielername1);
	      }
	      else{
	      	jLabelSpieler.setText("Am Zug: "+spielername2);
	      }
	      gastkarten.clear();
	      jListGastkartenModel.clear();
	      for(int n=0;n<restkartengast;n++) {
	          String gastkartewiederhergestellt = spielstand.getProperty("gastkarten" + n);
	          String[] einzelkarte = gastkartewiederhergestellt.split(":");
	          Geschlecht geschlecht = Geschlecht.valueOf(einzelkarte[1]);
	          Land land = Land.valueOf(einzelkarte[0]);
	          gastkarten.add(new Gastkarte(geschlecht, land));
	          jListGastkartenModel.addElement(gastkarten.get(n));
	      }
	      for(int q=0;q<restkartentisch;q++){
	    	  String laenderkartewiederhergestellt = spielstand.getProperty("laenderkarten" + q);
	    	  Land land = Land.valueOf(laenderkartewiederhergestellt);
	    	  laenderkarten.add(new Laenderkarte(land));
	    	  jListLaenderkartenModel.addElement(laenderkarten.get(q));
	      }
	      System.out.println("Ein altes Spiel wurde wiederhergestellt");
	      System.out.println("Gastkarten: "+gastkarten);
	      System.out.println("Tischkarten: "+laenderkarten);
	  }
	 public static void namensfrage() throws IOException {
		  JTextField spielername01 = new JTextField(new MaxSizeDocument(12), "", 0);
		  JTextField spielername02 = new JTextField(new MaxSizeDocument(12), "", 0);
	      Object[] namensfrage = {"Name von Spieler 1", spielername01, "Name von Spieler 2", spielername02};
	      JOptionPane pane = new JOptionPane(namensfrage, JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION);
	      pane.createDialog(null, "Wie heißen die Spieler?").setVisible(true);
	      spielername1 = spielername01.getText();
	      spielername2 = spielername02.getText();
	      if(spielername1.equals("") || spielername2.equals("")) {
	    	  JOptionPane.showMessageDialog(null, "Bitte gib beide Spielernamen ein!", "Unvollständige Eingabe", JOptionPane.ERROR_MESSAGE);
	    	  System.out.println("Es wurden nicht alle Spielernamen eingetragen");
	    	  namensfrage(); 
	  	  }
	      else if(spielername1.equalsIgnoreCase(spielername2)) {
	    	  JOptionPane.showMessageDialog(null, "Bitte benenne die Spieler unterschiedlich!", "Namensgleichheit", JOptionPane.ERROR_MESSAGE);
	    	  System.out.println("Es wurde bei beiden Namen \""+spielername1+"\" eingetragen");
	    	  namensfrage(); 
	      }
	      else{
	    	  spielernamenkorrekt = true;
	    	  Properties spielstand = loadProperties("spielstand.txt");
	    	  try {
	        		spielstand.setProperty("spielername1",spielername1 + "");
	        		spielstand.setProperty("spielername2",spielername2 + "");
					spielstand.store(new FileWriter("spielstand.txt"),"Keine Speicherdatei");
	    	  } catch (IOException e) {
					e.printStackTrace();
	    	  }
	      }
	  }
	 public static void gastkartenmischen() {
		  for(int j=0;j<2;j++){
		    	for(Land land : Land.values()) {
		            int anzahl = 2;
		            if (land == Land.Joker) {
		               anzahl = 1;
		            }
		            for(int i = 0; i < anzahl; i++) {
		                for(Geschlecht geschlecht : Geschlecht.values()) {
		                    gastkarten.add(new Gastkarte(geschlecht, land));
		                    restkartengast = restkartengast + 1;
		                }    
		            }
		        }
		    }
		  	
		  	/*Gastkarte eineGastkarte = gastkarten.get(0);
		  	Geschlecht geschlecht = eineGastkarte.geschlecht;
		  	Land land = eineGastkarte.land;
		    
		    if(land == Land.Chinese) {
		       System.out.println("Nihao!");
		    }*/
		    jLabelRestkartenGast.setText("Restgäste: "+restkartengast);
		    Collections.shuffle(gastkarten);
		    for(int n=0;n<gastkarten.size();n++){
		    	jListGastkartenModel.addElement(gastkarten.get(n));
		    }
		    System.out.println("Die Gastkarten wurden gemischt");
		    System.out.println(gastkarten);
	  }
	 public static void laenderkartenmischen() {
		 for(int n=0;n<2;n++) {
			 for(Land land : Land.values()) {
				 if (land != Land.Joker) {
				 laenderkarten.add(new Laenderkarte(land));
				 restkartentisch += 1;
				 }
			 }
		 }
		 jLabelRestkartenTisch.setText("Resttische: "+restkartentisch);
		 Collections.shuffle(laenderkarten);
		 for(int p=0;p<restkartentisch;p++) {
			 jListLaenderkartenModel.addElement(laenderkarten.get(p));
		 }
		 System.out.println("Die Tischkarten wurden gemischt");
		 System.out.println(laenderkarten);
	 }
	 public static void neustart() throws IOException {
		 final JFrame Neustart = new JFrame("Ein Frame zum Schließen");
	      Neustart.setTitle("Spiel neustarten");
	      Object[] options = {"Neustarten", "Abbrechen"};
	      int neustart = JOptionPane.showOptionDialog(null,
	      "Möchtest Du das Spiel wirklich neustarten?\nDein Spielstand wird verloren gehen!",
	      "Café International neustarten?",
	      JOptionPane.DEFAULT_OPTION, 
	      JOptionPane.QUESTION_MESSAGE, 
	      null, options, options[0]);
	      if(neustart == 0) {
	    	  gastkarten.clear();
	    	  jListGastkartenModel.clear();
	    	  laenderkarten.clear();
	    	  jListLaenderkartenModel.clear();
	    	  neuesspielbutton = true;
	    	  Spielstart.neuesspiel();
	    	  neuesspielbutton = false;
	    	  Spielstart.gastkartenmischen();
	    	  Spielstart.laenderkartenmischen();
	      }
	 }
	 public static void beenden() throws IOException {
		  final JFrame Beenden = new JFrame("Ein Frame zum Schließen");
		  Properties spielstand = loadProperties("spielstand.txt");
	      Beenden.setTitle("Spiel beenden");
	      Object[] options = {"Speichern", "Beenden", "Abbrechen"};
	      int beenden = JOptionPane.showOptionDialog(null,
	      "Möchtest Du das Spiel wirklich beenden?\nDein Spielstand wird verloren gehen!",
	      "Café International beenden?",
	      JOptionPane.DEFAULT_OPTION, 
	      JOptionPane.QUESTION_MESSAGE, 
	      null, options, options[0]);
	      if(beenden == 0)
	      {
	      try {
	        spielangefangen = 1;
	        spielstand.setProperty("spielangefangen",spielangefangen + "");
	        spielstand.setProperty("restkartentisch",restkartentisch + "");
	        spielstand.setProperty("restkartengast",restkartengast + "");
	        spielstand.setProperty("restbarplaetze",restbarplaetze + "");
	        spielstand.setProperty("handkartenspieler1",handkartenspieler1 + "");
	        spielstand.setProperty("handkartenspieler2",handkartenspieler2 + "");
	        spielstand.setProperty("punktespieler1",punktespieler1 + "");
	        spielstand.setProperty("punktespieler2",punktespieler2 + "");
	        spielstand.setProperty("spielername1",spielername1);
	        spielstand.setProperty("spielername2",spielername2);
	        spielstand.setProperty("spieler",spieler + "");
	        for (int n=0;n<restkartengast; n++) {
	            spielstand.setProperty("gastkarten" + n, gastkarten.get(n) + "");
	        }
	        for (int q=0;q<restkartentisch;q++) {
	        	spielstand.setProperty("laenderkarten" + q, laenderkarten.get(q) + "");
	        }
	        spielstand.store(new FileWriter("spielstand.txt"),"Gespeichertes Spiel");
	        System.out.println("Das Spiel wurde beendet und der Spielstand abgespeichert");
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	        System.exit(0);
	      }
	      else{
	        if(beenden == 1) {
	        	try {
	        		spielangefangen = 0;
	        		spielstand.setProperty("spielangefangen",spielangefangen + "");
					spielstand.store(new FileWriter("spielstand.txt"),"Keine Speicherdatei");
					System.out.println("Das Spiel wurde beendet, aber kein Spielstand gespeichert");
				} catch (IOException e) {
					e.printStackTrace();
				}
	          System.exit(0);
	        }
	      }
	 }
	 public static Properties loadProperties(String filename) throws IOException{
	        Reader reader = new BufferedReader(new FileReader(filename));
	           Properties prop = new Properties();
	           try {
	             prop.load(reader);
	           }catch(FileNotFoundException ex){
	              ex.printStackTrace();
	              System.out.println("Die Datei " + filename + " existiert nicht!");
	           }
	           reader.close();
	           return prop;
	 }
	 
	 public static boolean isWindows() {
			return (OS.indexOf("win") >= 0);
	 }
	

}