package hus.oop.lab11.visitor.exercises.book.structure;

import hus.oop.lab11.visitor.exercises.book.visitors.Visitor;

public class JavaCoreBook implements ProgramingBook {
    @Override
    public void accep(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getResource() {
        return "https://github.com/duongkienvn/OOP_ki_2/" +
                "tree/master/src/hus/oop/lab10/javacore";
    }

    public String getFavoriteBook() {
        return "The most favorite book of java core";
    }
}
