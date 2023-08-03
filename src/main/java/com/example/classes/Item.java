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
}
