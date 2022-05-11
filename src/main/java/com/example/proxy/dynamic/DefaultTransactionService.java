package com.example.proxy.dynamic;

public class DefaultTransactionService implements TransactionService{
    @Override
    public void getING(String data) {
        System.out.println("Transaction "+ data);
    }

    public void getEnd(String data) {
        System.out.println("끝?");
    }
}
