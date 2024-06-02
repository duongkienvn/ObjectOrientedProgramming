package hus.oop.lab11.observer.observerpattern;

import hus.oop.lab10.designpatterns.observer.observerpattern.Subject;

public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
