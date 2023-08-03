package com.example.classes.heroClasses;

import com.example.classes.Hero;
import com.example.classes.Item.ArmorTypes;
import com.example.classes.Item.WeaponType;

public class Wizard extends Hero {

    public Wizard(String name) {
        super(name);
        this.heroAttribute.strength = 1;
        this.heroAttribute.dexterity = 1;
        this.heroAttribute.intelligence = 8;
        this.validArmorTypes.add(ArmorTypes.Cloth);
        this.validWeaponTypes.add(WeaponType.Staff);
        this.validWeaponTypes.add(WeaponType.Wand);
    }
}
