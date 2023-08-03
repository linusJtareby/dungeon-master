package com.example.classes.heroClasses;

import com.example.classes.Hero;
import com.example.classes.Item.ArmorTypes;
import com.example.classes.Item.WeaponType;

public class Archer extends Hero {

    public Archer(String name) {
        super(name);
        this.heroAttribute.strength = 1;
        this.heroAttribute.dexterity = 7;
        this.heroAttribute.intelligence = 1;

        this.validArmorTypes.add(ArmorTypes.Leather);
        this.validArmorTypes.add(ArmorTypes.Mail);

        this.validWeaponTypes.add(WeaponType.Bow);
    }
}
