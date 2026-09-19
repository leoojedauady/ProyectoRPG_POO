package com.mycompany.proyectorpg_poo;

/**
 *
 * @author LeoMija
 */
public class Potion extends Item {

    private String effectType;
    private int effectValue;

    public Potion(int id, String name, int value,
                  String effectType, int effectValue) {
        super(id, name, "Poción consumible", 0.5, value);

        this.effectType = effectType;
        this.effectValue = effectValue;
    }

    @Override
    public void use(Character character) {

        if (effectType.equalsIgnoreCase("health")) {
            character.healHealth(effectValue);
        } else {
            System.out.println(
                    character.getName() +
                    " utiliza la poción de " + effectType
            );
        }
    }
}