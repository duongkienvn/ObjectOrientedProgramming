package hus.oop.lab11.visitor.exercises.book.visitors;

import hus.oop.lab11.visitor.exercises.book.structure.BusinessBook;
import hus.oop.lab11.visitor.exercises.book.structure.DesignPatternBook;
import hus.oop.lab11.visitor.exercises.book.structure.JavaCoreBook;

public class VisitorImpl implements Visitor {
    @Override
    public void visit(BusinessBook book) {
        System.out.println(book.getPublisher());
    }

    @Override
    public void visit(JavaCoreBook book) {
        System.out.println(book.getFavoriteBook());
    }

    @Override
    public void visit(DesignPatternBook book) {
        System.out.println(book.getBestSeller());
    }
}
