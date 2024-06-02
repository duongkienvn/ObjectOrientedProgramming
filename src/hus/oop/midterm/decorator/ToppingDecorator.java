package hus.oop.midterm.decorator;

public abstract class ToppingDecorator extends Bread {
	Bread bread;

	public abstract String getDescription();
}
