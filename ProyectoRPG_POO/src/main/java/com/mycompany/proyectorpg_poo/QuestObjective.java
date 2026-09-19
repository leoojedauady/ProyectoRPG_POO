package com.mycompany.proyectorpg_poo;

/**
 *
 * @author LeoMija
 */
public class QuestObjective {

    private String description;
    private int targetAmount;
    private int currentAmount;
    private boolean completed;

    public QuestObjective(String description, int targetAmount) {
        this.description = description;
        this.targetAmount = targetAmount;
        this.currentAmount = 0;
        this.completed = false;
    }

    public void updateProgress(int amount) {
        if (amount > 0) {
            currentAmount += amount;

            if (currentAmount >= targetAmount) {
                currentAmount = targetAmount;
                completed = true;
            }
        }
    }

    public boolean isCompleted() {
        return completed;
    }

    public void showProgress() {
        System.out.println(description + ": " +
                currentAmount + "/" + targetAmount);
    }
}
