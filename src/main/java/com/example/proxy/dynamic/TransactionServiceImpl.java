package com.example.proxy.dynamic;

public class TransactionServiceImpl implements TransactionService {

    @Override
    public void startTransactionMethodOne() {
        System.out.println("Transaction Active 1");
    }

    @Override
    public void startTransactionMethodTwo() {
        System.out.println("Transaction Active 2");
    }

}
