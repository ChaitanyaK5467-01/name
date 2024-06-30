package com.lld.magicalArena.service;

import com.lld.magicalArena.entity.Dice;
import com.lld.magicalArena.entity.Player;

public class Arena {
    private Player player1;
    private Player player2;
    private Dice attackingDice;
    private Dice defendingDice;

    public Arena(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.attackingDice = new Dice();
        this.defendingDice = new Dice();
    }

    public void fight() {
        Player attacker = (player1.getHealth() < player2.getHealth()) ? player1 : player2;
        Player defender = (attacker == player1) ? player2 : player1;

        while (attacker.isAlive() && defender.isAlive()) {
            takeTurn(attacker, defender);
            Player temp = attacker;
            attacker = defender;
            defender = temp;
        }

        if (player1.isAlive()) {
            System.out.println("Player 1 wins!");
        } else {
            System.out.println("Player 2 wins!");
        }
    }

    private void takeTurn(Player attacker, Player defender) {
        int attackRoll = attackingDice.roll();
        int defendRoll = defendingDice.roll();

        int attackDamage = attacker.getAttack() * attackRoll;
        int defendStrength = defender.getStrength() * defendRoll;

        int damageToDefender = Math.max(0, attackDamage - defendStrength);
        defender.reduceHealth(damageToDefender);

        System.out.println("Attacker rolls " + attackRoll + ", Defender rolls " + defendRoll);
        System.out.println("Attacker damage: " + attackDamage + ", Defender defense: " + defendStrength);
        System.out.println("Defender health reduced by " + damageToDefender + " to " + defender.getHealth());
        System.out.println("");
    }
}