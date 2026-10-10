/**
 *
 * @author LeoMija
 */
package com.mycompany.proyectorpg_poo;

public interface MagicCaster {
    
    /**
     * Lanza un hechizo sobre un objetivo.
     * 
     * @param target Personaje objetivo del hechizo.
     * @throws InvalidCharacterStateException Si el lanzador o el objetivo están muertos.
     */
    void castSpell(Character target) throws InvalidCharacterStateException;

    boolean hasMana();
}