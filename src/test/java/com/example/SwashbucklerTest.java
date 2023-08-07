package com.example;

import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.example.classes.Hero;
import com.example.classes.Item.ArmorTypes;
import com.example.classes.Item.ItemType;
import com.example.classes.Item.Slots;
import com.example.classes.Item.WeaponType;
import com.example.classes.heroClasses.Swashbuckler;
import com.example.classes.itemClasses.Armor;
import com.example.classes.itemClasses.Weapon;
import com.example.exceptions.InvalidArmorException;
import com.example.exceptions.InvalidWeaponException;

public class SwashbucklerTest {
    @Test
    public void testCreate_swashbuckler() {
        Hero swashbuckler = new Swashbuckler("Swashbuckler1");
        int expectedDexterity = 6;
        int expectedIntelligence = 1;
        int expectedStrength = 2;
        String expectedName = "Swashbuckler1";

        assertTrue(swashbuckler.heroAttribute.dexterity == expectedDexterity
                && swashbuckler.heroAttribute.intelligence == expectedIntelligence
                && swashbuckler.heroAttribute.strength == expectedStrength
                && swashbuckler.getName() == expectedName);
    }

    @Test
    public void testLevelUp_swashbuckler() {
        Hero swashbuckler = new Swashbuckler("Swashbuckler1");
        swashbuckler.levelUp();
        int expectedIntelligence = 2;
        int expectedDexterity = 10;
        int expectedStrength = 3;
        int expectedLevel = 2;
        assertTrue(swashbuckler.heroAttribute.dexterity == expectedDexterity
                && swashbuckler.heroAttribute.intelligence == expectedIntelligence
                && swashbuckler.heroAttribute.strength == expectedStrength
                && swashbuckler.getLevel() == expectedLevel);
    }

    @Test
    public void testEquipArmor_swashbuckler() throws InvalidArmorException {
        Hero swashbuckler = new Swashbuckler("Swashbuckler1");
        Armor mail = new Armor("Mail1", ArmorTypes.Mail, Slots.Body, 1, 2, 2, 2);
        swashbuckler.equipArmor(Slots.Body, mail);
        assertTrue(swashbuckler.getEquipment().get(Slots.Body) == mail);
    }

    @Test
    public void testEquipWeapon_invalid_weaponType_swashbuckler() {
        Hero swashbuckler = new Swashbuckler("Swashbuckler1");
        Weapon bow = new Weapon("Bow1", ItemType.Weapon, Slots.Weapon, WeaponType.Bow, 1, 10);
        Weapon hatchet = new Weapon("Hatchet1", ItemType.Weapon, Slots.Weapon, WeaponType.Hatchet, 1, 10);

        assertThrowsExactly(InvalidWeaponException.class, () -> {
            swashbuckler.equipWeapon(bow);
            swashbuckler.equipWeapon(hatchet);
        });
    }

    @Test
    public void testEquipArmor_invalidArmorType_invalidArmorSlots_swashbuckler() {
        Hero swashbuckler = new Swashbuckler("Swashbuckler1");
        Armor plate = new Armor("Plate1", ArmorTypes.Plate, Slots.Body, 1, 2, 2, 2);
        Armor leather = new Armor("Leather1", ArmorTypes.Leather, Slots.Body, 1, 2, 2, 2);

        assertThrowsExactly(InvalidArmorException.class, () -> {
            swashbuckler.equipArmor(Slots.Body, plate);
            swashbuckler.equipArmor(Slots.Weapon, leather);
        });
    }
}
