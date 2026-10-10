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
    public void use(Character character) throws InvalidCharacterStateException {
        if (character == null) {
            throw new InvalidCharacterStateException("No se puede usar la poción sin un personaje objetivo.");
        }

        if (effectType.equalsIgnoreCase("health")) {
            character.healHealth(effectValue);
        } else {
            if (!character.isAlive()) {
                throw new InvalidCharacterStateException("No se puede aplicar el efecto de la poción porque " + character.getName() + " está muerto.");
            }
            System.out.println(
                    character.getName() +
                    " utiliza la poción de " + effectType
            );
        }
    }

    public String getEffectType() {
        return effectType;
    }

    public int getEffectValue() {
        return effectValue;
    }
}   