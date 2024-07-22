package com.scamlet.dungeondropsimulator.services;

import com.scamlet.dungeondropsimulator.entities.CharacterClass;
import com.scamlet.dungeondropsimulator.entities.Spec;
import com.scamlet.dungeondropsimulator.entities.Utils;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CharacterService {

    private final List<CharacterClass> characterData;

    public CharacterService(List<CharacterClass> characterData) {
        this.characterData = characterData;
    }

    @PostConstruct
    public void init() {
        initPaladin();
    }

    public void initPaladin() {

        CharacterClass paladin = new CharacterClass();

        Spec retri = new Spec();
        retri.setName("Retribution");
        retri.setRole(Spec.Role.DPS);
        retri.setArmorType(Utils.ArmorType.PLATE);
        retri.setPrimaryStat(Utils.PrimaryStat.STRENGTH);
        retri.addWeaponType(Utils.WeaponType.SWORD_2H);
        retri.addWeaponType(Utils.WeaponType.POLEARM);
        retri.addWeaponType(Utils.WeaponType.MACE_2H);

        Spec holy = new Spec();
        holy.setName("Holy");
        holy.setRole(Spec.Role.HEALER);
        holy.setArmorType(Utils.ArmorType.PLATE);
        holy.setPrimaryStat(Utils.PrimaryStat.INTELLIGENCE);
        holy.addWeaponType(Utils.WeaponType.SWORD_1H);
        holy.addWeaponType(Utils.WeaponType.SHIELD);
        holy.addWeaponType(Utils.WeaponType.MACE_1H);

        Spec prot = new Spec();
        prot.setName("Protection");
        prot.setRole(Spec.Role.TANK);
        prot.setArmorType(Utils.ArmorType.PLATE);
        prot.setPrimaryStat(Utils.PrimaryStat.STRENGTH);
        prot.addWeaponType(Utils.WeaponType.SWORD_1H);
        prot.addWeaponType(Utils.WeaponType.SHIELD);
        prot.addWeaponType(Utils.WeaponType.MACE_1H);

        paladin.addSpec(retri);
        paladin.addSpec(holy);
        paladin.addSpec(prot);

        characterData.add(paladin);

    }

    public Spec findSpec(String name) {

        for (CharacterClass characterClass : characterData) {
            Set<Spec> tempSpecSet = characterClass.getSpec();
            for (Spec spec : tempSpecSet) {
                if (spec.getName().equals(name)) {
                    return spec;
                }
            }
        }

        return null;
    }



}
