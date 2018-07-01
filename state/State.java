package com.utad.state;


import com.utad.Board;
import com.utad.Square;
import com.utad.pieces.Piece;


public abstract class State {
    protected Piece currentPiece;

    public abstract boolean attack(int damage, Piece enemyPiece);

    public abstract boolean heal(Piece allyPiece);

    public boolean merge(Square square, Board board) {
        if (square.getPiece().getName().length() != 1) {
            System.out.println("Error! Solo puedes combinar las piezas normales");
            return false;
        } else {
            board.executeMerge(square.getPiece());
            return true;
        }
    }

    public boolean reproduce(int x, int y, Board board) {
        //If it's not pro return false
        if (currentPiece.getName().length() != 2 || currentPiece.getName().charAt(1) != '*') {
            System.out.println("Error! La pieza tiene que ser Pro (Ejemplo D*)");
            return false;
        }

        //If the team upper didn't reproduce yet
        if (board.isTurn() && !board.isUpperReproduce()) {
            board.executeReproduce(x, y);
            return true;
        }
        //If the team lower didn't reproduce yet
        else if (!board.isTurn() && !board.isLowerReproduce()) {
            board.executeReproduce(x, y);
            return true;
        }
        System.out.println("Error! Solo te puede reproducir una vez");
        return false;
    }

    //Receive and action
    public abstract void takeDamage(int damage);

    public abstract void takeHeal(int heal);
}
