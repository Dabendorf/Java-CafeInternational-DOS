package spiel;
import java.util.ArrayList;
import java.util.List;

import spiel.Laenderkarte;

/*public class Tisch {
	//public static enum Stuehle {stuhl0,stuhl1,stuhl2,stuhl3,stuhl4,stuhl5,stuhl6,stuhl7,stuhl8,stuhl9,stuhl10,stuhl11,stuhl12,stuhl13,stuhl14,stuhl15,stuhl16,stuhl17,stuhl18,stuhl19,stuhl20,stuhl21,stuhl22,stuhl23};
	//public static enum Tische {tisch0,tisch1,tisch2,tisch3,tisch4,tisch5,tisch6,tisch7,tisch8,tisch9,tisch10,tisch11};
	//public final Stuehle stuhl;
	
	public final Land land;
	
	public Tisch(Land land){
	      this.land = land;
	}
	

}*/

public class Tisch {
	   
   private List<Stuhl> stuehle = new ArrayList<Stuhl>();
	
    public Laenderkarte land;
	
	public Tisch(Laenderkarte land){
	      this.land = land;
	}
	
	public String toString(){
	     return land.toString();
	}
    
    public void addStuhl(Stuhl stuhl){
        if(stuehle.size() == 4){
            System.err.println("Kein Platz mehr fuer weitere Stuehle");
        } else {
            stuehle.add(stuhl);
        }
    }
 
}