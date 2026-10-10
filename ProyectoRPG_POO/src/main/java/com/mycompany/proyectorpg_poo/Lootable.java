/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.proyectorpg_poo;

/**
 * Interfaz para entidades que pueden recibir botín (ítems y oro).
 * 
 * @author LeoMija
 */
public interface Lootable {
    
    /**
     * Recibe un objeto y lo añade al inventario.
     * 
     * @param item Objeto a recibir.
     * @throws InventoryFullException Si el inventario está lleno o supera el peso máximo.
     */
    void receiveItem(Item item) throws InventoryFullException;

    /**
     * Recibe una cantidad de oro.
     * 
     * @param amount Cantidad de oro a recibir.
     */
    void receiveGold(int amount);
}