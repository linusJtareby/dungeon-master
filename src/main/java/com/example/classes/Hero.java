package com.example.classes;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.classes.Item.ArmorTypes;
import com.example.classes.Item.Slots;
import com.example.classes.Item.WeaponType;
import com.example.classes.heroClasses.Archer;
import com.example.classes.heroClasses.Barbarian;
import com.example.classes.heroClasses.Swashbuckler;
import com.example.classes.heroClasses.Wizard;
import com.example.classes.itemClasses.Armor;
import com.example.classes.itemClasses.Weapon;

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
        this.level++;

        if (this instanceof Wizard) {
            this.heroAttribute.strength++;
            this.heroAttribute.dexterity++;
            this.heroAttribute.intelligence += 5;
        }
        if (this instanceof Archer) {
            this.heroAttribute.strength++;
            this.heroAttribute.dexterity += 7;
            this.heroAttribute.intelligence++;
        }
        if (this instanceof Swashbuckler) {
            this.heroAttribute.strength++;
            this.heroAttribute.dexterity += 4;
            this.heroAttribute.intelligence++;
        }
        if (this instanceof Barbarian) {
            this.heroAttribute.strength += 3;
            this.heroAttribute.dexterity += 2;
            this.heroAttribute.intelligence++;
        }
    }

    public void equipArmor(Slots slot, Armor armorToEquip) {
        if (slot == Slots.Weapon) {
            System.out.println("You can't equip armor to your weapon-slot");
        } else {
            if (armorToEquip.requiredLevel <= this.level) {
                if (this.validArmorTypes.contains(armorToEquip.armorType)) {
                    this.equipment.put(slot, armorToEquip);

                } else {
                    System.out.println("This armor is not valid for your class");
                }
            } else {
                System.out.println("You need to be level " + armorToEquip.requiredLevel + " to equip this item");
            }
        }
    }

    public void equipWeapon(Weapon weaponToEquip) {
        if (weaponToEquip.requiredLevel <= this.level) {
            if (this.validWeaponTypes.contains(weaponToEquip.weaponType)) {
                this.equipment.put(Slots.Weapon, weaponToEquip);
            } else {
                System.out.println("This weapon is not valid for your class");
            }
        } else {
            System.out.println("You need to be level " + weaponToEquip.requiredLevel + " to equip this item");
        }
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
