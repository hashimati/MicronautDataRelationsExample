package io.hashimati.databaseexamples;

import java.util.Arrays;

import javax.inject.Inject;

import io.hashimati.databaseexamples.domains.Address;
import io.hashimati.databaseexamples.domains.Person;
import io.micronaut.context.event.StartupEvent;
import io.micronaut.runtime.Micronaut;
import io.micronaut.runtime.event.annotation.EventListener;

public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class);
    }

    
}