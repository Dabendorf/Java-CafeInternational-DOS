package spiel;

public class Stuhl {
	   
    private Gastkarte gast;
    public Tisch tisch;
   
    //public Stuhl(/*Gastkarte gast*/) {
    	//this.gast = gast;
    //}
    
    /*public Stuhl(Tisch... tische) {
    	this.tisch=tische;
    }*/
    
    /*public void addToTisch(Tisch tisch){
        this.tisch = tisch;
    }*/
    
	public Stuhl() {
		
	}
    public void addToTisch(Tisch...tisch) {
    	
    }
    
    //public String toString(){
	 //    return gast + "";
	//}
   
    /*public void addGast(Gastkarte gast){
        if(this.gast == null){
            this.gast = gast;
        } else {
            System.err.println("Der Stuhl ist bereits belegt!");
        }
    }*/
    
    public void addGast(Gastkarte gast){
        if(this.gast == null){
            this.gast = gast;
        } else {
            System.err.println("Der Stuhl ist bereits belegt!");
        }
    }
 
}