package com.scamlet.dungeondropsimulator.entities;

import java.util.HashSet;
import java.util.Set;

public class CharacterClass implements Utils  {

    private String name;
    private Set<Spec> spec;

    public CharacterClass() {
        this.spec = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Spec> getSpec() {
        return spec;
    }

    public void setSpec(Set<Spec> spec) {
        this.spec = spec;
    }

    public void addSpec(Spec spec) {
        this.spec.add(spec);
    }
}
