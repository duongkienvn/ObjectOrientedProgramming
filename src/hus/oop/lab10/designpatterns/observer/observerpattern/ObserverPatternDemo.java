package hus.oop.lab10.designpatterns.observer.observerpattern;

public class ObserverPatternDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();

        new BinaryObserver(subject);
        new OctalObserver(subject);
        new HexaObserver(subject);

        subject.setState(5);
        subject.setState(7);
    }
}
