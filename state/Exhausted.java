package com.utad.state;


import com.utad.pieces.Piece;

public class Exhausted extends State {

    public Exhausted(Piece currentPiece) {
        this.currentPiece = currentPiece;
    }

    //Damage a 50% less
    public boolean attack(int damage, Piece enemyPiece) {
        enemyPiece.takeDamage((int) (damage * 0.5));
        this.currentPiece.setState(currentPiece.getSane());
        return true;
    }

    //Heal a 50% less
    public boolean heal(Piece allyPiece) {
        int heal = (int) (currentPiece.getMagicDmg() * 0.5);
        allyPiece.takeHeal(heal);
        this.currentPiece.setState(currentPiece.getSane());
        return true;
    }

    public void takeDamage(int damage) {
        this.currentPiece.setDamageTaken(damage);
        //Execute defense
        this.currentPiece.ExecuteDefense();
        //Stay in Exhausted
    }

    public void takeHeal(int heal) {
        this.currentPiece.setHealTaken(heal);
        //Change State to Sane
        this.currentPiece.setState(currentPiece.getSane());
    }

}
