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
import spiel.Laenderkarte;
import spiel.Tisch;
import spiel.Stuhl;

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
	      System.out.println("("+ausgabenummer+") "+"Neues Spiel gestartet"); ausgabenummer += 1;
		return neuesspiel;
	  }
	 public static void spielstand() throws IOException{
		  Properties spielstand = loadProperties("spielstand.txt");
		  JOptionPane.showMessageDialog(null, "Ein Zwischengespeichertes Spiel wird wiederhergestellt!", "Weiterspielen", JOptionPane.INFORMATION_MESSAGE);
	      String spielername1 = spielstand.getProperty("spielername1", "Nicht vorhanden");
	      String spielername2 = spielstand.getProperty("spielername2", "Nicht vorhanden");
	      String string_ausgabenummer = spielstand.getProperty("ausgabenummer", "0");
	      ausgabenummer = Integer.parseInt(string_ausgabenummer);
	  	  String string_restkartentisch = spielstand.getProperty("restkartentisch", "0");
	      restkartentisch = Integer.parseInt(string_restkartentisch);
	      jLabelRestkartenTisch.setText("Resttische: "+restkartentisch);
	      String string_restkartengast = spielstand.getProperty("restkartengast", "0");
	      restkartengast = Integer.parseInt(string_restkartengast);
	      jLabelRestkartenGast.setText("Restgäste: "+restkartengast);
	      String string_restbarplaetze = spielstand.getProperty("restbarplaetze", "21");
	      restbarplaetze = Integer.parseInt(string_restbarplaetze);
	      jLabelRestbarplaetze.setText("Barplätze übrig: "+restbarplaetze); 
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
	      for(int x=0;x<5;x++) {
	    	  String handkartenwiederhergestellt = spielstand.getProperty("kartenspieler1N" + x);
	    	  String[] einzelkarte = handkartenwiederhergestellt.split(":");
	    	  Geschlecht geschlecht = Geschlecht.valueOf(einzelkarte[1]);
	    	  Land land = Land.valueOf(einzelkarte[0]);
	    	  kartenspieler1.add(new Gastkarte(geschlecht, land));
	      }
	      for(int x=0;x<5;x++) {
	    	  String handkartenwiederhergestellt = spielstand.getProperty("kartenspieler2N" + x);
	    	  String[] einzelkarte = handkartenwiederhergestellt.split(":");
	    	  Geschlecht geschlecht = Geschlecht.valueOf(einzelkarte[1]);
	    	  Land land = Land.valueOf(einzelkarte[0]);
	    	  kartenspieler2.add(new Gastkarte(geschlecht, land));
	      }
	      System.out.println("("+ausgabenummer+") "+"Ein altes Spiel wurde wiederhergestellt"); ausgabenummer += 1;
	      System.out.println("("+ausgabenummer+") "+"Gastkarten: "+gastkarten); ausgabenummer += 1;
	      System.out.println("("+ausgabenummer+") "+"Tischkarten: "+laenderkarten); ausgabenummer += 1;
	      System.out.println("("+ausgabenummer+") "+"Handkarten von "+spielername1+": "+kartenspieler1); ausgabenummer += 1;
		  System.out.println("("+ausgabenummer+") "+"Handkarten von "+spielername2+": "+kartenspieler2); ausgabenummer += 1;
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
	    	  System.out.println("("+ausgabenummer+") "+"Es wurden nicht alle Spielernamen eingetragen"); ausgabenummer += 1;
	    	  namensfrage(); 
	  	  }
	      else if(spielername1.equalsIgnoreCase(spielername2)) {
	    	  JOptionPane.showMessageDialog(null, "Bitte benenne die Spieler unterschiedlich!", "Namensgleichheit", JOptionPane.ERROR_MESSAGE);
	    	  System.out.println("("+ausgabenummer+") "+"Es wurde bei beiden Namen \""+spielername1+"\" eingetragen"); ausgabenummer += 1;
	    	  namensfrage(); 
	      }
	      else{
	    	  spielernamenkorrekt = true;
	    	  Properties spielstand = loadProperties("spielstand.txt");
	    	  try {
	        		spielstand.setProperty("spielername1",spielername1 + "");
	        		spielstand.setProperty("spielername2",spielername2 + "");
					spielstand.store(new FileWriter(filepath+"/spielstand/"+"spielstand.txt"),"Keine Speicherdatei");
	    	  } catch (IOException e) {
					e.printStackTrace();
	    	  }
	      }
	  }
	 public static void gastkartenmischen() {
		  for(int j=0;j<2;j++){
		    	for(Land land : Land.values()) {
		            int anzahl = 2;
		            if (land == Land.JOKER) {
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
		  	
		    jLabelRestkartenGast.setText("Restgäste: "+restkartengast);
		    Collections.shuffle(gastkarten);
		    System.out.println("("+ausgabenummer+") "+"Die Gastkarten wurden gemischt"); ausgabenummer += 1;
		    System.out.println("("+ausgabenummer+") "+""+gastkarten); ausgabenummer += 1;
		    for(int p=0;p<5;p++) {
		    	kartenspieler1.add(gastkarten.get(0));
		    	gastkarten.remove(0);
		    	restkartengast -= 1;
		    }
		    for(int p=0;p<5;p++) {
		    	kartenspieler2.add(gastkarten.get(0));
		    	gastkarten.remove(0);
			    restkartengast -= 1;
		    }
		    for(int n=0;n<gastkarten.size();n++){
		    	jListGastkartenModel.addElement(gastkarten.get(n));
		    }
		    jLabelRestkartenGast.setText("Restgäste: "+restkartengast);
		    System.out.println("("+ausgabenummer+") "+"Handkarten von "+spielername1+": "+kartenspieler1); ausgabenummer += 1;
		    System.out.println("("+ausgabenummer+") "+"Handkarten von "+spielername2+": "+kartenspieler2); ausgabenummer += 1;
	  }
	 public static void laenderkartenmischen() {
		 for(int n=0;n<2;n++) {
			 for(Land land : Land.values()) {
				 if (land != Land.JOKER) {
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
		 System.out.println("("+ausgabenummer+") "+"Die Tischkarten wurden gemischt"); ausgabenummer += 1;
		 System.out.println("("+ausgabenummer+") "+""+laenderkarten); ausgabenummer += 1;
	 }
	 public static void spielfeldgenerieren() {
		 //12 Tische & 24 Stühle werden erschaffen; außerdem bekommt jeder Stuhl ein Land aus der Länderkartenliste. Die erste Karte 0. Selbige wird danach vom Stapel entfernt.
		 for(int n=0;n<12;n++) {
			 tische.add(new Tisch());
			 tische.get(n).setLand(laenderkarten.get(0));
			 restkartentisch -= 1;
			 laenderkarten.remove(0);
			 jListLaenderkartenModel.remove(0);
		 }
		 jLabelRestkartenTisch.setText("Resttische: "+restkartentisch);
		 for(int n=0;n<24;n++) {
			 stuehle.add(new Stuhl());
		 }
		//=============================
		 tische.get(0).setStuehle(stuehle.get(11),stuehle.get(12),stuehle.get(13),stuehle.get(0));
		 tische.get(1).setStuehle(stuehle.get(1),stuehle.get(2),stuehle.get(12),stuehle.get(13));
		 tische.get(2).setStuehle(stuehle.get(2),stuehle.get(3),stuehle.get(13),stuehle.get(14));
		 tische.get(3).setStuehle(stuehle.get(3),stuehle.get(4),stuehle.get(5),stuehle.get(14));
		 tische.get(4).setStuehle(stuehle.get(4),stuehle.get(5),stuehle.get(15),stuehle.get(16));
		 tische.get(5).setStuehle(stuehle.get(5),stuehle.get(6),stuehle.get(16),stuehle.get(17));
		 tische.get(6).setStuehle(stuehle.get(6),stuehle.get(7),stuehle.get(17),stuehle.get(18));
		 tische.get(7).setStuehle(stuehle.get(7),stuehle.get(18),stuehle.get(19),stuehle.get(20));
		 tische.get(8).setStuehle(stuehle.get(7),stuehle.get(8),stuehle.get(20),stuehle.get(21));
		 tische.get(9).setStuehle(stuehle.get(8),stuehle.get(9),stuehle.get(21),stuehle.get(22));
		 tische.get(10).setStuehle(stuehle.get(9),stuehle.get(10),stuehle.get(22),stuehle.get(23));
		 tische.get(11).setStuehle(stuehle.get(9),stuehle.get(10),stuehle.get(11),stuehle.get(0));
		 stuehle.get(0).setTische(tische.get(11),tische.get(0));
		 stuehle.get(1).setTische(tische.get(1));
		 stuehle.get(2).setTische(tische.get(1),tische.get(2));
		 stuehle.get(3).setTische(tische.get(2),tische.get(3));
		 stuehle.get(4).setTische(tische.get(3),tische.get(4));
		 stuehle.get(5).setTische(tische.get(3),tische.get(4),tische.get(5));
		 stuehle.get(6).setTische(tische.get(5),tische.get(6));
		 stuehle.get(7).setTische(tische.get(6),tische.get(7),tische.get(8));
		 stuehle.get(8).setTische(tische.get(8),tische.get(9));
		 stuehle.get(9).setTische(tische.get(9),tische.get(10),tische.get(11));
		 stuehle.get(10).setTische(tische.get(10),tische.get(11));
		 stuehle.get(11).setTische(tische.get(11),tische.get(0));
		 stuehle.get(12).setTische(tische.get(0),tische.get(1));
		 stuehle.get(13).setTische(tische.get(1),tische.get(2),tische.get(0));
		 stuehle.get(14).setTische(tische.get(2),tische.get(3));
		 stuehle.get(15).setTische(tische.get(4));
		 stuehle.get(16).setTische(tische.get(4),tische.get(5));
		 stuehle.get(17).setTische(tische.get(5),tische.get(6));
		 stuehle.get(18).setTische(tische.get(6),tische.get(7));
		 stuehle.get(19).setTische(tische.get(7));
		 stuehle.get(20).setTische(tische.get(7),tische.get(8));
		 stuehle.get(21).setTische(tische.get(8),tische.get(9));
		 stuehle.get(22).setTische(tische.get(9),tische.get(10));
		 stuehle.get(23).setTische(tische.get(10));
		 //=============================
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
	    	  ausgabenummer = 1;
	    	  gastkarten.clear();
	    	  jListGastkartenModel.clear();
	    	  laenderkarten.clear();
	    	  jListLaenderkartenModel.clear();
	    	  kartenspieler1.clear();
	    	  kartenspieler2.clear();
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
	        spielstand.setProperty("punktespieler1",punktespieler1 + "");
	        spielstand.setProperty("punktespieler2",punktespieler2 + "");
	        spielstand.setProperty("spielername1",spielername1);
	        spielstand.setProperty("spielername2",spielername2);
	        spielstand.setProperty("spieler",spieler + "");
	        spielstand.setProperty("ausgabenummer",ausgabenummer + "");
	        for (int n=0;n<restkartengast; n++) {
	            spielstand.setProperty("gastkarten" + n, gastkarten.get(n) + "");
	        }
	        for (int q=0;q<restkartentisch;q++) {
	        	spielstand.setProperty("laenderkarten" + q, laenderkarten.get(q) + "");
	        }
	        for (int z=0;z<kartenspieler1.size();z++) {
	        	spielstand.setProperty("kartenspieler1N" + z, kartenspieler1.get(z) + "");
	        }
	        for (int z=0;z<kartenspieler2.size();z++) {
	        	spielstand.setProperty("kartenspieler2N" + z, kartenspieler2.get(z) + "");
	        }
	        spielstand.store(new FileWriter(filepath+"/spielstand/"+"spielstand.txt"),"Gespeichertes Spiel");
	        System.out.println("("+ausgabenummer+") "+"Das Spiel wurde beendet und der Spielstand abgespeichert"); ausgabenummer += 1;
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
					spielstand.store(new FileWriter(filepath+"/spielstand/"+"spielstand.txt"),"Keine Speicherdatei");
					System.out.println("("+ausgabenummer+") "+"Das Spiel wurde beendet, aber kein Spielstand gespeichert"); ausgabenummer += 1;
				} catch (IOException e) {
					e.printStackTrace();
				}
	          System.exit(0);
	        }
	      }
	 }
	 public static Properties loadProperties(String filename) throws IOException{
		 Reader reader = new BufferedReader(new FileReader(filepath+"/spielstand/"+filename));
		 Properties prop = new Properties();
		 try {
			 prop.load(reader);
		 }catch(FileNotFoundException ex){
			ex.printStackTrace();
		 	System.out.println("("+ausgabenummer+") "+"Die Datei " + filename + " existiert nicht!"); ausgabenummer += 1;
		 }
		 reader.close();
		 return prop;
	 }
	 
	 public static boolean isWindows() {
			return (OS.indexOf("win") >= 0);
	 }
	

}