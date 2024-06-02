package hus.oop.lab11.visitor.exercises.book.structure;

import hus.oop.lab11.visitor.exercises.book.visitors.Visitor;

public interface Book {
    void accep(Visitor visitor);
}
