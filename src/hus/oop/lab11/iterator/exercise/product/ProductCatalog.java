package hus.oop.lab11.iterator.exercise.product;

public class ProductCatalog implements Iterable {
    private String[] productCatalog;

    public ProductCatalog(String[] productCatalog) {
        this.productCatalog = productCatalog;
    }

    public String[] getProductCatalog() {
        return productCatalog;
    }

    @Override
    public Iterator getIterator() {
        return new ProductIterator(this);
    }
}
