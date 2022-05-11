package com.example.proxy.dynamic2;

import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        ProxyService proxyService = (ProxyService) Proxy.newProxyInstance(
                ProxyTest.class.getClassLoader(),
                new Class[] {ProxyService.class},
                new DynamicInvocationHandler(new ProxyServiceImpl())
        );

        proxyService.getStart();
    }
}
