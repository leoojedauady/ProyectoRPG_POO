/*
 * Se define a los personajes
 * @author LeoMija
 */
package com.mycompany.proyectorpg_poo;


public abstract class Character implements Lootable {
    protected String name;
    protected int level;
    protected int health;
    protected int maxHealth;
    protected int strength;
    protected int defense;
    protected int experience;
    protected Inventory inventory;

    public Character(String name, int level, int maxHealth,
                     int strength, int defense) {
        this.name = name;
        this.level = level;
        this.health = maxHealth;
        this.maxHealth = maxHealth;
        this.strength = strength;
        this.defense = defense;
        this.experience = 0;

        // COMPOSICIÓN: el inventario pertenece al personaje
        this.inventory = new Inventory(20, 100.0);
    }

    public abstract void attack(Character target);

    public abstract void defend(int damage);

    public void levelUp() {
        level++;
        maxHealth += 20;
        health = maxHealth;
        strength += 5;
        defense += 3;

        System.out.println(name + " subió al nivel " + level);
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void receiveDamage(int damage) {
        int finalDamage = Math.max(0, damage - defense);
        health -= finalDamage;
        health = Math.max(health, 0);

        System.out.println(name + " recibió " + finalDamage +
                " de daño. Vida: " + health + "/" + maxHealth);
    }

    public void healHealth(int amount) {
        health += amount;
        health = Math.min(health, maxHealth);

        System.out.println(name + " recuperó " + amount +
                " de vida. Vida: " + health + "/" + maxHealth);
    }

    public void showStats() {
        System.out.println("\n--- " + name + " ---");
        System.out.println("Nivel: " + level);
        System.out.println("Vida: " + health + "/" + maxHealth);
        System.out.println("Fuerza: " + strength);
        System.out.println("Defensa: " + defense);
        System.out.println("Experiencia: " + experience);
    }

    public Inventory getInventory() {
        return inventory;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public int getDefense() {
        return defense;
    }

    @Override
    public void receiveItem(Item item) {
        inventory.addItem(item);
    }

    @Override
    public void receiveGold(int amount) {
        inventory.addGold(amount);
    }
}
