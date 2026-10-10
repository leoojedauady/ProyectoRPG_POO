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
    public void use(Character character) throws InvalidCharacterStateException {
        if (character == null) {
            throw new InvalidCharacterStateException("No se puede usar el arma sin un personaje objetivo.");
        }
        if (!character.isAlive()) {
            throw new InvalidCharacterStateException("El personaje " + character.getName() + " está muerto y no puede usar el arma.");
        }

        System.out.println(character.getName() +
                " utiliza el arma " + name);
    }

    public int calculateDamage() {
        return damage;
    }

    public int getDamage() {
        return damage;
    }

    public int getDurability() {
        return durability;
    }

    public String getWeaponType() {
        return weaponType;
    }
}