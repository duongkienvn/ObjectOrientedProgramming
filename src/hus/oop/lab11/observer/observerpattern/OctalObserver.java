package hus.oop.lab11.observer.observerpattern;

import hus.oop.lab10.designpatterns.observer.observerpattern.Observer;
import hus.oop.lab10.designpatterns.observer.observerpattern.Subject;

public class OctalObserver extends Observer {
    public OctalObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }
    @Override
    public void update() {
        System.out.println(subject.getState());
    }
}
