package hus.oop.midterm.iterator;

import java.util.ArrayList;

public class MyListIterator implements Iterator {
	private ArrayList<String> items;
	private int position;
 
	public MyListIterator(ArrayList<String> items) {
		this.items = items;
		this.position = 0;
	}
 
	public String next() {
		/* TODO */
		String item = items.get(position);
		position++;
		return item;
	}
 
	public boolean hasNext() {
		/* TODO */
		return position < items.size();
	}
}
