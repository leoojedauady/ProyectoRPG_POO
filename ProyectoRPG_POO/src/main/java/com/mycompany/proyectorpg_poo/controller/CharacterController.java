/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectorpg_poo.controller;

import com.mycompany.proyectorpg_poo.Archer;
import com.mycompany.proyectorpg_poo.Character;
import com.mycompany.proyectorpg_poo.InvalidCharacterStateException;
import com.mycompany.proyectorpg_poo.Mage;
import com.mycompany.proyectorpg_poo.Priest;
import com.mycompany.proyectorpg_poo.Repository;
import com.mycompany.proyectorpg_poo.Warrior;
import java.util.List;

/**
 *
 * @author LeoMija
 */
public class CharacterController {

    private final Repository<Character> characters;

    public CharacterController(Repository<Character> characters) {
        this.characters = characters;
    }

    public Character registerCharacter(String name, String type, int level, String healthText)
            throws InvalidCharacterStateException {
        if (name == null || name.isBlank()) {
            throw new InvalidCharacterStateException("El personaje debe tener un nombre.");
        }
        if (level < 1 || level > 100) {
            throw new InvalidCharacterStateException("El nivel debe estar entre 1 y 100.");
        }

        int health;
        try {
            health = Integer.parseInt(healthText.trim());
        } catch (NumberFormatException e) {
            throw new InvalidCharacterStateException("Los puntos de salud deben ser un número entero.");
        }
        if (health <= 0) {
            throw new InvalidCharacterStateException("Los puntos de salud deben ser mayores a 0.");
        }

        // se crea el objeto de la clase concreta, no uno generico
        Character character;
        switch (type) {
            case "Warrior":
                character = new Warrior(name.trim(), level, health);
                break;
            case "Mage":
                character = new Mage(name.trim(), level, health);
                break;
            case "Archer":
                character = new Archer(name.trim(), level, health);
                break;
            case "Priest":
                character = new Priest(name.trim(), level, health);
                break;
            default:
                throw new InvalidCharacterStateException("Tipo de personaje no válido: " + type);
        }

        characters.add(character);
        return character;
    }

    public void attack(Character attacker, Character target) throws InvalidCharacterStateException {
        if (attacker == null || target == null) {
            throw new InvalidCharacterStateException("Selecciona un atacante y un objetivo.");
        }
        if (attacker == target) {
            throw new InvalidCharacterStateException(attacker.getName() + " no puede atacarse a sí mismo.");
        }

        attacker.attack(target);
    }

    public List<Character> getCharacters() {
        return characters.getAll();
    }

    public Character getCharacter(int index) {
        return characters.get(index);
    }
}
