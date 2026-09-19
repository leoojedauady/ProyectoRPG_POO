package com.mycompany.proyectorpg_poo;

/**
 *
 * @author LeoMija
 */
public class Consumable extends Item {

    private String effect;

    public Consumable(int id, String name, int value,
                      String effect) {
        super(id, name, "Objeto consumible", 0.3, value);
        this.effect = effect;
    }

    @Override
    public void use(Character character) {
        System.out.println(character.getName() +
                " consume " + name +
                ". Efecto: " + effect);
    }
}
