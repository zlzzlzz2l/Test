package com.example.autocloseable;

public class Main {
    public static void main(String[] args) {
        try (ResourceCustom resourceCustom = new ResourceCustom()) {
            resourceCustom.doing();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
