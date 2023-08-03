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

        // Casting type Weapon to the Item in the hashmap to be able to
        // get to the weapon attributes.
        Weapon equippedWeapon = (Weapon) this.equipment.get(Slots.Weapon);
        if (this instanceof Wizard) {
            heroDamage += (1 + this.heroAttribute.intelligence / 100) * equippedWeapon.weaponDamage;
            this.equipment.get(Slots.Weapon);
        }
        if (this instanceof Archer) {
            heroDamage += (1 + this.heroAttribute.dexterity / 100) * equippedWeapon.weaponDamage;

        }
        if (this instanceof Swashbuckler) {
            heroDamage += (1 + this.heroAttribute.dexterity / 100) * equippedWeapon.weaponDamage;

        }
        if (this instanceof Barbarian) {
            heroDamage += (1 + this.heroAttribute.strength / 100) * equippedWeapon.weaponDamage;
        }
        return heroDamage;
    }

    public int totalAttribute() {

        // Casting type armor to the Item in the hashmap to be able to
        // get to the armorattributes.
        Armor equippedHeadArmor = (Armor) this.equipment.get(Slots.Head);
        Armor equippedBodyArmor = (Armor) this.equipment.get(Slots.Body);
        Armor equippedLegArmor = (Armor) this.equipment.get(Slots.Weapon);
        for (int i = 0; i < this.equipment.size(); i++) {

        }

        int totalExtraAttributesHead = equippedHeadArmor.armorAttributes.dexterity
                + equippedHeadArmor.armorAttributes.intelligence + equippedHeadArmor.armorAttributes.strength;
        int totalExtraAttributesBody = equippedBodyArmor.armorAttributes.dexterity
                + equippedBodyArmor.armorAttributes.intelligence + equippedBodyArmor.armorAttributes.strength;
        int totalExtraAttributesLeg = equippedLegArmor.armorAttributes.dexterity
                + equippedLegArmor.armorAttributes.intelligence + equippedLegArmor.armorAttributes.strength;

        int totalExtraAttributes = totalExtraAttributesHead + totalExtraAttributesBody + totalExtraAttributesLeg;

        int totalAttributes = this.heroAttribute.dexterity + this.heroAttribute.intelligence
                + this.heroAttribute.strength
                + this.level
                + totalExtraAttributes;

        return totalAttributes;
    }

    public void display() {

        StringBuilder heroDetails = new StringBuilder();

        heroDetails.append(" Name: " + this.name
                + " Class: " + "heroClass"
                + " Level: " + this.level
                + " Total strength: " + this.heroAttribute.strength
                + " Total dexterity: " + this.heroAttribute.dexterity
                + " Total intelligence: " + this.heroAttribute.intelligence
                + " Damage: " + this.damage()
                + " " + this.equipment.toString());

        System.out.println(heroDetails);
    }

}
