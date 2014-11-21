package spiel;

import java.awt.Container;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Komponenten extends CafeRoot{

	private static final long serialVersionUID = 8679344849572307992L;
	
	public Komponenten(String title) throws IOException {
		super(title);
	}
	
	public static void komponenten(Container cp) {
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
	    jLabelMeldung.setBounds(25, 465, 300, 30);
	    cp.add(jLabelMeldung);
	    jListGastkarten.setModel(jListGastkartenModel);
	    jListGastkartenScrollPane.setBounds(25, 210, 300, 100);
	    cp.add(jListGastkartenScrollPane);
	    jListLaenderkarten.setModel(jListLaenderkartenModel);
	    jListLaenderkartenScrollPane.setBounds(323, 60, 100, 100);
	    cp.add(jListLaenderkartenScrollPane);
	    jListBarkarten.setModel(jListBarkartenModel);
	    jListBarkartenScrollPane.setBounds(25, 320, 300, 100);
	    cp.add(jListBarkartenScrollPane);
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
	    jTextFieldDosEingabe.setBounds(25, 430, 456, 25);
	    cp.add(jTextFieldDosEingabe);
	    jTextFieldDosEingabe.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	try {
					DosEingabe.doseingabeverarbeitung();
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
	    }});
	}
	

}
