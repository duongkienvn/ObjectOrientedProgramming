package hus.oop.lab11.visitor.example.vistors;

import hus.oop.lab11.visitor.example.structure.OperaMailClient;
import hus.oop.lab11.visitor.example.structure.SquirrelMailClient;
import hus.oop.lab11.visitor.example.structure.ZimbraMailClient;

public interface MailClientVisitor {
    void visit(OperaMailClient mailClient);
    void visit(SquirrelMailClient mailClient);
    void visit(ZimbraMailClient mailClient);
}
