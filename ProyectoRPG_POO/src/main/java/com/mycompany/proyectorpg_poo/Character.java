/*
 * Se define a los personajes
 * @author LeoMija
 */
package com.mycompany.proyectorpg_poo;

public abstract class Character {
    private String name;
    private int level;
    private int health;
    private int maxHealth;
    private Inventory inventory;
    private int experience;
    private int strength;
    private int defense;
    private int status;

    // constructor de character    
    
    
    // métodos del character
    abstract void attack(Character target);
    // falta definir comportamiento

    public abstract void defend(int damage);
    // falta definir comportamiento

    public void levelUp() {
        System.out.println("Has subido de nivel");
    }
    
    public boolean isAlive() {
        // falta definir comportamiento
        return health>0; // si su salud es mayor a 0 está vivo
        // de lo contrario está muerto
    }

    // modificamos un toString() para que liste los stats
    public String showStats() {
        return "Character{" + "name=" + name + ", level=" + level + ", health=" + health + ", maxHealth=" + maxHealth + ", inventory=" + inventory + ", experience=" + experience + ", strength=" + strength + ", defense=" + defense + ", status=" + status + '}';
    }
    
    
    
    
}
