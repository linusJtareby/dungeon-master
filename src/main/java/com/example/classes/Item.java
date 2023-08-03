package com.example.classes;

public abstract class Item {
    public enum ItemType {
        Weapon, Armor
    }

    public enum WeaponType {
        Hatchet,
        Bow,
        Dagger,
        Maces,
        Staff,
        Sword,
        Wand
    }

    public enum ArmorTypes {
        Cloth,
        Leather,
        Mail,
        Plate
    }

    public enum Slots {
        Weapon,
        Head,
        Body,
        Legs
    }

    public String name;
    public int requiredLevel;
    public Slots slot;

    public Item(String name, int requiredLevel, Slots slot) {
        this.name = name;
        this.requiredLevel = requiredLevel;
        this.slot = slot;
    }

    @Override
    public String toString() {
        return name;
    }
}
