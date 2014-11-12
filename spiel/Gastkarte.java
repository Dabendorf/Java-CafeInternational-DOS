package spiel;

public class Gastkarte {
	   public static enum Geschlecht {männlich, weiblich};
	   public static enum Land {Deutscher, Franzake, Brite, Amerikaner, Türke, Inder, Chinese, Russe, Spanier, Kubaner, Afrikaner, Italiener, Joker};
	 
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