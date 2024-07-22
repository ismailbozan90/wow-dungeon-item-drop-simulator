package com.scamlet.dungeondropsimulator.entities;

import java.util.EnumSet;
import java.util.Set;

public class Spec implements Utils {

    public enum Role {
        DPS, HEALER, TANK
    }

    private String name;
    private PrimaryStat primaryStat;
    private Set<WeaponType> weaponType;
    private Role role;
    private ArmorType armorType;

    public Spec() {
        this.weaponType = EnumSet.noneOf(WeaponType.class);
    }

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

    public Set<WeaponType> getWeaponType() {
        return weaponType;
    }

    public void addWeaponType(WeaponType weaponType) {
        this.weaponType.add(weaponType);
    }

    public void setWeaponType(Set<WeaponType> weaponType) {
        this.weaponType = weaponType;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public ArmorType getArmorType() {
        return armorType;
    }

    public void setArmorType(ArmorType armorType) {
        this.armorType = armorType;
    }
}
