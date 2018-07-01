package com.utad;


public class Logic {
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


    //Prepare all the squares that can be attack
    public void prepareAttack(int x, int y, Board board) {
        //Down
        if (checkRange(x + 1, y) && board.getSquare(x + 1, y).isOccupied() && !board.isSameTeam(x + 1, y))
            board.getSquare(x + 1, y).setActive(true);
        //Down-Right
        if (checkRange(x + 1, y + 1) && board.getSquare(x + 1, y + 1).isOccupied() && !board.isSameTeam(x + 1, y + 1))
            board.getSquare(x + 1, y + 1).setActive(true);
        //Right
        if (checkRange(x, y + 1) && board.getSquare(x, y + 1).isOccupied() && !board.isSameTeam(x, y + 1))
            board.getSquare(x, y + 1).setActive(true);
        //Up-Right
        if (checkRange(x - 1, y + 1) && board.getSquare(x - 1, y + 1).isOccupied() && !board.isSameTeam(x - 1, y + 1))
            board.getSquare(x - 1, y + 1).setActive(true);
        //Up
        if (checkRange(x - 1, y) && board.getSquare(x - 1, y).isOccupied() && !board.isSameTeam(x - 1, y))
            board.getSquare(x - 1, y).setActive(true);
        //Up-Left
        if (checkRange(x - 1, y - 1) && board.getSquare(x - 1, y - 1).isOccupied() && !board.isSameTeam(x - 1, y - 1))
            board.getSquare(x - 1, y - 1).setActive(true);
        //Left
        if (checkRange(x, y - 1) && board.getSquare(x, y - 1).isOccupied() && !board.isSameTeam(x, y - 1))
            board.getSquare(x, y - 1).setActive(true);
        //Down-Left
        if (checkRange(x + 1, y - 1) && board.getSquare(x + 1, y - 1).isOccupied() && !board.isSameTeam(x + 1, y - 1))
            board.getSquare(x + 1, y - 1).setActive(true);
    }

    //Prepare all the squares that can be heal or merge
    public void prepareTeamAction(int x, int y, Board board) {
        //Down
        if (checkRange(x + 1, y) && board.getSquare(x + 1, y).isOccupied() && board.isSameTeam(x + 1, y))
            board.getSquare(x + 1, y).setActive(true);
        //Down-Right
        if (checkRange(x + 1, y + 1) && board.getSquare(x + 1, y + 1).isOccupied() && board.isSameTeam(x + 1, y + 1))
            board.getSquare(x + 1, y + 1).setActive(true);
        //Right
        if (checkRange(x, y + 1) && board.getSquare(x, y + 1).isOccupied() && board.isSameTeam(x, y + 1))
            board.getSquare(x, y + 1).setActive(true);
        //Up-Right
        if (checkRange(x - 1, y + 1) && board.getSquare(x - 1, y + 1).isOccupied() && board.isSameTeam(x - 1, y + 1))
            board.getSquare(x - 1, y + 1).setActive(true);
        //Up
        if (checkRange(x - 1, y) && board.getSquare(x - 1, y).isOccupied() && board.isSameTeam(x - 1, y))
            board.getSquare(x - 1, y).setActive(true);
        //Up-Left
        if (checkRange(x - 1, y - 1) && board.getSquare(x - 1, y - 1).isOccupied() && board.isSameTeam(x - 1, y - 1))
            board.getSquare(x - 1, y - 1).setActive(true);
        //Left
        if (checkRange(x, y - 1) && board.getSquare(x, y - 1).isOccupied() && board.isSameTeam(x, y - 1))
            board.getSquare(x, y - 1).setActive(true);
        //Down-Left
        if (checkRange(x + 1, y - 1) && board.getSquare(x + 1, y - 1).isOccupied() && board.isSameTeam(x + 1, y - 1))
            board.getSquare(x + 1, y - 1).setActive(true);

    }


    //Prepare all the squares that can be reproduce (all the squares empty around the piece)
    public void prepareReproduce(int x, int y, Board board) {
        //Down
        if (checkRange(x + 1, y) && !board.getSquare(x + 1, y).isOccupied())
            board.getSquare(x + 1, y).setActive(true);
        //Down-Right
        if (checkRange(x + 1, y + 1) && !board.getSquare(x + 1, y + 1).isOccupied())
            board.getSquare(x + 1, y + 1).setActive(true);
        //Right
        if (checkRange(x, y + 1) && !board.getSquare(x, y + 1).isOccupied())
            board.getSquare(x, y + 1).setActive(true);
        //Up-Right
        if (checkRange(x - 1, y + 1) && !board.getSquare(x - 1, y + 1).isOccupied())
            board.getSquare(x - 1, y + 1).setActive(true);
        //Up
        if (checkRange(x - 1, y) && !board.getSquare(x - 1, y).isOccupied())
            board.getSquare(x - 1, y).setActive(true);
        //Up-Left
        if (checkRange(x - 1, y - 1) && !board.getSquare(x - 1, y - 1).isOccupied())
            board.getSquare(x - 1, y - 1).setActive(true);
        //Left
        if (checkRange(x, y - 1) && !board.getSquare(x, y - 1).isOccupied())
            board.getSquare(x, y - 1).setActive(true);
        //Down-Left
        if (checkRange(x + 1, y - 1) && !board.getSquare(x + 1, y - 1).isOccupied())
            board.getSquare(x + 1, y - 1).setActive(true);
    }
}
