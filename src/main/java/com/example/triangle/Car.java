package com.example.triangle;

public class Car {
    Tire tire;

    public Car() {
        tire = new KoreaTire(); // 의존 관계 발생
        //tire = new AmericaTire();
    }

    public String getTireBrand() {
        return "장착된 타이어: " + tire.getBrand();
    }
}
