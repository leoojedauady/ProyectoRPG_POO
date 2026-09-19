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

public class Quest {

    private int id;
    private String name;
    private String description;
    private Difficulty difficulty;
    private Status status;
    private int experienceReward;
    private int goldReward;

    // AGREGACIÓN
    private List<Character> participants;

    private List<QuestObjective> objectives;

    public Quest(int id, String name, String description,
                 Difficulty difficulty,
                 int experienceReward, int goldReward) {

        this.id = id;
        this.name = name;
        this.description = description;
        this.difficulty = difficulty;
        this.experienceReward = experienceReward;
        this.goldReward = goldReward;

        this.status = Status.AVAILABLE;
        this.participants = new ArrayList<>();
        this.objectives = new ArrayList<>();
    }

    public void addParticipant(Character character) {
        if (character != null && !participants.contains(character)) {
            participants.add(character);
            status = Status.IN_PROGRESS;

            System.out.println(character.getName() +
                    " se unió a la misión.");
        }
    }

    public void removeParticipant(Character character) {
        participants.remove(character);
    }

    public void showParticipants() {
        System.out.println("\nParticipantes:");

        for (Character character : participants) {
            System.out.println("- " + character.getName());
        }
    }

    public void addObjective(QuestObjective objective) {
        if (objective != null) {
            objectives.add(objective);
        }
    }

    public void updateQuestStatus() {
        if (isCompleted()) {
            status = Status.COMPLETED;
        }
    }

    public boolean isCompleted() {
        if (objectives.isEmpty()) {
            return false;
        }

        for (QuestObjective objective : objectives) {
            if (!objective.isCompleted()) {
                return false;
            }
        }

        return true;
    }

    public void completeQuest() {
        if (isCompleted()) {
            status = Status.COMPLETED;
            giveRewards();
        }
    }

    public void failQuest() {
        status = Status.FAILED;
    }

    public void giveRewards() {
        for (Character character : participants) {
            character.receiveGold(goldReward);
        }

        System.out.println("Recompensas entregadas.");
        System.out.println("Experiencia: " + experienceReward);
        System.out.println("Oro: " + goldReward);
    }

    public void showObjectives() {
        System.out.println("\nObjetivos:");

        for (QuestObjective objective : objectives) {
            objective.showProgress();
        }
    }
}