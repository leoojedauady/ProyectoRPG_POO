/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectorpg_poo.controller;

import com.mycompany.proyectorpg_poo.Accessory;
import com.mycompany.proyectorpg_poo.Armor;
import com.mycompany.proyectorpg_poo.Character;
import com.mycompany.proyectorpg_poo.Consumable;
import com.mycompany.proyectorpg_poo.Inventory;
import com.mycompany.proyectorpg_poo.InventoryFullException;
import com.mycompany.proyectorpg_poo.Item;
import com.mycompany.proyectorpg_poo.ItemNotFoundException;
import com.mycompany.proyectorpg_poo.Potion;
import com.mycompany.proyectorpg_poo.Repository;
import com.mycompany.proyectorpg_poo.Weapon;
import java.util.List;

/**
 *
 * @author LeoMija
 */
public class InventoryController {

    private final Repository<Character> characters;
    private int nextItemId = 1;

    public InventoryController(Repository<Character> characters) {
        this.characters = characters;
    }

    public List<Character> getCharacters() {
        return characters.getAll();
    }

    public List<Item> getItems(Character character) {
        return character.getInventory().getItems();
    }

    public void addWeapon(Character character, String name, double weight, int value,
            int damage, String weaponType) throws InventoryFullException {
        addItem(character, new Weapon(nextItemId, name, weight, value, damage, weaponType));
    }

    public void addArmor(Character character, String name, double weight, int value,
            int defense, String armorType) throws InventoryFullException {
        addItem(character, new Armor(nextItemId, name, weight, value, defense, armorType));
    }

    public void addPotion(Character character, String name, int value,
            String effectType, int effectValue) throws InventoryFullException {
        addItem(character, new Potion(nextItemId, name, value, effectType, effectValue));
    }

    public void addAccessory(Character character, String name, int value, int bonusHealth,
            int bonusMana, int bonusStrength, int bonusDefense) throws InventoryFullException {
        addItem(character, new Accessory(nextItemId, name, value, bonusHealth, bonusMana, bonusStrength, bonusDefense));
    }

    public void addConsumable(Character character, String name, int value, String effect)
            throws InventoryFullException {
        addItem(character, new Consumable(nextItemId, name, value, effect));
    }

    public void removeItem(Character character, Item item) throws ItemNotFoundException {
        character.getInventory().removeItem(item);
    }

    public String getSummary(Character character) {
        Inventory inventory = character.getInventory();
        return "Objetos: " + inventory.getItemCount() + "/" + inventory.getCapacity()
                + "   |   Peso: " + Math.round(inventory.getWeight() * 10) / 10.0 + "/" + inventory.getMaxWeight()
                + "   |   Oro: " + inventory.getGold();
    }

    private void addItem(Character character, Item item) throws InventoryFullException {
        character.receiveItem(item);
        nextItemId++;
    }
}
