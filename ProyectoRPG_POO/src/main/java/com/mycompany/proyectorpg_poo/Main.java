package com.mycompany.proyectorpg_poo;

public class Main {

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("   DEMOSTRACION DE MEJORAS DEL RPG (ADA 02)");
        System.out.println("==========================================\n");

        // 1. DEMOSTRACIÓN DE REPOSITORIO GENÉRICO Y EXCEPCIONES EN INVENTARIO
        System.out.println("--- 1. Prueba de Inventario y Repository<Item> ---");
        // Inventario con capacidad para 2 ítems y peso máximo de 10.0
        Inventory inventory = new Inventory(2, 10.0);

        try {
            // Se pasan los 6 parámetros requeridos: id, name, weight, value, damage/defense, type
            Weapon espada = new Weapon(1, "Espada de Hierro", 3.0, 50, 15, "Espada");
            Potion pocion = new Potion(2, "Pocion de Vida", 20, "health", 30);
            Armor armadura = new Armor(3, "Peto de Acero", 5.0, 100, 20, "Pesada");

            System.out.println("agregando primer objeto...");
            inventory.addItem(espada);

            System.out.println("agregando segundo objeto...");
            inventory.addItem(pocion);

            System.out.println("intentando agregar tercer objeto (debe lanzar InventoryFullException)...");
            inventory.addItem(armadura); // Esto genera la excepción por capacidad máxima

        } catch (InventoryFullException e) {
            System.out.println("[excepcion]: " + e.getMessage());
        }

        try {
            System.out.println("\nIntentando buscar un objeto que no existe...");
            inventory.findItem("Escudo de Madera"); // Lanza ItemNotFoundException
        } catch (ItemNotFoundException e) {
            System.out.println("[excepcion]: " + e.getMessage());
        }


        // 2. DEMOSTRACIÓN DE EXCEPCIONES DE ESTADO DE PERSONAJE
        System.out.println("\n--- 2. prueba de Estados Invalidos de Personaje ---");
        try {
            Warrior warrior = new Warrior("Aragorn");
            Mage mage = new Mage("Gandalf");

            System.out.println("simulando que el guerrero cae derrotado...");
            warrior.receiveDamage(200);

            System.out.println("intentando que el guerrero muerto ataque (debe lanzar InvalidCharacterStateException)...");
            warrior.attack(mage); // Lanza InvalidCharacterStateException

        } catch (InvalidCharacterStateException e) {
            System.out.println("[excepcion]: " + e.getMessage());
        }

        try {
            Warrior warrior = new Warrior("Boromir");
            Priest priest = new Priest("Elrond");

            warrior.receiveDamage(200); // Boromir muere

            System.out.println("\nintentando curar a un personaje muerto...");
            priest.heal(warrior); // Lanza InvalidCharacterStateException

        } catch (InvalidCharacterStateException e) {
            System.out.println("[excepcion]: " + e.getMessage());
        }


        // 3. DEMOSTRACIÓN DEL REPOSITORIO GENÉRICO CON OTRAS ENTIDADES
        System.out.println("\n--- 3. prueba de Repository<T> con Personajes ---");
        Repository<Character> party = new Repository<>();
        Warrior warrior = new Warrior("Conan");
        Mage mage = new Mage("Merlin");

        party.add(warrior);
        party.add(mage);

        System.out.println("numero de miembros en el grupo: " + party.size());
        
        // Uso del método genérico de búsqueda por criterio (Predicate)
        Character encontrado = party.findByCriteria(c -> c.getName().equalsIgnoreCase("Merlin"));
        if (encontrado != null) {
            System.out.println("Personaje encontrado mediante el metodo generico: " + encontrado.getName());
        }

        System.out.println("fin de las pruebas!");
 
    }
}