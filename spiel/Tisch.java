package spiel;

public class Tisch {
	
	public Laenderkarte land;
    public Stuhl[] stuhl;
    
    public String toString() {
		return "Tisch [land=" + land + ", stuhl=" + stuhl + "]";
	}
    
	public Laenderkarte getLand() {
		return land;
	}
	public void setLand(Laenderkarte land) {
		this.land = land;
	}
	public Stuhl[] getStuehle() {
		return stuhl;
	}
	public void setStuehle(Stuhl... stuhl) {
		this.stuhl = stuhl;
	}

}
