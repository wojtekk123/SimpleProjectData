package com.myWBexample.SimpleProjectData.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

/**
 * Created by wojtek on 30.08.2019.
 */
public class Person {

    private final String name;
    private final UUID id;

    public Person(@JsonProperty("name") String name,
                  @JsonProperty ("id") UUID id) {
        this.name = name;
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }


}
