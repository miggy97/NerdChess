package com.utad.pieces;

public class Titan extends PieceDecorator {
    public Titan(Piece piece) {
        this.piece = piece;
        this.upper = piece.upper;

        //Setting statistics
        this.hp = 400;
        this.attackDmg = 20;
        this.magicDmg = 0;

        //Setting name according to the team Upper/Lower
        this.name = (upper) ? "T" : "t";

        //Setting initial position according to the team Upper/Lower
        this.x = (upper) ? 0 : 4;
        this.y = 2;
    }

    @Override //3% of his actual hp turns into dmg
    public int specificAttack(int attackDmg) {
        return piece.specificAttack(attackDmg) + (int) (attackDmg + getHp() * 0.03);
    }

    @Override
    public void specificDefense(int magicDmg) {
        //No heal
    }

    public int getHp() {
        return (piece.getHp() + this.hp) - this.damageTaken;
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
