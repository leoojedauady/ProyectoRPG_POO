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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
    
    
}
