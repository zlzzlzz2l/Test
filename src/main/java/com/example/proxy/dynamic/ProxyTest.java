package com.example.proxy.dynamic;

import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        ProxyTest proxy = new ProxyTest();
        proxy.dynamicProxy();
    }

    private void dynamicProxy() {
        TransactionService transactionServiceProxy = transactionServiceProxy(new TransactionServiceImpl());
        transactionServiceProxy.startTransactionMethodOne();
        System.out.println(" -------------- ");
        transactionServiceProxy.startTransactionMethodTwo();
    }

    // 프록시 인스턴스 생성
    private TransactionService transactionServiceProxy(TransactionService target) {
        return (TransactionService) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{TransactionService.class}, (proxy, method, args) -> {
                    System.out.println("Transaction Start");
                    method.invoke(target, args);
                    System.out.println("Transaction Commit");
                    return null;
                });
    }
}
