package com.foo;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import dev.morphia.annotations.Indexed;

@Entity
public class MyEntity {
    public @Id long id;
    @Indexed protected String myName;

    public MyEntity() {}
}
