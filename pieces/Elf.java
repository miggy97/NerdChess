package com.utad.pieces;

public class Elf extends PieceDecorator {

    public Elf(Piece piece) {
        this.piece = piece;
        this.upper = piece.upper;

        //Setting statistics
        this.hp = 100;
        this.attackDmg = 50;
        this.magicDmg = 50;

        //Setting name according to the team Upper/Lower
        this.name = (upper) ? "E" : "e";

        //Setting initial position according to the team Upper/Lower
        this.x = (upper) ? 0 : 4;
        this.y = 1;
    }

    public int getHp() {
        return piece.getHp() + this.hp;
    }

    public int getAttackDmg() {
        return piece.getAttackDmg() + this.attackDmg;
    }

    public int getMagicDmg() {
        return piece.getMagicDmg() + this.magicDmg;
    }

    public String getName() {
        return piece.getName() + this.name;
    }
}
