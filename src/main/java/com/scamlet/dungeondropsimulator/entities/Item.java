package com.scamlet.dungeondropsimulator.entities;

public class Item implements Utils {

    private String name;
    private PrimaryStat primaryStat;
    private WeaponType weaponType;
    private ItemType itemType;
    private ArmorType armorType;

    public Item () {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PrimaryStat getPrimaryStat() {
        return primaryStat;
    }

    public void setPrimaryStat(PrimaryStat primaryStat) {
        this.primaryStat = primaryStat;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public ArmorType getArmorType() {
        return armorType;
    }

    public void setArmorType(ArmorType armorType) {
        this.armorType = armorType;
    }
}
