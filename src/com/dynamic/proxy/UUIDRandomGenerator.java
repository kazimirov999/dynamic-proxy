package com.dynamic.proxy;

import java.util.UUID;

public class UUIDRandomGenerator implements IRandomGenerator {

    @Override
    public UUID generate() {
        return UUID.randomUUID();
    }
}
