package com.utad.pieces;


public abstract class PieceDecorator extends Piece {
    protected Piece piece;

    public void setPiece(Piece piece) {
        this.piece = piece;
        this.damageTaken += piece.damageTaken;
    }

    public abstract int getHp();

    public abstract int getAttackDmg();

    public abstract int getMagicDmg();

    public abstract String getName();

}
