package hus.oop.lab11.visitor.exercises.computer.structure;

import hus.oop.lab11.visitor.exercises.computer.visitors.ComputerPartVisitor;

public interface ComputerPart {
    void accept(ComputerPartVisitor visitor);
}
