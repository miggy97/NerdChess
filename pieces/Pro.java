package com.utad.pieces;

public class Pro extends PieceDecorator {

    public Pro(Piece piece) {
        this.piece = piece;
        this.upper = piece.upper;

        //Adding '*' to represent the piece as Pro
        this.name = "*";

        //Setting position of the actual piece
        this.x = this.piece.x;
        this.y = this.piece.y;
    }

    public int getHp() {
        return piece.getHp() + this.hp;
    }

    public int getAttackDmg() {
        //Increasing attack damage 50%
        return (int) (piece.getAttackDmg() * 1.5);
    }

    public int getMagicDmg() {

        //Increasing attack  damge 50%
        return (int) (piece.getMagicDmg() + 1 * 5);
    }

    public String getName() {
        return piece.getName() + this.name;
    }
}
