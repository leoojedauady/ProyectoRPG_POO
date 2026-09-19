/*
 * Esta clase sirve para definir objetos de tipo inventario
 * @author LeoMija
 */
package com.mycompany.proyectorpg_poo;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private int capacity;
    private List<Item> items;
    private int gold;
    private double weight;
    private double maxWeight;

    public Inventory(int capacity, double maxWeight) {
        this.capacity = capacity;
        this.maxWeight = maxWeight;
        this.items = new ArrayList<>();
        this.gold = 0;
        this.weight = 0;
    }

    public boolean addItem(Item item) {
        if (item == null) {
            return false;
        }

        if (isFull()) {
            System.out.println("Inventario lleno.");
            return false;
        }

        if (weight + item.getWeight() > maxWeight) {
            System.out.println("El objeto supera el peso máximo.");
            return false;
        }

        items.add(item);
        weight += item.getWeight();

        System.out.println(item.getName() + " añadido al inventario.");
        return true;
    }

    public boolean removeItem(Item item) {
        if (items.remove(item)) {
            calculateWeight();
            return true;
        }

        return false;
    }

    public Item findItem(String name) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }

        return null;
    }

    public void showItems() {
        System.out.println("\n--- INVENTARIO ---");

        for (Item item : items) {
            item.showInfo();
        }

        System.out.println("Peso: " + weight + "/" + maxWeight);
        System.out.println("Oro: " + gold);
    }

    public double calculateWeight() {
        weight = 0;

        for (Item item : items) {
            weight += item.getWeight();
        }

        return weight;
    }

    public boolean isFull() {
        return items.size() >= capacity;
    }

    public void addGold(int amount) {
        if (amount > 0) {
            gold += amount;
        }
    }

    public boolean removeGold(int amount) {
        if (amount > 0 && gold >= amount) {
            gold -= amount;
            return true;
        }

        return false;
    }
}
