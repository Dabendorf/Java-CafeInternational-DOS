package spiel;

public class Stuhl {

	private Gastkarte gast;
    public Tisch[] tische;
    
    public String toString() {
		return "Stuhl [gast=" + gast + ", tisch=" + tische + "]";
	}
    
	public Gastkarte getGast() {
		return gast;
	}
	public void setGast(Gastkarte gast) {
		if(this.gast == null){
            this.gast = gast;
        } else {
            System.err.println("Der Stuhl ist bereits belegt!");
        }
	}
	
	public Tisch[] getTische() {
		return tische;
	}
	public void setTische(Tisch...tische) {
		this.tische = tische;
	}

}
