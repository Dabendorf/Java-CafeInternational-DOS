package spiel;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

/**
  * @version 1.5.2 Spielstart & Kartenmischen, Namensabfrage, Windoof-Veraltungsabfrage sowie Spielstandsabspeicherung und Neustartfunktion
  * Neuerungen:
  * 1.5.1: Auslagerung in Startmethoden "Spielstart" und effektivierer Reader eingebaut
  * 1.5.2: Hinzufügen einer jList für die Länderkarten
  * 1.5.3: Umfangreiche Neugenerierung der Länder-Tisch-Karten und Abbildung in einer jList
  * 1.5.4: Abspeichern der Länderkarten
  * @author Lukas Schramm
  */

public class CafeRoot extends JFrame {
  
  //private Spielstart start; 

  protected static final long serialVersionUID = 2463407896592093246L;
  // Anfang Attribute
  protected static String spielname = "Café International";
  protected static String OS = System.getProperty("os.name").toLowerCase();
  protected static int spielangefangen = 0;
  protected static int restkartentisch = 0;
  protected static int restkartengast = 0;
  protected static int restbarplaetze = 0;
  protected static int handkartenspieler1 = 0;
  protected static int handkartenspieler2 = 0;
  protected static int punktespieler1 = 0;
  protected static int punktespieler2 = 0;
  protected static int spieler = 0;
  protected static String spielername1 = "Spieler 1";
  protected static String spielername2 = "Spieler 2";
  protected static List<Gastkarte> gastkarten = new ArrayList<Gastkarte>();
  protected static List<Laenderkarte> laenderkarten = new ArrayList<Laenderkarte>();
  protected JList<Gastkarte> jListGastkarten = new JList<Gastkarte>();
  protected static DefaultListModel<Gastkarte> jListGastkartenModel = new DefaultListModel<Gastkarte>();
  protected JScrollPane jListGastkartenScrollPane= new JScrollPane(jListGastkarten);
  protected static JLabel jLabelRestkartenTisch = new JLabel();
  protected static JLabel jLabelRestkartenGast = new JLabel();
  protected static JLabel jLabelRestbarplaetze = new JLabel();
  protected static JLabel jLabelHandkartenSpieler1 = new JLabel();
  protected static JLabel jLabelHandkartenSpieler2 = new JLabel();
  protected static JLabel jLabelPunkteSpieler1 = new JLabel();
  protected static JLabel jLabelPunkteSpieler2 = new JLabel();
  protected static JLabel jLabelSpieler = new JLabel();
  protected static boolean spielernamenkorrekt = false;
  protected static boolean neuesspielbutton = false;
  protected JButton jButtonNeustart = new JButton();
  protected JList<Laenderkarte> jListLaenderkarten = new JList<Laenderkarte>();
  protected static DefaultListModel<Laenderkarte> jListLaenderkartenModel = new DefaultListModel<Laenderkarte>();
  protected JScrollPane jListLaenderkartenScrollPane = new JScrollPane(jListLaenderkarten);
  // Ende Attribute
  
