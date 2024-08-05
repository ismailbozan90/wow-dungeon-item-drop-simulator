package com.scamlet.dungeondropsimulator.services;

import com.scamlet.dungeondropsimulator.entities.Dungeon;
import com.scamlet.dungeondropsimulator.entities.Item;
import com.scamlet.dungeondropsimulator.entities.Spec;
import com.scamlet.dungeondropsimulator.entities.Utils;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DungeonService {


    private final List<Dungeon> dungeonData;

    public DungeonService(List<Dungeon> dungeonData) {
        this.dungeonData = dungeonData;
    }

    @PostConstruct
    public void init() {
        initRubyLifePools();
    }

    public void initRubyLifePools() {

        Dungeon ruby = new Dungeon();
        ruby.setName("Ruby Life Pools");

        List<Item> itemDropList = new ArrayList<>();

        Item i1 = new Item();
        i1.setName("Chillworn's Infusion Staff");
        i1.setItemType(Utils.ItemType.MAIN_HAND);
        i1.setPrimaryStat(Utils.PrimaryStat.INTELLIGENCE);
        i1.setWeaponType(Utils.WeaponType.STAFF);
        i1.setArmorType(Utils.ArmorType.NONE);
        itemDropList.add(i1);

        Item i2 = new Item();
        i2.setName("Blazebinder's Hoof");
        i2.setItemType(Utils.ItemType.TRINKET);
        i2.setPrimaryStat(Utils.PrimaryStat.ALL);
        i2.setWeaponType(Utils.WeaponType.NONE);
        i2.setArmorType(Utils.ArmorType.NONE);
        itemDropList.add(i2);

        Item i3 = new Item();
        i3.setName("Fireproof Drape");
        i3.setItemType(Utils.ItemType.BACK);
        i3.setPrimaryStat(Utils.PrimaryStat.ALL);
        i3.setWeaponType(Utils.WeaponType.NONE);
        i3.setArmorType(Utils.ArmorType.NONE);
        itemDropList.add(i3);

        Item i4 = new Item();
        i4.setName("Breastplate of Soaring Terror");
        i4.setItemType(Utils.ItemType.CHEST);
        i4.setPrimaryStat(Utils.PrimaryStat.STRENGTH);
        i4.setWeaponType(Utils.WeaponType.NONE);
        i4.setArmorType(Utils.ArmorType.PLATE);
        itemDropList.add(i4);

        Item i5 = new Item();
        i5.setName("Backdraft Cleaver");
        i5.setItemType(Utils.ItemType.MAIN_HAND);
        i5.setPrimaryStat(Utils.PrimaryStat.STRENGTH);
        i5.setWeaponType(Utils.WeaponType.AXE_2H);
        i5.setArmorType(Utils.ArmorType.NONE);
        itemDropList.add(i5);

        Item i6 = new Item();
        i6.setName("Blazebound Lieutenant's Helm");
        i6.setItemType(Utils.ItemType.HEAD);
        i6.setPrimaryStat(Utils.PrimaryStat.AGILITY);
        i6.setWeaponType(Utils.WeaponType.NONE);
        i6.setArmorType(Utils.ArmorType.MAIL);
        itemDropList.add(i6);

        ruby.setItemDropPool(itemDropList);

        dungeonData.add(ruby);

    }

    public List<List<Item>> getDropListAll() {
        return Collections.singletonList(dungeonData.stream()
                .map(Dungeon::getItemDropPool)
                .findFirst()
                .orElse(null));

    }

    public List<Item> getDropList(String name) {
        return dungeonData.stream()
                .filter(dungeon -> dungeon.getName().equals(name))
                .map(Dungeon::getItemDropPool)
                .findFirst()
                .orElse(null);
    }

    public Optional<List<Item>> simpleSimulationList(String dungeonName, Optional<Spec> spec) {
        List<Item> dungeonDropList = getDropList(dungeonName);
        if (dungeonDropList.isEmpty()) {
            return Optional.empty();
        }

        return Optional.ofNullable(simResultList(dungeonDropList, spec));
    }

    public Optional<Item> simpleSimulation(String dungeonName, Optional<Spec> spec) {
        List<Item> dungeonDropList = getDropList(dungeonName);

        if (dungeonDropList.isEmpty()) {
            return Optional.empty();
        }

        List<Item> result = simResultList(dungeonDropList, spec);

        if (!result.isEmpty()) {
            Random rand = new Random();
            int dropChance = rand.nextInt(5) + 1;

            if (dropChance <= 2) {
                int randomNumber = rand.nextInt(result.size());
                return Optional.of(result.get(randomNumber));
            }
        }
        return Optional.empty();
    }

    public List<Item> simResultList(List<Item> dungeonDropList, Optional<Spec> spec) {
        return dungeonDropList.stream().filter(item -> {

            if (spec.isEmpty()) {
                return false;
            }

            //Weapon Control
            if (item.getWeaponType() != Utils.WeaponType.NONE && !Utils.WeaponType.checkWeaponType(spec.get().getWeaponType(), item.getWeaponType())) {
                return false;
            }

            //Armor Control
            if (item.getArmorType() != Utils.ArmorType.NONE && !Utils.ArmorType.checkArmorType(spec.get().getArmorType(), item.getArmorType())) {
                return false;
            }

            //Primary Stat Control
            return item.getPrimaryStat() == Utils.PrimaryStat.ALL || item.getPrimaryStat() == spec.get().getPrimaryStat();

        }).toList();
    }
}
