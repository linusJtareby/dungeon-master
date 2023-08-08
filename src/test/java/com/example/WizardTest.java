package com.example;

import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.example.classes.Hero;
import com.example.classes.Item.ArmorTypes;
import com.example.classes.Item.ItemType;
import com.example.classes.Item.Slots;
import com.example.classes.Item.WeaponType;
import com.example.classes.heroClasses.Wizard;
import com.example.classes.itemClasses.Armor;
import com.example.classes.itemClasses.Weapon;
import com.example.exceptions.InvalidArmorException;
import com.example.exceptions.InvalidWeaponException;

public class WizardTest {

    @Test
    public void testCreate_wizard() {
        Hero wizard = new Wizard("Wizard1");
        int expectedDexterity = 1;
        int expectedIntelligence = 8;
        int expectedStrength = 1;
        String expectedName = "Wizard1";

        assertTrue(wizard.heroAttribute.dexterity == expectedDexterity
                && wizard.heroAttribute.intelligence == expectedIntelligence
                && wizard.heroAttribute.strength == expectedStrength
                && wizard.getName() == expectedName);
    }

    @Test
    public void levelUp_archer__lvl2_heroAttributes_increased() {
        Hero wizard = new Wizard("Wizard1");
        wizard.levelUp();
        int expectedIntelligence = 13;
        int expectedDexterity = 2;
        int expectedStrength = 2;
        int expectedLevel = 2;
        assertTrue(wizard.heroAttribute.intelligence == expectedIntelligence
                && wizard.heroAttribute.dexterity == expectedDexterity
                && wizard.heroAttribute.strength == expectedStrength
                && wizard.getLevel() == expectedLevel);
    }

    @Test
    public void equipArmor_wizard_weaponShouldBeEquippedToHero() throws InvalidArmorException {
        Hero wizard = new Wizard("Wizard1");
        Armor cloth = new Armor("Cloth1", ArmorTypes.Cloth, Slots.Body, 1, 2, 2, 2);
        wizard.equipArmor(cloth);
        assertTrue(wizard.getEquipment().get(Slots.Body) == cloth);
    }

    @Test
    public void equipWeapon_weaponType_wizard_shouldThrowInvalidWeaponException() {
        Hero wizard = new Wizard("Wizard1");
        Weapon bow = new Weapon("Bow1", ItemType.Weapon, Slots.Weapon, WeaponType.Bow, 1, 10);
        Weapon dagger = new Weapon("Dagger1", ItemType.Weapon, Slots.Weapon, WeaponType.Dagger, 1, 10);

        assertThrowsExactly(InvalidWeaponException.class, () -> {
            wizard.equipWeapon(bow);
            wizard.equipWeapon(dagger);
        });
    }

    @Test
    public void equipArmor_invalidArmorType_wizard_shouldThrowInvalidArmorException() {
        Hero wizard = new Wizard("Wizard1");
        Armor leather = new Armor("Leather1", ArmorTypes.Leather, Slots.Body, 1, 2, 2, 2);

        assertThrowsExactly(InvalidArmorException.class, () -> {
            wizard.equipArmor(leather);
        });
    }
}
