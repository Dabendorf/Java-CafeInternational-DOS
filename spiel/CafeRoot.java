package spiel;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.*;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * @version 1.6
 * Neuerungen in 1.6:
 * Neu erstellte Klassen: DosEingabe, Komponenten, Punkte, Spielende
 * Komponenten aus Übersichtlichkeit in Einzelklasse ausgelagert, Punkteberechnung hinzugefügt, DOS-Eingabe filtert einzelne Ereignisse heraus
 * Spielendszenarium Barplätze erstellt, Variablen Männlich und Türke umlautfrei gemacht, viele kleine Fehlerkorrekturen
 * @author Lukas Schramm
 */

public class CafeRoot extends JFrame {
  
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
  protected static JList<Gastkarte> jListGastkarten = new JList<Gastkarte>();
  protected static DefaultListModel<Gastkarte> jListGastkartenModel = new DefaultListModel<Gastkarte>();
  protected static JScrollPane jListGastkartenScrollPane= new JScrollPane(jListGastkarten);
  protected static JLabel jLabelRestkartenTisch = new JLabel();
  protected static JLabel jLabelRestkartenGast = new JLabel();
  protected static JLabel jLabelRestbarplaetze = new JLabel();
  protected static JLabel jLabelHandkartenSpieler1 = new JLabel();
  protected static JLabel jLabelHandkartenSpieler2 = new JLabel();
  protected static JLabel jLabelPunkteSpieler1 = new JLabel();
  protected static JLabel jLabelPunkteSpieler2 = new JLabel();
  protected static JLabel jLabelSpieler = new JLabel();
  protected static JLabel jLabelMeldung = new JLabel();
  protected static boolean spielernamenkorrekt = false;
  protected static boolean neuesspielbutton = false;
  protected static JButton jButtonNeustart = new JButton();
  protected static JList<Laenderkarte> jListLaenderkarten = new JList<Laenderkarte>();
  protected static DefaultListModel<Laenderkarte> jListLaenderkartenModel = new DefaultListModel<Laenderkarte>();
  protected static JScrollPane jListLaenderkartenScrollPane = new JScrollPane(jListLaenderkarten);
  protected static JList<Gastkarte> jListBarkarten = new JList<Gastkarte>();
  protected static DefaultListModel<Gastkarte> jListBarkartenModel = new DefaultListModel<Gastkarte>();
  protected static JScrollPane jListBarkartenScrollPane= new JScrollPane(jListBarkarten);
  protected static JTextField jTextFieldDosEingabe = new JTextField();
  protected static String doseingabe = "";
  protected static boolean doseingabeerfolgt = false;
  protected static ArrayList<String> doseingabepart = new ArrayList<String>();
  protected static int barkartennummer = 0;
  protected static String information = "";
  // Ende Attribute
  
  public CafeRoot(String title) throws IOException {
    // Frame-Initialisierung
    super(title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    //Properties neuesspiel = Spielstart.loadProperties("neuesspiel.txt");
    Properties spielstand = Spielstart.loadProperties("spielstand.txt");
    int frameWidth = 600;//506 
    int frameHeight = 600;//434
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
    Komponenten.komponenten(cp);
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
    /*if(restkartentisch > -1 && restkartengast > 0 && restbarplaetze > 0) {
    	System.out.println("Das Spiel ist beendet!");
    }
    do{
    	//
    }while(restkartentisch > -1 && restkartengast > 0 && restbarplaetze > 0);*/
    
    
    // Ende Komponenten
    
    setVisible(true);
    addWindowListener(new MyWindowListener(this, spielstand));
    //=============================
    
    /*Random wuerfel1 = new Random(); //Würfeltest
    int wuerfel = wuerfel1.nextInt(49)+1; //Würfeltest
    System.out.println(wuerfel);*/
  }
  
  // Anfang Methoden
  
  public static void jButtonNeustart_ActionPerformed(ActionEvent evt) throws IOException {
	  Spielstart.neustart();
  }
 
  // Ende Methoden
  
  public static void main(String[] args) throws IOException {
    new CafeRoot("CafeRoot");
  } // end of main 
  public class MyWindowListener implements WindowListener {
    private CafeRoot cRoot;
    
    public MyWindowListener(CafeRoot cRoot,Properties spielstand) {
      this.cRoot = cRoot;
    }
    
    @Override
    public void windowActivated(WindowEvent arg0) { }
    
    @Override
    public void windowClosed(WindowEvent arg0) {
      cRoot.setVisible(false);  
    }
    
    @Override
    public void windowClosing(WindowEvent evt) {
      try {
		Spielstart.beenden();
      } catch (IOException e) {
		e.printStackTrace();
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
