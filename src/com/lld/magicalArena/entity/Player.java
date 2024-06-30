package com.lld.magicalArena.entity;

public class Player {
    private int health;
    private int strength;
    private int attack;

    public Player(int health, int strength, int attack) {
        this.health = health;
        this.strength = strength;
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public void reduceHealth(int amount) {
        this.health -= amount;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    public int getStrength() {
        return strength;
    }

    public int getAttack() {
        return attack;
    }

    public boolean isAlive() {
        return this.health > 0;
    }
}