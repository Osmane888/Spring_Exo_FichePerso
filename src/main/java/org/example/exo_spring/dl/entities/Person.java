package org.example.exo_spring.dl.entities;

import lombok.*;

import java.util.ArrayList;
import java.util.List;


@ToString
@EqualsAndHashCode
public class Person {

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String firstname;

    @Getter
    private List<Contacts> contacts;
    @Getter
    private List<Skills> skills;

    public Person(){
        contacts = new ArrayList<>();
        skills = new ArrayList<>();
    }

    public Person(String nom, String prenom) {
        this();
        this.name = nom;
        this.firstname = prenom;
    }
}
