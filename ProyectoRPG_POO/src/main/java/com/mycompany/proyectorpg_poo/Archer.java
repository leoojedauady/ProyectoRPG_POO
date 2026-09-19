/**
 *
 * @author LeoMija
 */
package com.mycompany.proyectorpg_poo;

/*
- Utiliza arco y flechas.
- Puede realizar ataques a distancia.
- Puede disponer de una cantidad limitada de flechas.
*/
public class Archer extends Character implements RangedAttacker {

    private int arrows;
    private int range;

    public Archer(String name) {
        super(name, 1, 110, 17, 7);
        this.arrows = 10;
        this.range = 30;
    }

    @Override
    public void attack(Character target) {
        rangedAttack(target);
    }

    @Override
    public void rangedAttack(Character target) {
        if (!hasAmmunition()) {
            System.out.println(name + " no tiene flechas.");
            return;
        }

        arrows--;

        System.out.println(name + " dispara una flecha desde " +
                range + " metros.");

        target.receiveDamage(strength + 10);
    }

    @Override
    public boolean hasAmmunition() {
        return arrows > 0;
    }

    public void reload() {
        arrows = 10;
        System.out.println(name + " recargó sus flechas.");
    }

    @Override
    public void defend(int damage) {
        receiveDamage(damage);
    }
}
