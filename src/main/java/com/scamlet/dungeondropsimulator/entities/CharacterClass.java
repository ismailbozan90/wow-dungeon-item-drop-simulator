package com.scamlet.dungeondropsimulator.entities;

import lombok.Data;
import java.util.HashSet;
import java.util.Set;

@Data
public class CharacterClass implements Utils {

    private String name;
    private Set<Spec> spec;

    public CharacterClass() {
        this.spec = new HashSet<>();
    }

    public void addSpec(Spec spec) {
        this.spec.add(spec);
    }
}
