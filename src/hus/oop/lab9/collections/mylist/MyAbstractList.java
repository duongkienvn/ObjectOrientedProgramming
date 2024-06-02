package hus.oop.lab9.collections.mylist;

public abstract class MyAbstractList implements MyList{
    void checkBoundaries(int index, int limit) {
        if (index < 0 || index > limit) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size(); i++) {
            stringBuilder.append(String.format("[%s]", get(i).toString()));
        }
        return stringBuilder.toString();
    }
}
