/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectorpg_poo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author LeoMija
 */

public class Repository<T> {
    private List<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public boolean remove(T item) {
        return items.remove(item);
    }

    public T get(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        }
        return null;
    }

    public int size() {
        return items.size();
    }

    public List<T> getAll() {
        return new ArrayList<>(items);
    }

    // método de búsqueda genérica por criterio
    public <U> T findByCriteria(Predicate<T> predicate) {
        for (T item : items) {
            if (predicate.test(item)) {
                return item;
            }
        }
        return null;
    }
}
