package hus.oop.lab11.visitor.exercises.computer.visitors;

import hus.oop.lab11.visitor.exercises.computer.structure.*;

public class VisitorPatternDemo {
    public static void main(String[] args) {
        ComputerPart computer = new Computer();
        ComputerPart keyBoard = new Keyboard();
        ComputerPart monitor = new Monitor();
        ComputerPart mouse = new Mouse();

        ComputerPartVisitor visitor = new ComputerPartDisplayVisitor();
        computer.accept(visitor);
        System.out.println("------");
        keyBoard.accept(visitor);
        monitor.accept(visitor);
        mouse.accept(visitor);
    }
}
