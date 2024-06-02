package hus.oop.lab11.iterator.examples.cafe;

import java.util.List;

public class PancakeHouseMenuIterator implements Iterator {
    private List<String> items;
    private int position = 0;

    public PancakeHouseMenuIterator(List<String> items) {
        this.items = items;
    }

    @Override
    public String next() {
        String menuItem = items.get(position);
        position++;
        return menuItem;
    }

    @Override
    public boolean hasNext() {
        return position < items.size();
    }
}
