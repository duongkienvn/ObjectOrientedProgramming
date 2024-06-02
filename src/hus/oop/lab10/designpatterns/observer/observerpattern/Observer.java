package hus.oop.lab10.designpatterns.observer.observerpattern;

public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
