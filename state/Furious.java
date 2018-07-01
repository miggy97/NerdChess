package com.utad.state;


import com.utad.pieces.Piece;

public class Furious extends State {

    public Furious(Piece currentPiece) {
        this.currentPiece = currentPiece;
    }

    //Damage a 50% more
    public boolean attack(int damage, Piece enemyPiece) {
        enemyPiece.takeDamage((int) (damage * 1.5));
        this.currentPiece.setState(currentPiece.getSane());
        return true;
    }

    //Heal a 50% more
    public boolean heal(Piece allyPiece) {
        int heal = (int) (currentPiece.getMagicDmg() * 1.5);
        allyPiece.takeHeal(heal);
        this.currentPiece.setState(currentPiece.getSane());
        return true;
    }

    public void takeDamage(int damage) {
        this.currentPiece.setDamageTaken(damage);
        //Execute defense
        this.currentPiece.ExecuteDefense();
        //Change State to Sane
        this.currentPiece.setState(currentPiece.getSane());
    }

    public void takeHeal(int heal) {
        this.currentPiece.setHealTaken(heal);
        //Stay in furious
    }
}
