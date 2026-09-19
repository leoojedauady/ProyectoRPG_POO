/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectorpg_poo;

/**
 *
 * @author leojeda
 */
public class Weapon extends Item {

    private int damage;
    private int durability;
    private String weaponType;

    public Weapon(int id, String name, double weight,
                  int value, int damage, String weaponType) {
        super(id, name, "Arma", weight, value);

        this.damage = damage;
        this.durability = 100;
        this.weaponType = weaponType;
    }

    @Override
    public void use(Character character) {
        System.out.println(character.getName() +
                " utiliza el arma " + name);
    }

    public int calculateDamage() {
        return damage;
    }
}
