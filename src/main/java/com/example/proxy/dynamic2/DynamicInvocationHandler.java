package com.example.proxy.dynamic2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class DynamicInvocationHandler implements InvocationHandler {

    private final Map<String, Method> methods = new HashMap<>();
    private final Object target;

    public DynamicInvocationHandler(final Object target) {
        this.target = target;
        for (Method method : target.getClass().getDeclaredMethods()) {
            this.methods.put(method.getName(), method); // 메서드를 실행할 때 invoke 발생
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Transaction Start");
        methods.get(method.getName()).invoke(target, args);
        System.out.println("Transaction commit");
        return null;
    }
}
