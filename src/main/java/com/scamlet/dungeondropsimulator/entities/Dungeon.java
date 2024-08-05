package com.scamlet.dungeondropsimulator.entities;

import lombok.Data;
import java.util.List;

@Data
public class Dungeon {

    private String name;
    private List<Item> itemDropPool;

}
