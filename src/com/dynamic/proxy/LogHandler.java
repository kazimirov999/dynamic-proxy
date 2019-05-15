package com.dynamic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LogHandler implements InvocationHandler {

    private final Object target;
    private final Map<String, Method> methods = new HashMap<>();

    public LogHandler(Object target) {
        this.target = target;
        for (Method method : target.getClass().getDeclaredMethods()) {
            this.methods.put(method.getName(), method);
        }
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime = System.currentTimeMillis();
        System.out.println(startTime + " - Start: method - " + method.getName() + " with args: " + Arrays.toString(args));

        Object o = methods.get(method.getName()).invoke(target, args);

        System.out.println("Consume - " + (System.currentTimeMillis() - startTime) + " - Finish: method - " + method.getName() + " with args: " + Arrays.toString(args));
        return o;

    }
}
