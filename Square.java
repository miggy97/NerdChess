package com.utad;

public class Square {
    //private int x;
    //private int y;

    private Piece piece;

    public Square() {
        this.piece = null;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public boolean isOccupied() {
        if (piece == null) return false;
        else return true;
    }

}
