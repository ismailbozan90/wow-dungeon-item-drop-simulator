package com.scamlet.dungeondropsimulator.entities;

import java.util.List;

public class Dungeon {

    private String name;
    private List<Item> itemDropPool;

    public Dungeon(String name, List<Item> itemDropPool) {
        this.name = name;
        this.itemDropPool = itemDropPool;
    }

    public Dungeon() {};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItemDropPool() {
        return itemDropPool;
    }

    public void setItemDropPool(List<Item> itemDropPool) {
        this.itemDropPool = itemDropPool;
    }
}
