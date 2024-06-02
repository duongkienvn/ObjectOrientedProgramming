package hus.oop.midterm.iterator;

public class MyArray implements MyIterable {
	private static final int MAX_ITEMS = 6;
	private int numberOfItems;
	private String[] menuItems;
  
	public MyArray() {
		numberOfItems = 0;
		menuItems = new String[MAX_ITEMS];
	}
  
	public void addItem(String name) {
		/* TODO */
		if (numberOfItems < MAX_ITEMS) {
			menuItems[numberOfItems] = name;
			numberOfItems++;
		} else {
			System.out.println("the menu is full!");
		}
	}
 
	public String[] getMenuItems() {
		/* TODO */
		return menuItems;
	}
  
	public Iterator createIterator() {
		/* TODO */
		return new MyArrayIterator(menuItems);
	}
 
	public String toString() {
		return "My Array Structure";
	}
}
