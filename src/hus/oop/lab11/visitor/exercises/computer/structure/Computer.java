package hus.oop.lab11.visitor.exercises.computer.structure;

import hus.oop.lab11.visitor.exercises.computer.visitors.ComputerPartVisitor;

public class Computer implements ComputerPart {
    private ComputerPart parts[];

    public Computer() {
        parts = new ComputerPart[]{new Keyboard(), new Monitor(), new Mouse()};
    }

    @Override
    public void accept(ComputerPartVisitor visitor) {
        for (ComputerPart part : parts) {
            part.accept(visitor);
        }
        visitor.visit(this);
    }
}
