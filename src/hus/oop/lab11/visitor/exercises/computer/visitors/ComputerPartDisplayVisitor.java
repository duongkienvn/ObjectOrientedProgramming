package hus.oop.lab11.visitor.exercises.computer.visitors;

import hus.oop.lab11.visitor.exercises.computer.structure.Computer;
import hus.oop.lab11.visitor.exercises.computer.structure.Keyboard;
import hus.oop.lab11.visitor.exercises.computer.structure.Monitor;
import hus.oop.lab11.visitor.exercises.computer.structure.Mouse;

public class ComputerPartDisplayVisitor implements ComputerPartVisitor {
    @Override
    public void visit(Mouse mouse) {
        System.out.println("Displaying Mouse.");
    }

    @Override
    public void visit(Monitor monitor) {
        System.out.println("Displaying Monitor.");
    }

    @Override
    public void visit(Computer computer) {
        System.out.println("Displaying Computer.");
    }

    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("Displaying Keyboard.");
    }
}
