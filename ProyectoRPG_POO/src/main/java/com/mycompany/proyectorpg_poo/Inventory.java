/*
 * Esta clase sirve para definir objetos de tipo inventario
 * @author LeoMija
 */
package com.mycompany.proyectorpg_poo;

public class Inventory {

    private int capacity;
    private Repository<Item> items; // Se reemplaza List<Item> por Repository<Item>
    private int gold;
    private double weight;
    private double maxWeight;

    public Inventory(int capacity, double maxWeight) {
        this.capacity = capacity;
        this.maxWeight = maxWeight;
        this.items = new Repository<>();
        this.gold = 0;
        this.weight = 0;
    }

    /**
     * Agrega un objeto al inventario.
     * 
     * @param item Objeto a agregar.
     * @throws InventoryFullException Si el inventario está lleno o supera el peso máximo.
     */
    public void addItem(Item item) throws InventoryFullException {
        if (item == null) {
            return;
        }

        if (isFull()) {
            throw new InventoryFullException("El inventario esta lleno. Capacidad maxima: " + capacity);
        }

        if (weight + item.getWeight() > maxWeight) {
            throw new InventoryFullException("El objeto '" + item.getName() + "' supera el peso maximo permitido (" + maxWeight + ").");
        }

        items.add(item);
        weight += item.getWeight();

        System.out.println(item.getName() + " agregado al inventario.");
    }

    /**
     * Elimina un objeto del inventario.
     * 
     * @param item Objeto a eliminar.
     * @throws ItemNotFoundException Si el objeto no existe en el inventario.
     */
    public void removeItem(Item item) throws ItemNotFoundException {
        if (!items.remove(item)) {
            throw new ItemNotFoundException("El objeto no se encuentra en el inventario.");
        }
        calculateWeight();
    }

    /**
     * Busca un objeto por su nombre aprovechando el método genérico por criterio.
     * 
     * @param name Nombre del objeto a buscar.
     * @return El objeto encontrado.
     * @throws ItemNotFoundException Si no se encuentra el objeto.
     */
    public Item findItem(String name) throws ItemNotFoundException {
        Item found = items.findByCriteria(item -> item.getName().equalsIgnoreCase(name));
        if (found == null) {
            throw new ItemNotFoundException("El objeto '" + name + "' no fue encontrado en el inventario.");
        }
        return found;
    }

    public void showItems() {
        System.out.println("\n--- INVENTARIO ---");

        for (Item item : items.getAll()) {
            item.showInfo();
        }

        System.out.println("Peso: " + weight + "/" + maxWeight);
        System.out.println("Oro: " + gold);
    }

    public double calculateWeight() {
        weight = 0;

        for (Item item : items.getAll()) {
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

    // Getters
    public int getGold() {
        return gold;
    }

    public double getWeight() {
        return weight;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public int getCapacity() {
        return capacity;
    }
}