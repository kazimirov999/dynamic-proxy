package com.dynamic.proxy;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        LogHandler logHandler = new LogHandler(new HashMap<>());
        Map<Integer, String> map = (Map) Proxy.newProxyInstance(logHandler.getClass().getClassLoader(),
                new Class[]{Map.class},
                logHandler);
        System.out.println("put---" + map.put(0, "value-0")); //null
        System.out.println("put---" + map.put(0, "value-01")); //value-0
        System.out.println("get---" + map.get(0));            // value-0

    }
}
