package com.utad;

import com.utad.pieces.Piece;

public class Square {
    //private int x;
    //private int y;

    private Piece piece;
    private boolean isActive; //Determine if the square can be use

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

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isActive() {
        return isActive;
    }
}
