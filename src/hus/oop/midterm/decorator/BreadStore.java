package hus.oop.midterm.decorator;

import java.util.*;

public class BreadStore {
    private List<Bread> breads;

    public BreadStore() {
        breads = new LinkedList<>();
    }

    /**
     * Giả sử bánh mỳ được làm không cho một loại gia vị nhiều hơn một lần.
     * Bắt đầu, tạo ra và cho vào cửa hàng:
     * 5 bánh mỳ ThickcrustBread chỉ có cheese,
     * 5 bánh mỳ ThickcrustBread chỉ có olives,
     * 5 bánh mỳ ThickcrustBread có cả cheese và olives,
     * 5 bánh mỳ ThincrustBread chỉ có cheese,
     * 5 bánh mỳ ThincrustBread chỉ có olives,
     * 5 bánh mỳ ThincrustBread có cả cheese và olives.
     */
    public void init() {
        /* TODO */
        for (int i = 0; i < 5; i++) {
            add(new Cheese(new ThickcrustBread()));
        }

        for (int i = 0; i < 5; i++) {
            add(new Olives(new ThickcrustBread()));
        }

        for (int i = 0; i < 5; i++) {
            add(new Cheese(new Olives(new ThincrustBread())));
        }

        for (int i = 0; i < 5; i++) {
            add(new Cheese(new ThincrustBread()));
        }

        for (int i = 0; i < 5; i++) {
            add(new Olives(new ThincrustBread()));
        }

        for (int i = 0; i < 5; i++) {
            add(new Cheese(new Olives(new ThincrustBread())));
        }

    }

    /**
     * Thêm bánh mỳ vào cửa hàng.
     */
    public void add(Bread bread) {
        /* TODO */
        breads.add(bread);
    }

    /**
     * Giả sử cửa hàng bán một cái bánh mỳ nào đó,
     * Bánh mỳ được lấy ra để bán là bánh mỳ đầu tiên có giá bằng giá
     * bánh mỳ yêu cầu.
     * Nếu còn bánh mỳ để bán thì trả về giá trị true,
     * nếu không còn trả về giá trị false.
     */
    public boolean sell(Bread bread) {
        /* TODO */
        for (Bread bread1 : breads) {
            if (bread1.getClass() == bread.getClass() && bread1.cost() == bread.cost()) {
                breads.remove(bread1);
                return true;
            }
        }
        return false;
    }

    /**
     * In ra những bánh mỳ còn trong cửa hàng.
     */
    public void print() {
        /* TODO */
        for (Bread bread : breads) {
            System.out.println(bread.description + " - $" + bread.cost());
        }
    }

    /**
     * Sắp xếp các bánh mỳ còn lại theo thứ tự được cho bởi order,
     * nếu order là true, sắp xếp theo thứ tự tăng dần,
     * nếu order là false, sắp xếp theo thứ tự giảm dần.
     * Việc sắp xếp không làm thay đổi thứ tự của bánh mỳ trong cửa hàng.
     */
    public List<Bread> sort(boolean order) {
        /* TODO */
        List<Bread> sortedBread = new ArrayList<>();
        sortedBread.addAll(breads);
        Collections.sort(sortedBread, new Comparator<Bread>() {
            @Override
            public int compare(Bread o1, Bread o2) {
                if (order) {
                    return Double.compare(o1.cost(), o2.cost());
                } else {
                    return Double.compare(o2.cost(), o1.cost());
                }
            }
        });

        return sortedBread;
    }

    /**
     * Lọc ra howMany cái bánh mỳ có giá cao nhất hoặc thấp nhất,
     * nếu order là true thì lọc ra bánh mỳ có giá cao nhất,
     * nếu order là false thì lọc ra bánh mỳ có giá thấp nhất.
     */
    public List<Bread> filter(int howMany, boolean order) {
        /* TODO */
        List<Bread> filter = new ArrayList<>();
        if (!order) {
            List<Bread> increasingByCost = sort(true);
            if (increasingByCost.size() <= howMany) {
                filter.addAll(increasingByCost);
                return filter;
            } else {
                for (int i = 0; i < howMany; i++) {
                    filter.add(increasingByCost.get(i));
                }
            }
        } else {
            List<Bread> decreasingByCost = sort(false);
            if (decreasingByCost.size() <= howMany) {
                filter.addAll(decreasingByCost);
                return filter;
            } else {
                for (int i = 0; i < howMany; i++) {
                    filter.add(decreasingByCost.get(i));
                }
            }
        }
        return filter;
    }

    public static void main(String args[]) {
        BreadStore breadStore = new BreadStore();
        breadStore.init();

        /*
         * Sau khi khởi tạo số bánh mỳ cho cửa hàng, viết chương trình demo:
         * - Thêm một số bánh mỳ vào cửa hàng
         * - Bán một số bánh mỳ từ cửa hàng
         * - In ra số bánh mỳ còn lại theo thứ tự giá tăng dần.
         * - In ra nhiều nhất 10 cái bánh mỳ có giá thấp nhất còn trong cửa hàng.
         */
        /* TODO */

        breadStore.add(new Olives(new ThincrustBread()));
        breadStore.add(new Cheese(new ThincrustBread()));
        breadStore.add(new Cheese(new ThickcrustBread()));

        // selling
        breadStore.sell(new Cheese(new ThickcrustBread()));
        breadStore.sell(new Olives(new ThincrustBread()));

        System.out.println("increasing by cost");
        List<Bread> increasingByCost = breadStore.sort(true);
        for (Bread bread : increasingByCost) {
            System.out.println(bread.description + " - $" + bread.cost());
        }

        System.out.println("\n10 cheapest breads:");
        List<Bread> cheapestBreads = breadStore.filter(10, false);
        for (Bread bread : cheapestBreads) {
            System.out.println(bread.description + " - $" + bread.cost());
        }
    }
}
