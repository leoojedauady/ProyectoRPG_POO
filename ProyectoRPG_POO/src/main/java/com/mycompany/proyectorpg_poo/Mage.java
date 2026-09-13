/**
 *
 * @author LeoMija
 */
package com.mycompany.proyectorpg_poo;

public class Mage extends Character {

    int mana, maxMana;
    
    //constructor del Mage

    public Mage(int maxMana) {
        this.mana = maxMana;
        this.maxMana = maxMana;
    }
    
    
    //métodos especiales del Mage
    public void castSpell(Character target) {
        
    }
    
    public void restoreMana() {
        mana = maxMana;
        System.out.println("Se ha restaurado el mana al nivel maximo: " + mana + "/" + maxMana);
    }
    
    // métodos de ataque y defensa
    @Override
    public void attack(Character target) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void defend(int damage) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
