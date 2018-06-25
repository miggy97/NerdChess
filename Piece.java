package com.utad;

//Decorator, Strategy, Template, State, Factory
public class Piece {
    private boolean upper; //This identifies the team ('Upper' or 'Lower')
    private String name;
    //private boolean isPro = false; //Represented with '*'
    //private boolean isSuper = false; //Represented with letter of union (Example: WE)
    //private boolean isChild = false; //Represented with '+'
    private int hp = 100;//Health Points
    private int x;
    private int y;

    public Piece(boolean upper, String name, int x, int y) {
        this.upper = upper;
        this.name = name;
        this.x = x;
        this.y = y;
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

    public String getName() {
        return name;
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
