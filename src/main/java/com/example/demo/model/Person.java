package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Person {
    private final UUID Id;
    @NotBlank
    private final String Name;

    public Person(@JsonProperty("id") UUID id,
                  @JsonProperty("name") String name){
        this.Id = id;
        this.Name = name;
    }

    public UUID getId(){
        return  Id;
    }

    public  String getName(){
        return Name;
    }

}
