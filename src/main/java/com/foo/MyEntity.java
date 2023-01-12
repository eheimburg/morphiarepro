package com.foo;

import com.mongodb.WriteConcern;

import dev.morphia.annotations.Id;
import dev.morphia.annotations.Indexed;

@dev.morphia.annotations.Entity
public class MyEntity {
    public @Id long id;
    @Indexed protected String myName;

    protected MyEntity(String name) {
        myName = name;
    }

    public void setName(String name) {
        myName = name;
    }

    public String getName() {
        return myName;
    }

}
