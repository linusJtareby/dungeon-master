package com.example;

import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.example.classes.Hero;
import com.example.classes.Item.ArmorTypes;
import com.example.classes.Item.ItemType;
import com.example.classes.Item.Slots;
import com.example.classes.Item.WeaponType;
import com.example.classes.heroClasses.Barbarian;
import com.example.classes.itemClasses.Armor;
import com.example.classes.itemClasses.Weapon;

public class BarbarianTest {

    @Test
    public void testCreate_barbarian() {
        Hero barbarian = new Barbarian("Barbarian1");
        int expectedDexterity = 2;
        int expectedIntelligence = 1;
        int expectedStrength = 5;
        String expectedName = "Barbarian1";

        assertTrue(barbarian.heroAttribute.dexterity == expectedDexterity
                && barbarian.heroAttribute.intelligence == expectedIntelligence
                && barbarian.heroAttribute.strength == expectedStrength
                && barbarian.getName() == expectedName);
    }

    @Test
    public void testLevelUp_barbarian() {
        Hero barbarian = new Barbarian("Barbarian1");
        barbarian.levelUp();
        int expectedIntelligence = 2;
        int expectedDexterity = 4;
        int expectedStrength = 8;
        int expectedLevel = 2;
        assertTrue(barbarian.heroAttribute.dexterity == expectedDexterity
                && barbarian.heroAttribute.intelligence == expectedIntelligence
                && barbarian.heroAttribute.strength == expectedStrength
                && barbarian.getLevel() == expectedLevel);
    }

    @Test
    public void testEquipArmor_barbarian() {
        Hero barbarian = new Barbarian("Barbarian1");
        Armor mail = new Armor("Mail1", ArmorTypes.Mail, Slots.Body, 1, 2, 2, 2);
        barbarian.equipArmor(Slots.Body, mail);
        assertTrue(barbarian.getEquipment().get(Slots.Body) == mail);
    }

    @Test
    public void testEquipWeapon_invalid_weaponType_barbarian() {
        Hero barbarian = new Barbarian("Barbarian1");
        Weapon bow = new Weapon("Bow1", ItemType.Weapon, Slots.Weapon, WeaponType.Bow, 1, 10);
        Weapon dagger = new Weapon("Dagger1", ItemType.Weapon, Slots.Weapon, WeaponType.Dagger, 1, 10);

        assertThrowsExactly(IllegalAccessError.class, () -> {
            barbarian.equipWeapon(bow);
            barbarian.equipWeapon(dagger);
        });
    }

    @Test
    public void testEquipArmor_invalidArmorType_invalidArmorSlots_barbarian() {
        Hero barbarian = new Barbarian("Barbarian1");
        Armor plate = new Armor("Plate1", ArmorTypes.Plate, Slots.Body, 1, 2, 2, 2);
        Armor leather = new Armor("Leather1", ArmorTypes.Leather, Slots.Body, 1, 2, 2, 2);

        assertThrowsExactly(IllegalAccessError.class, () -> {
            barbarian.equipArmor(Slots.Body, leather);
            barbarian.equipArmor(Slots.Weapon, plate);
        });
    }
}
