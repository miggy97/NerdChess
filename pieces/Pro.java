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

    @Override
    public int specificAttack(int attackDmg) {
        return piece.specificAttack(attackDmg);
    }

    @Override
    public void specificDefense(int magicDmg) {
        piece.specificDefense(magicDmg);
    }

    public int getHp() {
        return (piece.getHp() + this.hp) - this.damageTaken;
    }

    public int getAttackDmg() {
        //Increasing attack damage 20%
        return (int) (piece.getAttackDmg() * 1.2);
    }

    public int getMagicDmg() {

        //Increasing attack  damge 20%
        return (int) (piece.getMagicDmg() * 1.2);
    }

    public String getName() {
        return piece.getName() + this.name;
    }
}
