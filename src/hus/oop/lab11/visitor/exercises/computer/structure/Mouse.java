package hus.oop.lab11.visitor.exercises.computer.structure;

import hus.oop.lab11.visitor.exercises.computer.visitors.ComputerPartVisitor;

public class Mouse implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor visitor) {
        visitor.visit(this);
    }
}
