package com.utad.state;

import com.utad.pieces.Piece;

public class Sane extends State {

    public Sane(Piece currentPiece){
        this.currentPiece = currentPiece;
    }

    public boolean attack(int damage, Piece enemyPiece){
        enemyPiece.takeDamage(damage);
        return true;
    }

    public boolean heal(Piece allyPiece) {
        int heal = currentPiece.getMagicDmg();
        allyPiece.takeHeal(heal);
        return true;
    }

    public void takeDamage(int damage) {
        this.currentPiece.setDamageTaken(damage);
        //Defense
        this.currentPiece.ExecuteDefense();
        //Change State to Exhausted
        this.currentPiece.setState(currentPiece.getExhausted());
    }

    public void takeHeal(int heal) {
        this.currentPiece.setHealTaken(heal);
        //Change State to Furious
        this.currentPiece.setState(currentPiece.getFurious());
    }
}
