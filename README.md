# Dungeon-master

## Description

Dungeon-master is an object oriented java-console application of a RPG-game. In the game you can create heroes of different classes
(Archers, Barbarians, Wizards or Swashbucklers), each hero has a name, level, a set of attributes of type HeroAttributes, a list with valid weapon-types,
a list with valid armor-types and a HashMap with 4 different slots where the hero can equip items.

The game also allows you to create items (armors and weapons). Each armor has a name, an armor-type of type Enum, a slot of type Enum a required level, and
and armor attributes witch is of type HeroAttributes. All weapons has a name, a required level, a weapon-type of type enum and damage. Weapons and
armor can be equipped to a hero by calling the equipArmor or equipWeapon() - methods with an instantiated weapon or armor as in-parameter. The armor or
weapon-type must be included in the heroes list of valid weapons or valid armor or the program will throw a InvalidArmorException or a InvalidWeaponException.

The application also includes other methods like damage() witch can be called to get the total damage of a hero based on its level, hero attributes and equipped
items. TotalAttributes() is a method for getting a heros total hero attributes based on a heros level and items equipped and levelUp() is a method used
to increase a heros attribute by one and also increasing that heros heroattributes by different amount depending on what class the hero is of. Display() is
a method for displaying a heros class, name, total attributes, level, damage and equipment.

## Tests

To test the functionality Of the app a set of tests have been written using Maven and Junit. The tests can be run to se that different methods work as they should
and there are a pretty wide range of tests. assertTrue tests have been created for all classes creation, levelup, equip weapons and equip armor. assertThrowsExactly-
tests for trying to equip non-valid weapon-types are also written for all hero-classes. There are also tests for creating items (both weapons and armor). There is
also a general testing-class for testing of all general methods in the Hero.java-class. This class includes testing totalattributes while having different equipment
as well as damage while having different armor and weapon equipped.

## Installation

To run the application you need to install:

-- Java 20.0 --

-- Maven --

-- VSCode with Java-extension pack --

For testing: -- JUnit 5 --

## Contributors

This project is a private project based on an assignment from the noroff-accelerate-course.

## Authors and acknowledgment

The application is written by me, Linus Täreby alone.
