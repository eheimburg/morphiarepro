package com.foo;

import org.apache.log4j.Logger;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.PrePersist;

@Entity(value="MyEntity")
public class MyPlayer extends MyEntity {
    public MyPlayer() {
        super();
    }

    @PrePersist
    private void onPrePersist() {
        Logger.getLogger(getClass()).warn("PrePersist of MyPlayer: " + this.identifier);
        if (this.identifier == null)
            this.identifier = 5L;
    }
}
