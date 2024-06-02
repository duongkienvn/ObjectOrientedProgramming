package hus.oop.lab11.iterator.exercise.product;

public class ProductIterator implements Iterator {
    private ProductCatalog productCatalog;
    private int index;

    public ProductIterator(ProductCatalog productCatalog) {
        this.productCatalog = productCatalog;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < productCatalog.getProductCatalog().length;
    }

    @Override
    public Object next() {
        if (this.hasNext()) {
            return productCatalog.getProductCatalog()[index++];
        }
        return null;
    }
}