  public CafeRoot(String title) throws IOException {
    // Frame-Initialisierung
    super(title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    //Properties neuesspiel = Spielstart.loadProperties("neuesspiel.txt");
    Properties spielstand = Spielstart.loadProperties("spielstand.txt");
    int frameWidth = 506; 
    int frameHeight = 434;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setResizable(false);
    Container cp = getContentPane();
    setTitle(spielname);
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    setLocationRelativeTo(null);
    cp.setLayout(null);
    
    // Anfang Komponenten
    jLabelRestkartenTisch.setBounds(25, 10, 100, 30);
    cp.add(jLabelRestkartenTisch);
    jLabelRestkartenGast.setBounds(25, 35, 100, 30);
    cp.add(jLabelRestkartenGast);
    jLabelRestbarplaetze.setBounds(25, 60, 120, 30);
    cp.add(jLabelRestbarplaetze);
    jLabelHandkartenSpieler1.setBounds(25, 85, 140, 30);
    cp.add(jLabelHandkartenSpieler1);
    jLabelHandkartenSpieler2.setBounds(25, 110, 140, 30);
    cp.add(jLabelHandkartenSpieler2);
    jLabelPunkteSpieler1.setBounds(25, 135, 140, 30);
    cp.add(jLabelPunkteSpieler1);
    jLabelPunkteSpieler2.setBounds(25, 160, 140, 30);
    cp.add(jLabelPunkteSpieler2);
    jLabelSpieler.setBounds(25, 185, 140, 30);
    cp.add(jLabelSpieler);
    jListGastkarten.setModel(jListGastkartenModel);
    jListGastkartenScrollPane.setBounds(25, 210, 300, 100);
    cp.add(jListGastkartenScrollPane);
    jListLaenderkarten.setModel(jListLaenderkartenModel);
    jListLaenderkartenScrollPane.setBounds(323, 60, 100, 100);
    cp.add(jListLaenderkartenScrollPane);
    jButtonNeustart.setBounds(320, 16, 105, 41);
    jButtonNeustart.setText("Nouveau!");
    jButtonNeustart.setMargin(new Insets(2, 2, 2, 2));
    jButtonNeustart.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        try {
			jButtonNeustart_ActionPerformed(evt);
		} catch (IOException e) {
			e.printStackTrace();
		}
      }
    });
    cp.add(jButtonNeustart);
    //=============================
    String string_spielangefangen = spielstand.getProperty("spielangefangen", "0");
    int spielangefangen = Integer.parseInt(string_spielangefangen);
    if (Spielstart.isWindows()) {
        JOptionPane.showMessageDialog(null, "Dein System ist hoffnungslos veraltet!\nWindoof ist nicht kompatibel mit diesem Spiel.\nSollte es zu Problemen bei der Ausführung kommen,\ndann öffne das Spiel bitte auf einem PC\nmit Mac OS oder Linux!", "System veraltet", JOptionPane.WARNING_MESSAGE);
        System.out.println("Ein veraltetes System \"Windows\" wurde entdeckt");
        }
    if(spielangefangen == 0) {
    	do{
    		Spielstart.namensfrage();
    	}while(spielernamenkorrekt == false);
    	System.out.println("Spieler 1 heißt: "+spielername1);
        System.out.println("Spieler 2 heißt: "+spielername2);
        Spielstart.neuesspiel();
        Spielstart.gastkartenmischen();
        Spielstart.laenderkartenmischen();
    }
    else{
    	Spielstart.spielstand();
    }
    
    
    // Ende Komponenten
    
    setVisible(true);
    addWindowListener(new MyWindowListener(this, spielstand));
    //=============================
    
    Random wuerfel1 = new Random(); //Würfeltest
    int wuerfel = wuerfel1.nextInt(49)+1; //Würfeltest
    System.out.println(wuerfel);
  }
  
  // Anfang Methoden
  
  public void jButtonNeustart_ActionPerformed(ActionEvent evt) throws IOException {
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
 
  // Ende Methoden
  
  public static void main(String[] args) throws IOException {
    new CafeRoot("CafeRoot");
  } // end of main 
  public class MyWindowListener implements WindowListener {
    private Properties spielstand;
    private CafeRoot cRoot;
    
    public MyWindowListener(CafeRoot cRoot,Properties spielstand) {
      this.cRoot = cRoot;
      this.spielstand = spielstand;
    }
    
    @Override
    public void windowActivated(WindowEvent arg0) { }
    
    @Override
    public void windowClosed(WindowEvent arg0) {
      cRoot.setVisible(false);  
    }
    
    @Override
    public void windowClosing(WindowEvent evt)
    {
      final JFrame Beenden = new JFrame("Ein Frame zum Schließen");
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
    
    @Override
    public void windowDeactivated(WindowEvent arg0) { }
    @Override
    public void windowDeiconified(WindowEvent arg0) { }
    @Override
    public void windowIconified(WindowEvent arg0) { }
    @Override
    public void windowOpened(WindowEvent arg0) { }
    
    
  }
} // end of class CafeRoot
