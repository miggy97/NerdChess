package com.utad.pieces;

public class Dragon extends PieceDecorator {

    public Dragon(Piece piece) {
        this.piece = piece;
        this.upper = piece.upper;

        //Setting statistics
        this.hp = 300;
        this.attackDmg = 20;
        this.magicDmg = 20;

        //Setting name according to the team Upper/Lower
        this.name = (upper) ? "D" : "d";

        //Setting initial position according to the team Upper/Lower
        this.x = (upper) ? 0 : 4;
        this.y = 4;
    }

    @Override//Hybrid damage 50% of his magic damage + all the attack damage
    public int specificAttack(int attackDmg) {
        return piece.specificAttack(attackDmg) + (int) (getMagicDmg() * 0.5);
    }

    @Override
    public void specificDefense(int magicDmg) {
        piece.specificDefense(getMagicDmg());
        takeHeal(magicDmg + attackDmg);
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
