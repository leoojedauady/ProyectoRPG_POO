/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectorpg_poo.controller;

import com.mycompany.proyectorpg_poo.Character;
import com.mycompany.proyectorpg_poo.Difficulty;
import com.mycompany.proyectorpg_poo.InvalidQuestOperationException;
import com.mycompany.proyectorpg_poo.Quest;
import com.mycompany.proyectorpg_poo.Repository;
import java.util.List;

/**
 *
 * @author LeoMija
 */
public class QuestController {

    private final Repository<Quest> quests;
    private final Repository<Character> characters;
    private int nextQuestId = 1;

    public QuestController(Repository<Quest> quests, Repository<Character> characters) {
        this.quests = quests;
        this.characters = characters;
    }

    public Quest registerQuest(String name, String description, Difficulty difficulty,
            int experienceReward, int goldReward) throws InvalidQuestOperationException {
        if (name == null || name.isBlank()) {
            throw new InvalidQuestOperationException("La misión debe tener un nombre.");
        }

        Quest quest = new Quest(nextQuestId++, name.trim(), description.trim(),
                difficulty, experienceReward, goldReward);
        quests.add(quest);
        return quest;
    }

    public void addParticipant(Quest quest, Character character) throws InvalidQuestOperationException {
        quest.addParticipant(character);
    }

    public void removeParticipant(Quest quest, Character character) throws InvalidQuestOperationException {
        quest.removeParticipant(character);
    }

    public void completeQuest(Quest quest) throws InvalidQuestOperationException {
        quest.completeQuest();
    }

    public void failQuest(Quest quest) throws InvalidQuestOperationException {
        quest.failQuest();
    }

    public List<Quest> getQuests() {
        return quests.getAll();
    }

    public Quest getQuest(int index) {
        return quests.get(index);
    }

    public List<Character> getCharacters() {
        return characters.getAll();
    }
}
