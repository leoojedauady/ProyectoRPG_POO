/**
 *
 * @author LeoMija
 */
package com.mycompany.proyectorpg_poo;

public class Warrior extends Character {

    private Weapon weapon;

    public Warrior(String name) {
        super(name, 1, 150, 20, 12);
    }

    public void equipWeapon(Weapon weapon) {
        this.weapon = weapon;
        System.out.println(name + " equipó " + weapon.getName());
    }

    @Override
    public void attack(Character target) {
        int damage = strength;

        if (weapon != null) {
            damage += weapon.calculateDamage();
        }

        System.out.println(name + " ataca con fuerza.");
        target.receiveDamage(damage);
    }

    @Override
    public void defend(int damage) {
        receiveDamage(damage);
    }
}
