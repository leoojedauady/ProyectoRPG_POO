/**
 *
 * @author LeoMija
 */
package com.mycompany.proyectorpg_poo;

public class Mage extends Character implements MagicCaster {

    private int mana;
    private int maxMana;

    public Mage(String name) {
        super(name, 1, 100, 10, 5);
        this.maxMana = 120;
        this.mana = maxMana;
    }

    @Override
    public void attack(Character target) throws InvalidCharacterStateException {
        if (!isAlive()) {
            throw new InvalidCharacterStateException("El mago " + name + " no puede atacar porque está muerto.");
        }
        if (target != null && !target.isAlive()) {
            throw new InvalidCharacterStateException("No se puede atacar a " + target.getName() + " porque ya está muerto.");
        }

        if (hasMana()) {
            castSpell(target);
        } else {
            System.out.println(name + " no tiene suficiente maná.");
        }
    }

    @Override
    public void castSpell(Character target) throws InvalidCharacterStateException {
        if (!isAlive()) {
            throw new InvalidCharacterStateException("El mago " + name + " no puede lanzar hechizos porque está muerto.");
        }

        if (mana >= 20) {
            int damage = strength + 30;
            mana -= 20;

            System.out.println(name + " lanza una bola de fuego.");
            if (target != null) {
                target.receiveDamage(damage);
            }
        }
    }

    @Override
    public boolean hasMana() {
        return mana >= 20;
    }

    public void restoreMana() {
        mana = maxMana;
        System.out.println(name + " restauró su maná.");
    }

    @Override
    public void defend(int damage) throws InvalidCharacterStateException {
        receiveDamage(damage);
    }
}