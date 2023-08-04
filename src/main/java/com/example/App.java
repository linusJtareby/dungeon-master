package com.example;

import com.example.classes.Hero;
import com.example.classes.Item;
import com.example.classes.Item.ItemType;
import com.example.classes.Item.Slots;
import com.example.classes.Item.WeaponType;
import com.example.classes.heroClasses.Archer;
import com.example.classes.heroClasses.Swashbuckler;
import com.example.classes.itemClasses.Weapon;

public class App {
    public static void main(String[] args) {
        Archer archer = new Archer("Archer1");
        Weapon bow = new Weapon("Bow1", ItemType.Weapon, Slots.Weapon, WeaponType.Bow, 1, 9);
        archer.equipWeapon(bow);
        archer.levelUp();
        archer.levelUp();

        System.out.println(archer.damage());
        // System.out.println(bow.weaponDamage);

    }
}
