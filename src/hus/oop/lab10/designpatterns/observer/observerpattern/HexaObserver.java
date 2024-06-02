package hus.oop.lab10.designpatterns.observer.observerpattern;

public class HexaObserver extends Observer {
    public HexaObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }
    @Override
    public void update() {
        System.out.println(subject.getState());
    }
}
