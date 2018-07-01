package com.utad.pieces;

public class PieceBasic extends Piece {

    public PieceBasic(boolean upper) {
        this.upper = upper;
    }

    @Override
    public int specificAttack(int attackDmg) {
        return 0;
    }

    @Override
    public void specificDefense(int magicDmg) {
        //Do nothing (because is not an specific piece)
    }

    @Override
    public void setPiece(Piece piece) {
        //Do nothing (because is not an specific piece)
    }


}
