/**
 *
 * @author LeoMija
 */
package com.mycompany.proyectorpg_poo;

public interface RangedAttacker {
    
    void rangedAttack(Character target) throws InvalidCharacterStateException;
    boolean hasAmmunition();
    /*
    Métodos posibles:
• rangedAttack(Character target)
• hasAmmunition()
    
    */
}
