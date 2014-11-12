package spiel;
import spiel.Gastkarte.Land;

public class Laenderkarte {
	
	   public final Land land;
	 
	   public Laenderkarte(Land land){
	      this.land = land;
	   }
	 
	   public String toString(){
	     return land + "";
	   }
}
