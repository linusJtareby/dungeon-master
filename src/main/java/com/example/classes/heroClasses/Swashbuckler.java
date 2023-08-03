package com.example.classes.heroClasses;

import com.example.classes.Hero;
import com.example.classes.Item.ArmorTypes;
import com.example.classes.Item.WeaponType;

public class Swashbuckler extends Hero {

    public Swashbuckler(String name) {
        super(name);
        this.heroAttribute.strength = 2;
        this.heroAttribute.dexterity = 6;
        this.heroAttribute.intelligence = 1;

        this.validArmorTypes.add(ArmorTypes.Leather);
        this.validArmorTypes.add(ArmorTypes.Mail);

        this.validWeaponTypes.add(WeaponType.Dagger);
        this.validWeaponTypes.add(WeaponType.Sword);
    }
}
