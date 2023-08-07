package com.example.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import com.example.classes.Item.ArmorTypes;
import com.example.classes.Item.Slots;
import com.example.classes.Item.WeaponType;
import com.example.classes.heroClasses.Archer;
import com.example.classes.heroClasses.Barbarian;
import com.example.classes.heroClasses.Swashbuckler;
import com.example.classes.heroClasses.Wizard;
import com.example.classes.itemClasses.Armor;
import com.example.classes.itemClasses.Weapon;
import com.example.exceptions.InvalidArmorException;
import com.example.exceptions.InvalidWeaponException;

public abstract class Hero {
    private String name;
    private int level;
    private HashMap<Slots, Item> equipment = new HashMap<Slots, Item>();
    public ArrayList<ArmorTypes> validArmorTypes = new ArrayList<ArmorTypes>();
    public ArrayList<WeaponType> validWeaponTypes = new ArrayList<WeaponType>();

    public HeroAttribute heroAttribute = new HeroAttribute(0, 0, 0);

    public Hero(String name) {
        this.name = name;
        this.level = 1;
        this.equipment.put(Slots.Weapon, null);
        this.equipment.put(Slots.Head, null);
        this.equipment.put(Slots.Body, null);
        this.equipment.put(Slots.Legs, null);

    }

    public int getLevel() {
        return level;
    }

    public HashMap<Slots, Item> getEquipment() {
        return equipment;
    }

    public String getName() {
        return name;
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
            this.heroAttribute.dexterity += 5;
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

    public void equipArmor(Armor armorToEquip) throws InvalidArmorException {

        if (armorToEquip.requiredLevel <= this.level) {
            if (this.validArmorTypes.contains(armorToEquip.armorType)) {
                this.equipment.put(armorToEquip.slot, armorToEquip);

            } else {
                throw new InvalidArmorException("This type of armor is not valid for your class");
            }
        } else {
            throw new InvalidArmorException(
                    "\"You need to be a level " + armorToEquip.requiredLevel + " to equip this weapon\"");
        }

    }

    public void equipWeapon(Weapon weaponToEquip) throws InvalidWeaponException {
        if (weaponToEquip.requiredLevel <= this.level) {
            if (this.validWeaponTypes.contains(weaponToEquip.weaponType)) {
                this.equipment.put(Slots.Weapon, weaponToEquip);
            } else {
                throw new InvalidWeaponException("\"This weapon is not valid for your class\"");
            }
        } else {
            throw new InvalidWeaponException(
                    "\"You need to be a level " + weaponToEquip.requiredLevel + " to equip this weapon\"");
        }
    }

    public int damage() {
        int heroDamage = 0;
        if (this instanceof Wizard) {
            heroDamage = (1 + this.totalAttribute().intelligence / 100);

        } else if (this instanceof Archer) {
            heroDamage = (1 + this.totalAttribute().dexterity / 100);

        } else if (this instanceof Swashbuckler) {
            heroDamage = (1 + this.totalAttribute().dexterity / 100);

        } else if (this instanceof Barbarian) {
            heroDamage = (1 + this.totalAttribute().strength / 100);
        }

        if (this.equipment.get(Slots.Weapon) != null) {
            Weapon equippedWeapon = (Weapon) this.equipment.get(Slots.Weapon);

            int totalDamage = heroDamage * equippedWeapon.weaponDamage;
            return totalDamage;

        } else {
            return heroDamage;
        }
    }

    public HeroAttribute totalAttribute() {

        HeroAttribute totalHeroAttribute = new HeroAttribute(0, 0, 0);

        for (Entry<Slots, Item> armorHash : this.equipment.entrySet()) {
            if (armorHash.getKey() != Slots.Weapon) {
                Armor armor = (Armor) armorHash.getValue();
                if (armor != null) {
                    totalHeroAttribute.dexterity += armor.armorAttributes.dexterity;
                    totalHeroAttribute.intelligence += armor.armorAttributes.intelligence;
                    totalHeroAttribute.strength += armor.armorAttributes.strength;
                }
            }
        }
        totalHeroAttribute.dexterity += this.heroAttribute.dexterity;
        totalHeroAttribute.intelligence += this.heroAttribute.intelligence;
        totalHeroAttribute.strength += this.heroAttribute.strength;

        return totalHeroAttribute;
    }

    public void display() {

        StringBuilder heroDetails = new StringBuilder();

        heroDetails.append(" Name: " + this.name
                + " Class: " + this.getClass().getSimpleName()
                + " Level: " + this.level
                + " Total strength: " + this.heroAttribute.strength
                + " Total dexterity: " + this.heroAttribute.dexterity
                + " Total intelligence: " + this.heroAttribute.intelligence
                + " Damage: " + this.damage()
                + " " + this.equipment.toString());

        System.out.println(heroDetails);
    }
}
