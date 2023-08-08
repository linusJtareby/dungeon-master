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
import com.example.exceptions.InvalidArmorException;
import com.example.exceptions.InvalidWeaponException;

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
    public void levelUp_barbarian__lvl2_heroAttributes_increased() {
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
    public void equipArmor_barbarian_weaponShouldBeEquippedToHero() throws InvalidArmorException {
        Hero barbarian = new Barbarian("Barbarian1");
        Armor mail = new Armor("Mail1", ArmorTypes.Mail, Slots.Body, 1, 2, 2, 2);
        barbarian.equipArmor(mail);
        assertTrue(barbarian.getEquipment().get(Slots.Body) == mail);
    }

    @Test
    public void equipWeapon_weaponType_barbarian__shouldThrowInvalidWeaponException() {
        Hero barbarian = new Barbarian("Barbarian1");
        Weapon bow = new Weapon("Bow1", ItemType.Weapon, Slots.Weapon, WeaponType.Bow, 1, 10);
        Weapon dagger = new Weapon("Dagger1", ItemType.Weapon, Slots.Weapon, WeaponType.Dagger, 1, 10);

        assertThrowsExactly(InvalidWeaponException.class, () -> {
            barbarian.equipWeapon(bow);
            barbarian.equipWeapon(dagger);
        });
    }

    @Test
    public void equipArmor_invalidArmorType_barbarian_shouldThrowInvalidArmorException() {
        Hero barbarian = new Barbarian("Barbarian1");
        Armor leather = new Armor("Leather1", ArmorTypes.Leather, Slots.Body, 1, 2, 2, 2);

        assertThrowsExactly(InvalidArmorException.class, () -> {
            barbarian.equipArmor(leather);
        });
    }
}
