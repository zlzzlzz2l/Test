package com.example.observer;

public class GrabStocks {
    public static void main(String[] args) {
        StockGrabber stockGrabber = new StockGrabber();

        StockObserver observer1 = new StockObserver(stockGrabber);

        stockGrabber.setIbmPrice(197.00);
        stockGrabber.setApplPrice(677.60);
        stockGrabber.setGoogPrice(295.10);

        StockObserver observer2 = new StockObserver(stockGrabber);

        stockGrabber.setIbmPrice(197.00);
        stockGrabber.setApplPrice(677.60);
        stockGrabber.setGoogPrice(295.10);

        stockGrabber.unregister(observer1);
    }
}
