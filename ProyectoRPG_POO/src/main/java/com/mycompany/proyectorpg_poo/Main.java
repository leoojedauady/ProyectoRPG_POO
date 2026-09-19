/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectorpg_poo;

/**
 *
 * @author LeoMija
 */
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("===== RPG OOP =====");

        // CREACIÓN DE PERSONAJES
        Warrior warrior = new Warrior("Arthas");
        Mage mage = new Mage("Merlín");
        Archer archer = new Archer("Legolas");
        Priest priest = new Priest("Anduin");

        // CREACIÓN DE OBJETOS
        Weapon sword = new Weapon(
                1, "Espada Legendaria", 5, 500, 35, "Espada"
        );

        Armor armor = new Armor(
                2, "Armadura de Acero", 10, 800, 20, "Pesada"
        );

        Potion potion = new Potion(
                3, "Poción de Vida", 100, "health", 40
        );

        Accessory ring = new Accessory(
                4, "Anillo de Poder", 300,
                10, 0, 5, 2
        );

        Consumable food = new Consumable(
                5, "Pan", 10, "Recupera energía"
        );

        // INVENTARIOS
        warrior.receiveItem(sword);
        warrior.receiveItem(armor);
        mage.receiveItem(potion);
        archer.receiveItem(ring);
        priest.receiveItem(food);

        // COMPOSICIÓN
        System.out.println("\n=== COMPOSICIÓN ===");
        warrior.getInventory().showItems();

        // EQUIPAMIENTO
        warrior.equipWeapon(sword);
        armor.use(warrior);

        // POLIMORFISMO DE PERSONAJES
        System.out.println("\n=== POLIMORFISMO DE PERSONAJES ===");

        List<Character> characters = new ArrayList<>();

        characters.add(warrior);
        characters.add(mage);
        characters.add(archer);
        characters.add(priest);

        for (Character character : characters) {
            character.showStats();
        }

        // ATAQUES
        System.out.println("\n=== ATAQUES ===");

        for (Character character : characters) {
            character.attack(warrior);
        }

        // HABILIDADES
        System.out.println("\n=== HABILIDADES ===");

        mage.castSpell(warrior);
        archer.rangedAttack(warrior);
        priest.heal(warrior);

        // USO POLIMÓRFICO DE ITEMS
        System.out.println("\n=== POLIMORFISMO DE ITEMS ===");

        List<Item> items = new ArrayList<>();

        items.add(sword);
        items.add(armor);
        items.add(potion);
        items.add(ring);
        items.add(food);

        for (Item item : items) {
            item.use(warrior);
        }

        // MISIÓN
        System.out.println("\n=== MISIÓN ===");

        Quest quest = new Quest(
                1,
                "El Castillo Perdido",
                "Explorar el castillo y recuperar el tesoro.",
                Difficulty.HARD,
                500,
                1000
        );

        // AGREGACIÓN
        quest.addParticipant(warrior);
        quest.addParticipant(mage);
        quest.addParticipant(archer);
        quest.addParticipant(priest);

        quest.showParticipants();

        // OBJETIVOS
        QuestObjective objective1 =
                new QuestObjective("Derrotar enemigos", 5);

        QuestObjective objective2 =
                new QuestObjective("Encontrar la llave", 1);

        QuestObjective objective3 =
                new QuestObjective("Recuperar el tesoro", 1);

        quest.addObjective(objective1);
        quest.addObjective(objective2);
        quest.addObjective(objective3);

        quest.showObjectives();

        // ACTUALIZAR OBJETIVOS
        System.out.println("\n=== ACTUALIZANDO OBJETIVOS ===");

        objective1.updateProgress(5);
        objective2.updateProgress(1);
        objective3.updateProgress(1);

        quest.showObjectives();

        // COMPLETAR MISIÓN
        quest.updateQuestStatus();

        if (quest.isCompleted()) {
            quest.completeQuest();
        }

        System.out.println("\n===== FIN DEL PROGRAMA =====");
    }
}
