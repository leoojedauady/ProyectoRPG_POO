/**
 *
 * @author LeoMija
 */
package com.mycompany.proyectorpg_poo;

public class Priest extends Character implements Healable {

    public Priest(String name) {
        super(name, 1, 100, 8, 8);
    }

    @Override
    public void attack(Character target) {
        System.out.println(name + " realiza un ataque sagrado.");
        target.receiveDamage(strength + 8);
    }

    @Override
    public void defend(int damage) {
        receiveDamage(damage);
    }

    @Override
    public void heal(Character target) {
        int healing = 30;

        System.out.println(name + " cura a " + target.getName());
        target.healHealth(healing);
    }
}
