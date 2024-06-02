package hus.oop.lab11.iterator.examples.cafe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PancakeHouseMenu implements Menu {
    private List<String> menuItems;

    public PancakeHouseMenu() {
        menuItems = new ArrayList<>();

        addItem("K&B’s Pancake Breakfast");
        addItem("Regular Pancake Breakfast");
        addItem("Blueberry Pancakes");
        addItem("Waffles");
    }

    public void addItem(String item) {
        menuItems.add(item);
    }

    public List<String> getMenuItems() {
        return menuItems;
    }

    @Override
    public Iterator createIterator() {
        return new PancakeHouseMenuIterator(menuItems);
    }

    @Override
    public String toString() {
        return "Pancake House Menu";
    }
}
