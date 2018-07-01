package com.utad.move;

import com.utad.Board;

public interface MoveBehavior {
    public void calculateMove(int x, int y, Board board);
}
