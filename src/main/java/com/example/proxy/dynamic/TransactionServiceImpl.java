package com.example.proxy.dynamic;

public class TransactionServiceImpl implements TransactionService{

    @Override
    public boolean startTransactionMethodOne() {
        System.out.println("Transaction Active 1");
        return true;
    }

    @Override
    public boolean startTransactionMethodTwo() {
        System.out.println("Transaction Active 2");
        return false;
    }

}
