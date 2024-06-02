package hus.oop.lab10.designpatterns.strategy.order;

import hus.oop.lab10.designpatterns.strategy.strategies.PayByCreditCard;
import hus.oop.lab10.designpatterns.strategy.strategies.PayByPaypal;

public class Order {
    private int totalCost = 0;
    private boolean isClosed = false;

    public void processOrderUsingPaypal(PayByPaypal payPaypal) {
        payPaypal.collectPaymentDetails();
    }

    public void processOrderUsingCreditCard(PayByCreditCard creditCard) {
        creditCard.collectPaymentDetails();
    }

    public void setTotalCost(int cost) {
        this.totalCost += cost;
    }

    public int getTotalCost() {
        return this.totalCost;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed() {
        isClosed = true;
    }
}
