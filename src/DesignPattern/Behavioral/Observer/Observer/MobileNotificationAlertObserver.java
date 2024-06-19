package DesignPattern.Behavioral.Observer.Observer;

import DesignPattern.Behavioral.Observer.Observable.StockObservable;

public class MobileNotificationAlertObserver implements NotificationAlertObserver {
    String userName;
    StockObservable stockObservable;

    public MobileNotificationAlertObserver(String userName, StockObservable stockObservable) {
        this.userName = userName;
        this.stockObservable = stockObservable;
    }

    @Override
    public void update() {
        sendMessageOnMobile(userName, "Product is in stock, hurry up!");
    }

    public void sendMessageOnMobile(String userName, String msg) {
        System.out.println("Message sent to " + userName + " with message " + msg);
    }
}
