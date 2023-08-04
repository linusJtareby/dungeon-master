package com.example.classes.itemClasses;

import com.example.classes.Item;

public class Weapon extends Item {

    public WeaponType weaponType;
    public int weaponDamage;

    public Weapon(String name, ItemType itemType, Slots slot, WeaponType weaponType, int requiredLevel,
            int weaponDamage) {
        super(name, requiredLevel, slot);
        this.weaponType = weaponType;
        this.weaponDamage = weaponDamage;
    }
}
