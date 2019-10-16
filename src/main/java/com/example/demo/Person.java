package com.example.demo;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long personId;
    private String name;
    private int age;
    private String petPreference;
    private String description;

    @OneToMany (mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Pet>pets;

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPetPreference() {
        return petPreference;
    }

    public void setPetPreference(String petPreference) {
        this.petPreference = petPreference;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}
