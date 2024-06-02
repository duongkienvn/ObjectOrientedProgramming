package hus.oop.lab11.visitor.exercises.book.visitors;

import hus.oop.lab11.visitor.exercises.book.structure.Book;
import hus.oop.lab11.visitor.exercises.book.structure.BusinessBook;
import hus.oop.lab11.visitor.exercises.book.structure.DesignPatternBook;
import hus.oop.lab11.visitor.exercises.book.structure.JavaCoreBook;

public class VisitorPatternExample {
    public static void main(String[] args) {
        Book designPattern = new DesignPatternBook();
        Book business = new BusinessBook();
        Book javaCore = new JavaCoreBook();

        Visitor visitor = new VisitorImpl();
        designPattern.accep(visitor);
        business.accep(visitor);
        javaCore.accep(visitor);
    }
}
