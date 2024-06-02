package hus.oop.lab9.library;

public class Library {
    Rent rents[];

    public Library(Rent[] rents) {
        this.rents = rents;
    }

    public Rent getLongestRent() {
        long longestRent = Long.MAX_VALUE;
        for (int i = 0; i < rents.length; i++) {
            long time = rents[i].end.getTime() - rents[i].begin.getTime();
            if (longestRent < time) {
                longestRent = time;
            }
        }

        for (int i = 0; i < rents.length; i++) {
            long time = rents[i].end.getTime() - rents[i].begin.getTime();
            if (longestRent == time) {
                return rents[i];
            }
        }

        return rents[0];
    }
}
