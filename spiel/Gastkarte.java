package spiel;

public class Gastkarte {
	   public static enum Geschlecht {Mann, Frau};
	   public static enum Land {DE, FR, GB, US, TR, IN, CN, RU, ES, CU, CF, IT, JOKER};
	 
	   public final Land land;
	   public final Geschlecht geschlecht;
	 
	   public Gastkarte(Geschlecht geschlecht, Land land){
	      this.land = land;
	      this.geschlecht= geschlecht;
	   }
	 
	   public String toString(){
	     return land + ":" + geschlecht;
	   }
	}
