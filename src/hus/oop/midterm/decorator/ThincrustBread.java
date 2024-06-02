package hus.oop.midterm.decorator;

public class ThincrustBread extends Bread {
  
	public ThincrustBread() {
		description = "Thin crust bread, with tomato sauce";
	}
  
	public double cost() {
		return 20.0;
	}
}
