package hus.oop.lab11.visitor.exercises.book.visitors;

import hus.oop.lab11.visitor.exercises.book.structure.BusinessBook;
import hus.oop.lab11.visitor.exercises.book.structure.DesignPatternBook;
import hus.oop.lab11.visitor.exercises.book.structure.JavaCoreBook;

public interface Visitor {
    void visit(BusinessBook book);
    void visit(DesignPatternBook book);
    void visit(JavaCoreBook book);
}
