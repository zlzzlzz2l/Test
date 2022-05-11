package com.example.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        test.dynamicProxy();
    }

    private void dynamicProxy() {
        TransactionService transactionServiceProxy = transactionServiceProxy(new DefaultTransactionService());
        transactionServiceProxy.getING(null);
        transactionServiceProxy.getEnd(null);
    }

    // 프록시 인스턴스 생성
   private TransactionService transactionServiceProxy(TransactionService target) {
        // 첫번째 파라미터 클래스 로더, 동적으로 생성된 프록시가 구현해야 하는 인터페이스 타입, invocationHandler 타입의 인스턴스 (invoke method 구현)
        return (TransactionService) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{TransactionService.class}, (proxy, method, args) -> {
                    System.out.println("Transaction Start");
                    method.invoke(target, "ING"); // 타겟에 있는 메서드 실행,
                    System.out.println("Transaction Commit");
                    return null;
                });
    }
}
