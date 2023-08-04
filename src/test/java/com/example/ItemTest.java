package com.example;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.example.classes.Item.ArmorTypes;
import com.example.classes.Item.ItemType;
import com.example.classes.Item.Slots;
import com.example.classes.Item.WeaponType;
import com.example.classes.itemClasses.Armor;
import com.example.classes.itemClasses.Weapon;

public class ItemTest {
    @Test
    public void testCreateItem_weapon() {
        Weapon hatchet = new Weapon("Hatchet", ItemType.Weapon, Slots.Weapon, WeaponType.Hatchet, 1, 10);
        String expectedName = "Hatchet";
        Slots expectedSlots = Slots.Weapon;
        WeaponType expectedWeaponType = WeaponType.Hatchet;
        int expectedRequiredLvl = 1;
        int expectedWeaponDmg = 10;

        assertTrue(hatchet.name == expectedName
                && hatchet.slot == expectedSlots
                && hatchet.weaponType == expectedWeaponType
                && hatchet.requiredLevel == expectedRequiredLvl
                && hatchet.weaponDamage == expectedWeaponDmg);
    }

    @Test
    public void testCreateItem_armor() {
        Armor plate = new Armor("Plate1", ArmorTypes.Plate, Slots.Body, 1, 2, 2, 2);
        String expectedName = "Plate1";
        ArmorTypes expectedArmorType = ArmorTypes.Plate;
        Slots expectedSlots = Slots.Body;
        int expectedRequiredLvl = 1;
        int expectedDexterity = 2;
        int expectedStrength = 2;
        int expectedIntelligence = 2;

        assertTrue(plate.name == expectedName
                && plate.slot == expectedSlots
                && plate.armorType == expectedArmorType
                && plate.requiredLevel == expectedRequiredLvl
                && plate.armorAttributes.strength == expectedStrength
                && plate.armorAttributes.intelligence == expectedIntelligence
                && plate.armorAttributes.dexterity == expectedDexterity);
    }
}
