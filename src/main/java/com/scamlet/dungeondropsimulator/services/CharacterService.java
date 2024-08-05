package com.scamlet.dungeondropsimulator.services;

import com.scamlet.dungeondropsimulator.entities.CharacterClass;
import com.scamlet.dungeondropsimulator.entities.Spec;
import com.scamlet.dungeondropsimulator.entities.Utils;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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

        Spec retribution = new Spec();
        retribution.setName("Retribution");
        retribution.setRole(Spec.Role.DPS);
        retribution.setArmorType(Utils.ArmorType.PLATE);
        retribution.setPrimaryStat(Utils.PrimaryStat.STRENGTH);
        retribution.addWeaponType(Utils.WeaponType.SWORD_2H);
        retribution.addWeaponType(Utils.WeaponType.POLEARM);
        retribution.addWeaponType(Utils.WeaponType.MACE_2H);
        retribution.addWeaponType(Utils.WeaponType.AXE_2H);

        Spec holy = new Spec();
        holy.setName("Holy");
        holy.setRole(Spec.Role.HEALER);
        holy.setArmorType(Utils.ArmorType.PLATE);
        holy.setPrimaryStat(Utils.PrimaryStat.INTELLIGENCE);
        holy.addWeaponType(Utils.WeaponType.SWORD_1H);
        holy.addWeaponType(Utils.WeaponType.SHIELD);
        holy.addWeaponType(Utils.WeaponType.MACE_1H);

        Spec protection = new Spec();
        protection.setName("Protection");
        protection.setRole(Spec.Role.TANK);
        protection.setArmorType(Utils.ArmorType.PLATE);
        protection.setPrimaryStat(Utils.PrimaryStat.STRENGTH);
        protection.addWeaponType(Utils.WeaponType.SWORD_1H);
        protection.addWeaponType(Utils.WeaponType.SHIELD);
        protection.addWeaponType(Utils.WeaponType.MACE_1H);

        paladin.addSpec(retribution);
        paladin.addSpec(holy);
        paladin.addSpec(protection);

        characterData.add(paladin);

    }

    public Optional<Spec> findSpec(String name) {
        return characterData.stream()
                .flatMap(characterClass -> characterClass.getSpec().stream())
                .filter(spec -> spec.getName().equals(name))
                .findFirst();
    }


}
