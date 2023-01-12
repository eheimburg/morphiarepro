package com.foo;

@dev.morphia.annotations.Entity(value="MyEntity")
public class MyPlayer extends MyEntity {
    public MyPlayer() {
        super("WTF");
    }
}
