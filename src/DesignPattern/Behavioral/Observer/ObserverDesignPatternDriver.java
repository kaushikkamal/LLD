package DesignPattern.Behavioral.Observer;

import DesignPattern.Behavioral.Observer.Observable.IPhoneStockObservable;
import DesignPattern.Behavioral.Observer.Observable.StockObservable;
import DesignPattern.Behavioral.Observer.Observer.EmailNotificationAlertObserver;
import DesignPattern.Behavioral.Observer.Observer.NotificationAlertObserver;

public class ObserverDesignPatternDriver {
    public static void executeObserverPattern() {
        StockObservable iPhoneStockObservable = new IPhoneStockObservable();

        NotificationAlertObserver observer1 = new EmailNotificationAlertObserver("kk@kk.com", iPhoneStockObservable);
        NotificationAlertObserver observer2 = new EmailNotificationAlertObserver("kaushik@kaushik.com", iPhoneStockObservable);

        iPhoneStockObservable.subscribe(observer1);
        iPhoneStockObservable.subscribe(observer2);

        iPhoneStockObservable.setStockData(10);
    }
}
