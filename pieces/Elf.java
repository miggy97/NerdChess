package com.utad.pieces;

public class Elf extends PieceDecorator {

    public Elf(Piece piece) {
        this.piece = piece;
        this.upper = piece.upper;

        //Setting statistics
        this.hp = 150;
        this.attackDmg = 20;
        this.magicDmg = 20;

        //Setting name according to the team Upper/Lower
        this.name = (upper) ? "E" : "e";

        //Setting initial position according to the team Upper/Lower
        this.x = (upper) ? 0 : 4;
        this.y = 1;
    }

    @Override //Hybrid damage (and if he is lower than 30 hp he will do double damage)
    public int specificAttack(int attackDmg) {

        if (getHp() < 30) {
            return piece.specificAttack(attackDmg) + attackDmg + getMagicDmg() * 2;
        } else return piece.specificAttack(attackDmg) + attackDmg + getMagicDmg();
    }

    @Override //He will heal 10hp as a defense
    public void specificDefense(int magicDmg) {
        setHealTaken(10);
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
