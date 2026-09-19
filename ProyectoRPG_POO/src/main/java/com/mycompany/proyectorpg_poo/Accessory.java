package com.mycompany.proyectorpg_poo;

/**
 *
 * @author LeoMija
 */
public class Accessory extends Item {

    private int bonusHealth;
    private int bonusMana;
    private int bonusStrength;
    private int bonusDefense;

    public Accessory(int id, String name, int value,
                     int bonusHealth, int bonusMana,
                     int bonusStrength, int bonusDefense) {

        super(id, name, "Accesorio", 0.2, value);

        this.bonusHealth = bonusHealth;
        this.bonusMana = bonusMana;
        this.bonusStrength = bonusStrength;
        this.bonusDefense = bonusDefense;
    }

    @Override
    public void use(Character character) {
        System.out.println(character.getName() +
                " equipa el accesorio " + name);
    }
}