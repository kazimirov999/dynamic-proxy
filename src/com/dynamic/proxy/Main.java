package com.dynamic.proxy;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        LogHandler logHandler = new LogHandler(new HashMap<>());
        Map<Integer, String> map = (Map) Proxy.newProxyInstance(Map.class.getClassLoader(), new Class[]{Map.class}, logHandler);

        IntStream.range(0, 1).forEach(key -> System.out.println(map.put(key, "value-" + key).toString()));


//        System.out.println(map.get(0));
    }
}
