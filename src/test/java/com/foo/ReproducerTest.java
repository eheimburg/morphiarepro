package com.foo;

import com.antwerkz.bottlerocket.BottleRocket;
import com.antwerkz.bottlerocket.BottleRocketTest;
import com.github.zafarkhaja.semver.Version;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoClient;

import dev.morphia.Datastore;
import dev.morphia.Morphia;
import dev.morphia.query.experimental.filters.Filters;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.Test;


public class ReproducerTest extends BottleRocketTest {
    private Datastore datastore;

    public ReproducerTest() {
        MongoClient mongo = getMongoClient();
        MongoDatabase database = getDatabase();
        database.drop();
        datastore = Morphia.createDatastore(mongo, getDatabase().getName());
        
        datastore.getMapper().map(MyEntity.class, MyPlayer.class);
    }

    @NotNull
    @Override
    public String databaseName() {
        return "morphia_repro";
    }

    @Nullable
    @Override
    public Version version() {
        return BottleRocket.DEFAULT_VERSION;
    }

    @Test
    public void reproduce() {
        MyPlayer p = new MyPlayer();
        p.id = 1;
        p.myName = "Bob";
        datastore.save(p);

        MyEntity pp = datastore.find(MyEntity.class).filter(Filters.eq("myName", "Bob")).first();
        assertNotNull(pp);
        assertTrue(pp.myName.equals("Bob"));
    }

}
