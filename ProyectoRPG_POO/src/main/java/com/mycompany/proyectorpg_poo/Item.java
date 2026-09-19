/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectorpg_poo;

/**
 *
 * @author LeoMija
 */
public abstract class Item {

    protected int id;
    protected String name;
    protected String description;
    protected double weight;
    protected int value;

    public Item(int id, String name, String description,
                double weight, int value) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.value = value;
    }

    public abstract void use(Character character);

    public void showInfo() {
        System.out.println(
                name + " | Peso: " + weight +
                " | Valor: " + value
        );
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }
}
