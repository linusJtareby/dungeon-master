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
    public void testLevelUp_archer() {
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
    public void testEquipArmor_archer() {
        Hero archer = new Archer("Archer1");
        Armor mail = new Armor("Mail1", ArmorTypes.Mail, Slots.Body, 1, 2, 2, 2);
        archer.equipArmor(Slots.Body, mail);
        assertTrue(archer.getEquipment().get(Slots.Body) == mail);
    }

    @Test
    public void testEquipWeapon_invalid_weaponType_archer() {
        Hero archer = new Archer("Archer1");
        Weapon staff = new Weapon("Staff1", ItemType.Weapon, Slots.Weapon, WeaponType.Staff, 1, 10);
        assertThrowsExactly(IllegalAccessError.class, () -> {
            archer.equipWeapon(staff);
        });
    }

    @Test
    public void testEquipArmor_invalidArmorType_invalidArmorSlots_archer() {
        Hero archer = new Archer("Archer1");
        Armor plate = new Armor("Plate1", ArmorTypes.Plate, Slots.Body, 1, 2, 2, 2);
        Armor mail = new Armor("Mail1", ArmorTypes.Mail, Slots.Body, 1, 2, 2, 2);

        assertThrowsExactly(IllegalAccessError.class, () -> {
            archer.equipArmor(Slots.Body, plate);
            archer.equipArmor(Slots.Weapon, mail);
        });
    }

}
