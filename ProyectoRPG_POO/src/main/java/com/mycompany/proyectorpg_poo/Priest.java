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
    public void attack(Character target) throws InvalidCharacterStateException {
        if (!isAlive()) {
            throw new InvalidCharacterStateException("El sacerdote " + name + " no puede atacar porque está muerto.");
        }
        if (target != null && !target.isAlive()) {
            throw new InvalidCharacterStateException("No se puede atacar a " + target.getName() + " porque ya está muerto.");
        }

        System.out.println(name + " realiza un ataque sagrado.");
        if (target != null) {
            target.receiveDamage(strength + 8);
        }
    }

    @Override
    public void defend(int damage) throws InvalidCharacterStateException {
        receiveDamage(damage);
    }

    @Override
    public void heal(Character target) throws InvalidCharacterStateException {
        if (!isAlive()) {
            throw new InvalidCharacterStateException("El sacerdote " + name + " no puede curar porque está muerto.");
        }
        if (target == null) {
            throw new InvalidCharacterStateException("No se ha especificado un objetivo válido para curar.");
        }
        if (!target.isAlive()) {
            throw new InvalidCharacterStateException("No se puede curar a " + target.getName() + " porque está muerto.");
        }

        int healing = 30;

        System.out.println(name + " cura a " + target.getName());
        target.healHealth(healing);
    }
}