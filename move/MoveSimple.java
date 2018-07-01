package com.utad.move;

import com.utad.Board;

public class MoveSimple implements MoveBehavior {
    private int[] range = new int[]{0, 1, 2, 3, 4};

    //Checks if the position of the possible action is out of range
    private boolean isInRange(int value) {
        boolean result = false;
        for (int n: range) {
            if (value == n) {
                return true;
            }
        }
        return false;
    }

    private boolean checkRange(int x, int y) {
        return (isInRange(x) && isInRange(y));
    }

    @Override
    public void calculateMove(int x, int y, Board board) {
        //Down
        if (checkRange(x + 1, y) && !board.getSquare(x + 1, y).isOccupied())
            board.getSquare(x + 1, y).setActive(true);
        //Right
        if (checkRange(x, y + 1) && !board.getSquare(x, y + 1).isOccupied())
            board.getSquare(x, y + 1).setActive(true);
        //Up
        if (checkRange(x - 1, y) && !board.getSquare(x - 1, y).isOccupied())
            board.getSquare(x - 1, y).setActive(true);
        //Left
        if (checkRange(x, y - 1) && !board.getSquare(x, y - 1).isOccupied())
            board.getSquare(x, y - 1).setActive(true);

    }
}
