package hus.oop.lab11.iterator.exercise.product;

public class IteratorExamplePattern {
    public static void main(String[] args) {
        String products[] = {"Product A", "Product B", "Product C", "Product D"};
        ProductCatalog productCatalog = new ProductCatalog(products);
        Iterator iterator = productCatalog.getIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
