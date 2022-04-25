package com.example.lambda;

public class Main {
    public static void main(String[] args) {
        action(() -> System.out.println("lambda expression"));
    }

    public static void action(Custom custom) {
        custom.print();
    }
}
