package com.example.classes;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.classes.Item.ArmorTypes;
import com.example.classes.Item.Slots;
import com.example.classes.Item.WeaponType;

public abstract class Hero {
    private String name;
    private int level;
    private HashMap<Slots, Item> equipment = new HashMap<Slots, Item>();
    public ArrayList<ArmorTypes> validArmorTypes = new ArrayList<ArmorTypes>();
    public ArrayList<WeaponType> validWeaponTypes = new ArrayList<WeaponType>();

    private int strength;
    private int dexterity;
    private int intelligence;
    public HeroAttribute heroAttribute = new HeroAttribute(strength, dexterity, intelligence);

    public Hero(String name) {
        this.name = name;
        this.level = 1;
        this.equipment.put(Slots.Weapon, null);
        this.equipment.put(Slots.Head, null);
        this.equipment.put(Slots.Body, null);
        this.equipment.put(Slots.Legs, null);
    }

    // Methods
    public void levelUp() {

    }

    public void equipWeapon() {

    }

    public int damage() {
        int heroDamage = 0;

        return heroDamage;
    }

    public int totalAttribute() {
        int totalAttributes = 0;

        return totalAttributes;
    }

    public void display() {

    }

}
