package spiel;

public class Stuhl {
	   
    private Gastkarte gast;
    private Tisch tisch;
   
    public Stuhl(Gastkarte gast) {
    	this.gast = gast;
    }
    
    public void addToTisch(Tisch tisch){
        this.tisch = tisch;
    }
    
    public String toString(){
	     return gast + "";
	}
   
    public void addGast(Gastkarte gast){
        if(this.gast == null){
            this.gast = gast;
        } else {
            System.err.println("Der Stuhl ist bereits belegt!");
        }
    }
 
}