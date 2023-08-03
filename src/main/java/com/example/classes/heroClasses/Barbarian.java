package com.example.classes.heroClasses;

import com.example.classes.Hero;
import com.example.classes.Item.ArmorTypes;
import com.example.classes.Item.WeaponType;

public class Barbarian extends Hero {

    public Barbarian(String name) {
        super(name);
        this.heroAttribute.strength = 5;
        this.heroAttribute.dexterity = 2;
        this.heroAttribute.intelligence = 1;

        this.validArmorTypes.add(ArmorTypes.Plate);
        this.validArmorTypes.add(ArmorTypes.Mail);

        this.validWeaponTypes.add(WeaponType.Hatchet);
        this.validWeaponTypes.add(WeaponType.Maces);
        this.validWeaponTypes.add(WeaponType.Sword);

    }
}
