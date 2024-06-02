package hus.oop.lab11.visitor.exercises.book.structure;

import hus.oop.lab11.visitor.exercises.book.visitors.Visitor;

public class BusinessBook implements Book {
    @Override
    public void accep(Visitor visitor) {
        visitor.visit(this);
    }

    public String getPublisher() {
        return "The publisher of business book!";
    }
}
