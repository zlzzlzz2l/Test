package com.example.functional.supplier;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Supplier<Double> display = () -> Math.random();

        System.out.println(display.get());
    }
}
