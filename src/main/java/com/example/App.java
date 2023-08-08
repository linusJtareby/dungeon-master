package com.example;

import com.example.classes.Hero;
import com.example.classes.heroClasses.Archer;

public class App {
    public static void main(String[] args) {
        Hero hero = new Archer("hej");
        hero.display();
    }
}
