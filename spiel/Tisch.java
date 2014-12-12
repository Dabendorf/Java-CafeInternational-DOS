package spiel;
import java.util.ArrayList;
import java.util.List;

import spiel.Laenderkarte;

public class Tisch {
	   
   private List<Stuhl> stuehle = new ArrayList<Stuhl>();
	
    public Laenderkarte land;
    public Stuhl stuhl;
	//private Stuhl[] stuhl;
	
    public Tisch(){

	}
	//public Tisch(/*Laenderkarte land*/){
	      //this.land = land;
	//}
	
	/*public Tisch(Stuhl ...stuehle) {
		this.stuhl = stuehle;
	}*/
	
	//public String toString(){
	     //return land.toString();
	//}
    
	public void addStuhl(Stuhl stuhl){
        if(stuehle.size() == 4){
            System.err.println("Kein Platz mehr fuer weitere Stuehle");
        } else {
            stuehle.add(stuhl);
        }
    }
	
	public void addLandToTisch(Laenderkarte land) {
		
	}
 
}