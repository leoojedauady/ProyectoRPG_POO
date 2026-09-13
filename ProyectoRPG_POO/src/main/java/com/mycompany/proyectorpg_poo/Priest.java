/**
 *
 * @author LeoMija
 */
package com.mycompany.proyectorpg_poo;

public class Priest extends Character {
    
    private int healFactor;
    //método
    public void heal(Character target) {
        //checamos si al curar no nos estamos pasando del maxHealth del target
        if ((target.getHealth() + healFactor)<=target.getMaxHealth()) {
            target.setHealth(target.getHealth() + healFactor);
        } else { //si se pasa, simplemente el priest va a curar hasta maxHealth
            target.setHealth(target.getMaxHealth());
        }
    }

    @Override
    void attack(Character target) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void defend(int damage) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
