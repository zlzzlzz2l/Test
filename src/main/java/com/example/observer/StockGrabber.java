package com.example.observer;

import java.util.ArrayList;

public class StockGrabber implements Subject{

    // 옵저버 리스트 생성
    private ArrayList<Observer> observers;
    // 가격을 나타낼 변수 선언
    private double ibmPrice;
    private double applPrice;
    private double googPrice;

    // StockGrabber의 생성자에 옵저버 리스트 초기화
    public StockGrabber() {
        observers = new ArrayList<>();
    }

    @Override
    public void register(Observer newObserver) {
        observers.add(newObserver);
    }

    @Override
    public void unregister(Observer deleteObserver) {
        int observerIndex = observers.indexOf(deleteObserver);

        System.out.println("Observer = " + (observerIndex + 1) + "deleted");

        observers.remove(observerIndex);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(ibmPrice, applPrice, googPrice);
        }
    }

    public void setIbmPrice(double newIBMPrice) {
        this.ibmPrice = newIBMPrice;
        notifyObserver();
    }

    public void setApplPrice(double newApplPrice) {
        this.applPrice = newApplPrice;
        notifyObserver();
    }

    public void setGoogPrice(double newGoogPrice) {
        this.googPrice = newGoogPrice;
        notifyObserver();
    }
}
