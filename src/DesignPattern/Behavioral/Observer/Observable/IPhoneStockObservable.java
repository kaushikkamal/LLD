package DesignPattern.Behavioral.Observer.Observable;

import DesignPattern.Behavioral.Observer.Observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IPhoneStockObservable implements StockObservable {
    private List<NotificationAlertObserver> notificationAlertObserverList;
    private int stock = 0;

    public IPhoneStockObservable() {
        this.notificationAlertObserverList = new ArrayList<>();
    }

    @Override
    public void subscribe(NotificationAlertObserver obj) {
        this.notificationAlertObserverList.add(obj);
    }

    @Override
    public void unsubscribe(NotificationAlertObserver obj) {
        this.notificationAlertObserverList.remove(obj);
    }

    @Override
    public void notifyAllSubscribers() {
        for (NotificationAlertObserver each : notificationAlertObserverList) {
            each.update();
        }
    }

    @Override
    public void setStockData(int newData) {
        if (stock == 0) {
            notifyAllSubscribers();
        }

        this.stock += newData;
    }

    @Override
    public int getStockData() {
        return this.stock;
    }
}
