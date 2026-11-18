/**
 *
 * @author LeoMija
 */
package com.mycompany.proyectorpg_poo;

public class Warrior extends Character {

    private Weapon weapon;

    public Warrior(String name) {
        this(name, 1, 150);
    }

    public Warrior(String name, int level, int maxHealth) {
        super(name, level, maxHealth, 20, 12);
    }

    public void equipWeapon(Weapon weapon) {
        this.weapon = weapon;
        System.out.println(name + " equipó " + weapon.getName());
    }

    @Override
    public void attack(Character target) throws InvalidCharacterStateException {
        if (!isAlive()) {
            throw new InvalidCharacterStateException("El guerrero " + name + " no puede atacar porque está muerto.");
        }
        if (target != null && !target.isAlive()) {
            throw new InvalidCharacterStateException("No se puede atacar a " + target.getName() + " porque ya está muerto.");
        }

        int damage = strength;

        if (weapon != null) {
            damage += weapon.calculateDamage();
        }

        System.out.println(name + " ataca con fuerza.");
        if (target != null) {
            target.receiveDamage(damage);
        }
    }

    @Override
    public void defend(int damage) throws InvalidCharacterStateException {
        receiveDamage(damage);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    @Override
    public String getCharacterType() {
        return "Warrior";
    }

    @Override
    public String getSpecificInfo() {
        return "Arma equipada: " + (weapon != null ? weapon.getName() : "ninguna");
    }
}