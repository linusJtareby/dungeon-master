package com.example.classes.itemClasses;

import com.example.classes.HeroAttribute;
import com.example.classes.Item;

public class Armor extends Item {

    public ArmorTypes armorType;
    public HeroAttribute armorAttributes;

    public Armor(String name, ArmorTypes armorType, Slots slot, int requiredLevel, int strength, int dexterity,
            int intelligence) {
        super(name, requiredLevel, slot);
        this.armorType = armorType;
        this.armorAttributes = new HeroAttribute(strength, dexterity, intelligence);
    }
}
