package hus.oop.lab11.visitor.exercises.computer.visitors;

import hus.oop.lab11.visitor.exercises.computer.structure.Computer;
import hus.oop.lab11.visitor.exercises.computer.structure.Keyboard;
import hus.oop.lab11.visitor.exercises.computer.structure.Monitor;
import hus.oop.lab11.visitor.exercises.computer.structure.Mouse;

public interface ComputerPartVisitor {
    void visit(Computer computer);
    void visit(Keyboard keyboard);
    void visit(Monitor monitor);
    void visit(Mouse mouse);
}
