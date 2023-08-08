package com.example;

import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.example.classes.Hero;
import com.example.classes.Item.ArmorTypes;
import com.example.classes.Item.ItemType;
import com.example.classes.Item.Slots;
import com.example.classes.Item.WeaponType;
import com.example.classes.heroClasses.Archer;
import com.example.classes.itemClasses.Armor;
import com.example.classes.itemClasses.Weapon;
import com.example.exceptions.InvalidArmorException;
import com.example.exceptions.InvalidWeaponException;

public class ArcherTest {

    @Test
    public void testCreate_archer() {
        Hero archer = new Archer("Archer1");
        int expectedDexterity = 7;
        int expectedIntelligence = 1;
        int expectedStrength = 1;
        String expectedName = "Archer1";

        assertTrue(archer.heroAttribute.dexterity == expectedDexterity
                && archer.heroAttribute.intelligence == expectedIntelligence
                && archer.heroAttribute.strength == expectedStrength
                && archer.getName() == expectedName);
    }

    @Test
    public void levelUp_archer_lvl2_heroAttributes_increased() {
        Hero archer = new Archer("Archer1");
        archer.levelUp();
        int expectedIntelligence = 2;
        int expectedDexterity = 12;
        int expectedStrength = 2;
        int expectedLevel = 2;
        assertTrue(archer.heroAttribute.dexterity == expectedDexterity
                && archer.heroAttribute.intelligence == expectedIntelligence
                && archer.heroAttribute.strength == expectedStrength
                && archer.getLevel() == expectedLevel);
    }

    @Test
    public void equipArmor_archer__weaponShouldBeEquippedToHero() throws InvalidArmorException {
        Hero archer = new Archer("Archer1");
        Armor mail = new Armor("Mail1", ArmorTypes.Mail, Slots.Body, 1, 2, 2, 2);
        archer.equipArmor(mail);
        assertTrue(archer.getEquipment().get(Slots.Body) == mail);
    }

    @Test
    public void equipWeapon_weaponType_archer_shouldThrowInvalidWeaponException() {
        Hero archer = new Archer("Archer1");
        Weapon staff = new Weapon("Staff1", ItemType.Weapon, Slots.Weapon, WeaponType.Staff, 1, 10);
        assertThrowsExactly(InvalidWeaponException.class, () -> {
            archer.equipWeapon(staff);
        });
    }

    @Test
    public void equipArmor_invalidArmorType_archer_shouldThrowInvalidArmorException() {
        Hero archer = new Archer("Archer1");
        Armor plate = new Armor("Plate1", ArmorTypes.Plate, Slots.Body, 1, 2, 2, 2);

        assertThrowsExactly(InvalidArmorException.class, () -> {
            archer.equipArmor(plate);
        });
    }

}
