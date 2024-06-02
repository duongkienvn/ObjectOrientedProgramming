package hus.oop.lab4.composition.authorandbookadvanced;

public class Book {
    private String name;
    private Author[] author;
    private double price;
    private int qty;

    public Book(String name, Author[] author, double price){
        this.name = name;
        this.author = author;
        this.price = price;
    }
    public Book(String name, Author[] author, double price, int qty){
        this.name = name;
        this.author = author;
        this.price = price;
        this.qty = qty;
    }
    public String getName(){
        return name;
    }
    public Author[] getAuthor(){
        return author;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public int getQty(){
        return qty;
    }
    public void setQty(int qty){
        this.qty = qty;
    }
    public String toString(){
        String s = "";
        for(int i = 0; i < author.length; i++) {
            s += author[i].toString();
            if(i != author.length - 1){
                s += ",";
            }
        }
        return "Book[name=" + name + ",author={" + s + "},price=" + price + ",qty=" + qty + "]";
    }

    public String getAuthorNames(){
        String s = "";
        for(int i = 0; i < author.length; i++) {
            s += author[i].toString();
            if(i != author.length - 1){
                s += ",";
            }
        }
        return s;
    }
}
