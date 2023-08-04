package com.example;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.example.classes.Hero;
import com.example.classes.Item.ArmorTypes;
import com.example.classes.Item.ItemType;
import com.example.classes.Item.Slots;
import com.example.classes.Item.WeaponType;
import com.example.classes.heroClasses.Archer;
import com.example.classes.heroClasses.Barbarian;
import com.example.classes.heroClasses.Swashbuckler;
import com.example.classes.heroClasses.Wizard;
import com.example.classes.itemClasses.Armor;
import com.example.classes.itemClasses.Weapon;

public class HeroTest {

    @Test
    public void testArcherLevelUp() {
        Hero archer = new Archer("Archer1");
        archer.levelUp();
        int expectedLevel = 2;
        assertTrue(archer.getLevel() == expectedLevel);
    }

    @Test
    public void testArcherCreate_dexterity() {
        Hero archer = new Archer("Archer1");
        int expectedDexterity = 7;
        assertTrue(archer.heroAttribute.dexterity == expectedDexterity);
    }

    @Test
    public void testArcherCreate_strength() {
        Hero archer = new Archer("Archer1");
        int expectedStrength = 1;
        assertTrue(archer.heroAttribute.strength == expectedStrength);
    }

    @Test
    public void testArcherCreate_intelligence() {
        Hero archer = new Archer("Archer1");
        int expectedIntelligence = 1;
        assertTrue(archer.heroAttribute.intelligence == expectedIntelligence);
    }

    @Test
    public void testArcherLevelUp_intelligence() {
        Hero archer = new Archer("Archer1");
        archer.levelUp();
        int expectedIntelligence = 2;
        assertTrue(archer.heroAttribute.intelligence == expectedIntelligence);
    }

    @Test
    public void testArcherLevelUp_dexterity() {
        Hero archer = new Archer("Archer1");
        archer.levelUp();
        int expectedDexterity = 12;
        assertTrue(archer.heroAttribute.dexterity == expectedDexterity);
    }

    @Test
    public void testEquipWeapon_invalid_weaponType() {
        Hero wizard = new Wizard("Wizard1");
        Weapon bow = new Weapon("Bow1", ItemType.Weapon, Slots.Weapon, WeaponType.Bow, 1, 10);
        assertThrowsExactly(IllegalAccessError.class, () -> {
            wizard.equipWeapon(bow);
        });
    }

    @Test
    public void testEquipArmor_invalid_armorType() {
        Hero swashbuckler = new Swashbuckler("Swashbuckler1");
        Armor plate = new Armor("Plate1", ArmorTypes.Plate, Slots.Body, 1, 2, 2, 2);
        assertThrowsExactly(IllegalAccessError.class, () -> {
            swashbuckler.equipArmor(Slots.Body, plate);
        });
    }

    @Test
    public void testEquipArmor_invalid_level() {
        Hero barbarian = new Barbarian("Barbarian1");
        Armor plate = new Armor("Plate1", ArmorTypes.Plate, Slots.Body, 2, 2, 2, 2);
        assertThrowsExactly(IllegalAccessError.class, () -> {
            barbarian.equipArmor(Slots.Body, plate);
        });
    }

    @Test
    public void testTotalAttributes_equippedArmor_levelTwo() {
        Hero barbarian = new Barbarian("Barbarian1");
        Armor plate = new Armor("Plate1", ArmorTypes.Plate, Slots.Body, 2, 2, 2, 2);
        barbarian.levelUp();
        barbarian.equipArmor(Slots.Body, plate);
        assertTrue(barbarian.totalAttribute() == 5 + 3 + 2 + 2 + 1 + 1 + 2 + 2 + 2);
    }

    @Test
    public void testTotalAttributes_equippedTwoArmor_levelTwo() {
        Hero barbarian = new Barbarian("Barbarian1");
        Armor plate = new Armor("Plate1", ArmorTypes.Plate, Slots.Body, 2, 2, 2, 2);
        Armor mail = new Armor("Cloth1", ArmorTypes.Mail, Slots.Legs, 2, 6, 3, 2);

        barbarian.levelUp();
        barbarian.equipArmor(Slots.Body, plate);
        barbarian.equipArmor(Slots.Legs, mail);

        assertTrue(barbarian.totalAttribute() == 5 + 3 + 2 + 2 + 1 + 1 + 2 + 2 + 2 + 6 + 3 + 2);
    }

    @Test
    public void testTotalAttributes_noArmor_levelThree() {
        Hero barbarian = new Barbarian("Barbarian1");
        barbarian.levelUp();
        barbarian.levelUp();
        assertTrue(barbarian.totalAttribute() == 5 + 3 + 2 + 2 + 1 + 1 + 3 + 2 + 1);
    }

    @Test
    public void testDamage() {
        Swashbuckler swashbuckler = new Swashbuckler("Swashbuckler1");
        assertTrue(swashbuckler.damage() == 1 + swashbuckler.heroAttribute.dexterity / 100);
    }

    @Test
    public void testDamage_weaponEquipped() {
        Hero archer = new Archer("Archer1");
        Weapon bow = new Weapon("Bow1", ItemType.Weapon, Slots.Weapon, WeaponType.Bow, 1, 10);
        archer.equipWeapon(bow);
        assertTrue(archer.damage() == 10 * (1 + archer.heroAttribute.dexterity / 100));
    }

}
