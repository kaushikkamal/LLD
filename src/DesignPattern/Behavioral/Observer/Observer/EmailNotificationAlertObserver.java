package DesignPattern.Behavioral.Observer.Observer;

import DesignPattern.Behavioral.Observer.Observable.StockObservable;

public class EmailNotificationAlertObserver implements NotificationAlertObserver {
    String emailId;
    StockObservable stockObservable;

    public EmailNotificationAlertObserver(String emailId, StockObservable stockObservable) {
        this.emailId = emailId;
        this.stockObservable = stockObservable;
    }

    @Override
    public void update() {
        sendEmail(emailId, "Product is in stock, hurry up!");
    }

    public void sendEmail(String email, String msg) {
        System.out.println("Mail sent to " + email + " with message " + msg);
    }
}
