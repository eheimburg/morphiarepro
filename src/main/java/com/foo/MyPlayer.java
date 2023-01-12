package com.foo;

import dev.morphia.annotations.Entity;

@Entity(value="MyEntity")
public class MyPlayer extends MyEntity {
    public MyPlayer() {
        super();
    }
}
