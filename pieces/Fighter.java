package com.utad.pieces;

public class Fighter extends PieceDecorator {

    public Fighter(Piece piece) {
        this.piece = piece;
        this.upper = piece.upper;

        //Setting statistics
        this.hp = 200;
        this.attackDmg = 50;
        this.magicDmg = 10;

        //Setting name according to the team Upper/Lower
        this.name = (upper) ? "F" : "f";

        //Setting initial position according to the team Upper/Lower
        this.x = (upper) ? 0 : 4;
        this.y = 3;
    }

    @Override //If his hp is 200 or higher he does 20% more dmg
    public int specificAttack(int attackDmg) {
        if (getHp() >= 200) {
            return (int) ((piece.specificAttack(attackDmg) + attackDmg) * 1.2);
        } else {
            return piece.specificAttack(attackDmg) + attackDmg;
        }
    }

    @Override//All the magic dmg turns in to hp
    public void specificDefense(int magicDmg) {
        piece.specificDefense(magicDmg);
        takeHeal(magicDmg);
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
