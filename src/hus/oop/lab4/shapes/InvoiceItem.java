package hus.oop.lab4.shapes;

public class InvoiceItem {
    private String id;
    private String desc;
    private int qty;
    private double unitPrice;

    public InvoiceItem(String id, String desc, int qty, double unitPrice){
        this.id = id;
        this.desc = desc;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getDesc() {
        return desc;
    }

    public String getId() {
        return id;
    }

    public double getTotal(){
        return unitPrice * qty;
    }

    public String toString(){
        return "InvoiceItem[id=" + id + ", desc=" + desc
                + ", qty=" + qty + ", unitPrice=" + unitPrice + "]";
    }

}
