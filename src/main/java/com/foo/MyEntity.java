package com.foo;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import dev.morphia.annotations.Indexed;

@Entity
public class MyEntity {
    public @Id Long identifier;
    @Indexed protected String myName;

    public MyEntity() {}
}
