package com.scamlet.dungeondropsimulator.entities;

import java.util.Set;

public interface Utils {

    enum PrimaryStat {
        NONE, STRENGTH, INTELLIGENCE, AGILITY, ALL
    }

    enum WeaponType {
        NONE, AXE_1H, AXE_2H, BOW, CROSSBOW, DAGGER, FIST, GUN, MACE_1H, MACE_2H, POLEARM, STAFF, SWORD_1H, SWORD_2H, OFF_HAND, SHIELD, WARGLAIVES;

        public static boolean checkWeaponType(Set<WeaponType> weaponTypeSet, Utils.WeaponType targetWeaponType) {
            return weaponTypeSet.stream()
                    .anyMatch(weaponType -> weaponType == targetWeaponType);
        }
    }

    enum ArmorType {
        NONE, PLATE, CLOTH, MAIL, LEATHER, JEWELRY;

        public static boolean checkArmorType(Utils.ArmorType armorType, Utils.ArmorType targetArmorType) {
            return armorType == targetArmorType;
        }
    }

    enum ItemType {
        NONE, HEAD, NECK, SHOULDER, BACK, CHEST, WRIST, HAND, WAIST, LEGS, FOOT, RING, TRINKET, MAIN_HAND, OFF_HAND
    }


}
