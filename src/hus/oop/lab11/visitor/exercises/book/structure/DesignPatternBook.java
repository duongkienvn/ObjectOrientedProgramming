package hus.oop.lab11.visitor.exercises.book.structure;

import hus.oop.lab11.visitor.exercises.book.visitors.Visitor;

public class DesignPatternBook implements ProgramingBook {
    @Override
    public void accep(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getResource() {
        return "https://github.com/duongkienvn/OOP_ki_2/" +
                "tree/master/src/hus/oop/lab10/designpatterns";
    }

    public String getBestSeller() {
        return "The best seller of design pattern book!";
    }
}
