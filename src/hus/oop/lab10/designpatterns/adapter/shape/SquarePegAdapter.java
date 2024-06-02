package hus.oop.lab10.designpatterns.adapter.shape;

public class SquarePegAdapter extends RoundPeg {
    private SquarePeg peg;

    public SquarePegAdapter(SquarePeg peg) {
        super(0);
        this.peg = peg;
    }

    @Override
    public int getRadius() {
        return peg.getWidth() * (int) Math.sqrt(2) / 2;
    }

}
