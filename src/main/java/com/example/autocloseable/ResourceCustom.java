package com.example.autocloseable;

public class ResourceCustom implements AutoCloseable {

    public void doing() {
        System.out.println("doing!");
    }

    @Override
    public void close() throws Exception {
        System.out.println("done!");
    }
}
