package com.utad.pieces;

import com.utad.*;

//Decorator, Strategy, Template, State, Factory
public abstract class Piece {
    protected boolean upper; //This identifies the team ('Upper' or 'Lower')
    protected String name = "";
    //private boolean isPro = false; //Represented with '*'
    //private boolean isSuper = false; //Represented with letter of union (Example: WE)
    //private boolean isChild = false; //Represented with '+'
    protected int hp = 0; //Health Points
    protected int attackDmg = 0; //Attack Damage
    protected int magicDmg = 0; //Magic Damage
    protected int x;
    protected int y;

    public Piece() {

    }

    public int getAttackDmg() {
        return attackDmg;
    }

    public int getMagicDmg() {
        return magicDmg;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isUpper() {
        return upper;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
