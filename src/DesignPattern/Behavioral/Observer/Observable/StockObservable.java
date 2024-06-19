package DesignPattern.Behavioral.Observer.Observable;

import DesignPattern.Behavioral.Observer.Observer.NotificationAlertObserver;

public interface StockObservable {
    public void subscribe(NotificationAlertObserver obj);

    public void unsubscribe(NotificationAlertObserver obj);

    public void notifyAllSubscribers();

    public void setStockData(int newData);

    public int getStockData();
}
