package hus.oop.lab11.observer.observerpattern;

import hus.oop.lab10.designpatterns.observer.observerpattern.BinaryObserver;
import hus.oop.lab10.designpatterns.observer.observerpattern.HexaObserver;
import hus.oop.lab10.designpatterns.observer.observerpattern.OctalObserver;
import hus.oop.lab10.designpatterns.observer.observerpattern.Subject;

public class ObserverPatternDemo {
    public static void main(String[] args) {
        hus.oop.lab10.designpatterns.observer.observerpattern.Subject subject = new Subject();

        new BinaryObserver(subject);
        new OctalObserver(subject);
        new HexaObserver(subject);

        subject.setState(5);
        subject.setState(7);
    }
}
