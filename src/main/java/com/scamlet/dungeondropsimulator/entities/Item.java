package com.scamlet.dungeondropsimulator.entities;

import lombok.Data;

@Data
public class Item implements Utils {

    private String name;
    private PrimaryStat primaryStat;
    private WeaponType weaponType;
    private ItemType itemType;
    private ArmorType armorType;

}
