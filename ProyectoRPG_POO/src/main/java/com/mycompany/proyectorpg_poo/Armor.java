/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectorpg_poo;

/**
 *
 * @author LeoMija
 */
public class Armor extends Item {

    private int defense;
    private int durability;
    private String armorType;

    public Armor(int id, String name, double weight,
                 int value, int defense, String armorType) {
        super(id, name, "Armadura", weight, value);

        this.defense = defense;
        this.durability = 100;
        this.armorType = armorType;
    }

    @Override
    public void use(Character character) {
        System.out.println(character.getName() +
                " equipa " + name);
    }

    public int calculateDefense() {
        return defense;
    }
}
