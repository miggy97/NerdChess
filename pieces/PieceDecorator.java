package com.utad.pieces;


public abstract class PieceDecorator extends Piece {
    protected Piece piece;

    public abstract int getHp();

    public abstract int getAttackDmg();

    public abstract int getMagicDmg();

    public abstract String getName();

}
