package com.scamlet.dungeondropsimulator.entities;

import lombok.Data;
import java.util.EnumSet;
import java.util.Set;

@Data
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

    public void addWeaponType(WeaponType weaponType) {
        this.weaponType.add(weaponType);
    }


}
